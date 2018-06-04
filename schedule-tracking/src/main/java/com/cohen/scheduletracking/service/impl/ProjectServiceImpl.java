package com.cohen.scheduletracking.service.impl;

import com.cohen.scheduletracking.dao.CommonMapper;
import com.cohen.scheduletracking.dao.ProjectMapper;
import com.cohen.scheduletracking.dao.TaskMapper;
import com.cohen.scheduletracking.entity.*;
import com.cohen.scheduletracking.service.EmployeeService;
import com.cohen.scheduletracking.service.ProjectService;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 保存当前项目信息，并把此项目绑定到负责人
     */
    @Override
    public Integer save(Project project, HttpSession session) {
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        // 给Project填充其余属性
        project.setSchedule("0%");// 项目进度
        project.setStatus("0");// 是否完成
        project.setDeleted("0");// 是否已删除
        project.setCreateUser(user.getId());// 创建人
        project.setCreateTime(new Date());// 创建日期
        // 执行插入
        int returnValue = projectMapper.insert(project);
        commonMapper.insertEmpProject(project.getManagerId(), project.getId(), "1");

        return returnValue;
    }

    @Override
    public Integer saveFile(String fileName,String filePath, Integer id, Integer flg) {
        Map<String, Object> map = new HashMap<>();
        switch (flg) {
            case 1:// 项目文件
                map.put("pid", id);
                map.put("tid", 0);
                break;
            case 2:// 任务文件
                map.put("pid", 0);
                map.put("tid", id);
                break;
            default:
                map.put("pid", id);
                map.put("tid", 0);
        }
        map.put("fileName", fileName);
        map.put("filePath", filePath);

        return commonMapper.saveFile(map);
    }

    @Override
    public MessageBody listFiles(MessageBody msg, Integer pid) {
        Map<String, Object> map = new HashMap<>();
        map.put("pid", pid);
        List<File> files = commonMapper.listFiles(map);
        if(files == null){
            files = new ArrayList<>();
        }
        msg.setStatus("1");
        msg.setBody("查询成功！");
        msg.setData(files);
        return msg;
    }

    @Override
    public MessageBody deleteFiles(MessageBody msg, String fileName, String filePath, Integer pid) {
        Map<String, Object> map = new HashMap<>();
        map.put("pid", pid);
        map.put("fileName", fileName);
        map.put("filePath", filePath);
        commonMapper.deleteFiles(map);
        delete(new java.io.File(filePath, fileName));
        msg.setStatus("1");
        msg.setBody("删除成功！");
        return msg;
    }

    /**
     * 递归删除文件
     */
    private void delete(java.io.File file) {
        if(file.isFile()){
            file.delete();
        }else{
            for (java.io.File f : file.listFiles()) {
                delete(f);
            }
        }
    }

    /**
     * 检索当前用户所有的项目
     *
     * @param msg
     * @param session
     * @return
     */
    @Override
    public MessageBody list(MessageBody msg, HttpSession session) {
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        List<EmpProject> empProjects = commonMapper.queryByEmpId(user.getId());// 员工所属项目
        List<Integer> proIds = new ArrayList<>();
        for (EmpProject ep :
                empProjects) {
            if (!proIds.contains(ep.getProId())) {
                proIds.add(ep.getProId());
            }
        }
        List<Project> list = null;
        if (proIds == null || proIds.size() == 0) {
            list = new ArrayList<>();
        } else {
            list = projectMapper.listByProjectId(proIds);// 查询出当前用户关联的项目
        }
        if (list.size() > 0) {// 如果有项目信息，统计一下项目的参与人数
            for (Project p : list) {
                List<EmpProject> eps = commonMapper.queryByProId(p.getId());
                p.setPeopleNum(eps.size());
            }
        }
        if (list != null) {
            msg.setStatus("1");// 检索成功！
            msg.setBody("检索成功！");
        } else {
            msg.setStatus("0");// 数据不存在！
            msg.setBody("检索失败！数据不存在！");
            list = new ArrayList<>();
        }
        msg.setData(list);

        return msg;
    }

    @Override
    public MessageBody getEmpByProId(int pid, MessageBody msg) {
        List<EmpProject> empProjects = commonMapper.queryByProId(pid);
        List<Integer> empIds = new ArrayList<>();
        for (EmpProject ep :
                empProjects) {
            if (!empIds.contains(ep.getEmpId())) {
                empIds.add(ep.getEmpId());
            }
        }
        List<Employee> employees = employeeService.queryById(empIds);
        Map<String, Object> data = new HashMap<>();
        data.put("total", employees.size());
        data.put("employees", employees);
        msg.setData(data);
        msg.setStatus("1");
        msg.setBody("检索成功！");

        return msg;
    }

    @Override
    public MessageBody getProjectById(int id, MessageBody msg) {
        Project project = projectMapper.getProjectById(id);
        if (project != null) {
            List<Task> tasks = taskMapper.listByProId(project.getId());
            msg.setStatus("1");
            msg.setBody("数据回显成功！");
            Map<String, Object> map = new HashMap<>();
            map.put("project", project);
            map.put("tasks", tasks);
            msg.setData(map);
        } else {
            msg.setStatus("0");
            msg.setBody("数据不存在！");
        }
        return msg;
    }

    @Override
    public MessageBody checkLevel(int pid, HttpSession session, MessageBody msg) {
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        boolean b = false;
        if (user != null) {
            Project project = projectMapper.getProjectById(pid);
            if (user.getLevel() == 3) {// 部门以上的领导
                msg.setStatus("2");
                msg.setBody("权限足够！");
            } else if (user.getLevel() == 1) {// 普通员工
                if (user.getId() == project.getManagerId()) {// 如果是管理员，则有权编辑
                    msg.setStatus("1");
                    msg.setBody("权限足够！");
                } else {
                    msg.setStatus("-1");
                    msg.setBody("权限不足！");
                }
            } else {// 部门级领导
                if (user.getId() == project.getManagerId() || user.getId() == project.getCreateUser()) {// 是管理或者创建者
                    msg.setStatus("1");
                    msg.setBody("权限足够！");
                } else {
                    b = false;
                    msg.setStatus("-1");
                    msg.setBody("权限不足！");
                }
            }
        } else {
            msg.setStatus("0");
            msg.setBody("未登录！");
        }

        return msg;
    }

    /**
     * 设置任务为审核状态
     *
     * @param id
     * @param msg
     * @param session
     * @return
     */
    @Override
    public MessageBody examine(int id, MessageBody msg, HttpSession session) {
        Project project = projectMapper.getProjectById(id);
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        // 封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("endTime", new Date());
        params.put("updateUser", user.getId());
        params.put("updateTime", new Date());
        boolean b = false;
        if (project != null && project.getId() > 0) {// 若该任务有效，则执行后续操作
            // 判断当前用户是否为项目的管理者
            if (project.getCreateUser() == user.getId() || project.getManagerId() == user.getId()) {
                // 是该项目的管理者
                params.put("status", "2");// 审核状态
                b = true;
            } else {
                // 不是管理者
                msg.setStatus("-1");
                msg.setBody("权限不足！");
            }
        } else {// 若该任务无效，则返回错误信息
            msg.setStatus("0");
            msg.setBody("项目不存在！");
        }
        if (b) {
            if (projectMapper.finish(params) == 1) {// 设置状态为审核
                // 将项目下属任务批量设置为审核
                List<Integer> ids = taskMapper.listTaskIdByProId(project.getId());// 获取当前项目所有的关联ID
                taskMapper.changeStatuBatch(ids, "2");// 批量设置任务为审核状态
                msg.setStatus("1");
                msg.setBody("设置成功！");
            } else {
                msg.setStatus("0");
                msg.setBody("设置失败！请稍后重试！");
            }
        }

        return msg;
    }

    /**
     * 设置任务为完成状态
     */
    @Override
    public MessageBody finish(int id, MessageBody msg, HttpSession session) {
        Project project = projectMapper.getProjectById(id);
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        // 封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("endTime", new Date());
        params.put("updateUser", user.getId());
        params.put("updateTime", new Date());
        boolean b = false;
        if (project != null && project.getId() > 0) {// 若该任务有效，则执行后续操作
            // 判断当前用户是否为项目的管理者
            params.put("status", "1");// 设置为完成状态
            b = true;
        } else {// 若该任务无效，则返回错误信息
            msg.setStatus("0");
            msg.setBody("项目不存在！");
        }
        if (b) {
            if (projectMapper.finish(params) == 1) {// 设置状态为审核
                // 将项目下属任务批量设置为审核
                List<Integer> ids = taskMapper.listTaskIdByProId(project.getId());// 获取当前项目所有的关联ID
                if (ids != null && ids.size() > 0) {
                    taskMapper.changeStatuBatch(ids, "1");// 批量设置任务为完成状态
                }
                msg.setStatus("1");
                msg.setBody("设置成功！");
            } else {
                msg.setStatus("0");
                msg.setBody("设置失败！请稍后重试！");
            }
        }
        return msg;
    }

    /**
     * 回滚项目状态至未完成
     */
    @Override
    public MessageBody rollBack(int id, MessageBody msg, HttpSession session) {
        Project project = projectMapper.getProjectById(id);
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        // 封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("endTime", new Date());
        params.put("updateUser", user.getId());
        params.put("updateTime", new Date());
        boolean b = false;
        if (project != null && project.getId() > 0) {// 若该任务有效，则执行后续操作
            // 判断当前用户是否为项目的管理者
            params.put("status", "0");// 设置为完成状态
            b = true;
        } else {// 若该任务无效，则返回错误信息
            msg.setStatus("0");
            msg.setBody("项目不存在！");
        }
        if (b) {
            if (projectMapper.finish(params) == 1) {// 设置状态为未完成
                // 将项目下属任务批量设置为审核
                List<Integer> ids = taskMapper.listTaskIdByProId(project.getId());// 获取当前项目所有的关联ID
                if (ids != null && ids.size() > 0) {
                    taskMapper.changeStatuBatch(ids, "0");// 批量设置任务为未完成状态
                }
                msg.setStatus("1");
                msg.setBody("设置成功！");
            } else {
                msg.setStatus("0");
                msg.setBody("设置失败！请稍后重试！");
            }
        }

        return msg;
    }

    @Override
    public MessageBody delete(int id, MessageBody msg, HttpSession session) {
        return null;
    }

    /**
     * 根据文件名删除
     */
    @Override
    public int delete(String fileName) {
        return projectMapper.deleteByFileName(fileName);
    }

    @Override
    public MessageBody listExamine(MessageBody msg, HttpSession session) {
        SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        Employee user = (Employee) attribute.getPrimaryPrincipal();
        Project project = new Project();// 查询条件
        project.setCreateUser(user.getId());// 创建人为当前用户
        project.setDeleted("0");// 没有被删除的
        project.setStatus("2");// 当前状态,2为审核状态
        List<Project> projects = projectMapper.listByParams(project);
        if (projects == null) {
            projects = new ArrayList<>();
        }
        if (projects.size() > 0) {// 如果有项目信息，统计一下项目的参与人数
            for (Project p : projects) {
                List<EmpProject> eps = commonMapper.queryByProId(p.getId());
                p.setPeopleNum(eps.size());
            }
        }
        msg.setStatus("1");
        msg.setData(projects);
        return msg;
    }
}
