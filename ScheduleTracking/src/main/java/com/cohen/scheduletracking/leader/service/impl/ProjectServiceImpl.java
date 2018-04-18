package com.cohen.scheduletracking.leader.service.impl;

import com.cohen.scheduletracking.common.dao.TaskMapper;
import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.entity.EmpProject;
import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.entity.Project;
import com.cohen.scheduletracking.entity.Task;
import com.cohen.scheduletracking.leader.dao.CommonMapper;
import com.cohen.scheduletracking.leader.dao.ProjectMapper;
import com.cohen.scheduletracking.leader.service.EmployeeService;
import com.cohen.scheduletracking.leader.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    private static Logger logger = Logger.getLogger(ProjectServiceImpl.class);
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
    public Integer save(Project project) {
        // 给Project填充其余属性
        project.setSchedule("0%");// 项目进度
        project.setFinished("0");// 是否完成
        project.setDeleted("0");// 是否已删除
        project.setCreateUser(0);// 创建人
        project.setCreateTime(new Date());// 创建日期
        // 执行插入
        int returnValue = projectMapper.insert(project);
        logger.info("插入project后返回的自增主键 ：" + project.getId());
        commonMapper.insertEmpProject(project.getManagerId(), project.getId(), "1");

        // 打印日志
        logger.info("执行完插入项目方法后，insert方法返回值为 ：" + returnValue);

        return returnValue;
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
        Employee user = (Employee) session.getAttribute("user");
        List<EmpProject> empProjects = commonMapper.queryByEmpId(user.getId());// 员工所属项目
        List<Integer> proIds = new ArrayList<>();
        for (EmpProject ep :
                empProjects) {
            if(!proIds.contains(ep.getProId())){
                proIds.add(ep.getProId());
            }
        }
        List<Project> list = projectMapper.listByProjectId(proIds);// 查询出当前用户关联的项目
        if(list != null){
            msg.setStatus("1");// 检索成功！
            msg.setBody("检索成功！");
        }else{
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
            if (!empIds.contains(ep.getEmpId())){
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
        if(project != null){
            List<Task> tasks = taskMapper.listByProId(project.getId());
            msg.setStatus("1");
            msg.setBody("数据回显成功！");
            Map<String,Object> map = new HashMap<>();
            map.put("project", project);
            map.put("tasks", tasks);
            msg.setData(map);
        }else{
            msg.setStatus("0");
            msg.setBody("数据不存在！");
        }
        return msg;
    }

    @Override
    public MessageBody checkLevel(int pid, HttpSession session, MessageBody msg) {
        Employee user = (Employee) session.getAttribute("user");
        boolean b = false;
        if(user != null){
            Project project = projectMapper.getProjectById(pid);
            if(user.getLevel() == 3){// 部门以上的领导
                b = true;
            } else if(user.getLevel() == 1) {// 普通员工
                if(user.getId() == project.getManagerId()){// 如果是管理员，则有权编辑
                    b = true;
                }else{
                    b = false;
                }
            } else {// 部门级领导
                if(user.getId() == project.getManagerId() || user.getId() == project.getCreateUser()){// 是管理或者创建者
                    b = true;
                } else {
                    b = false;
                }
            }
            if(b){
                msg.setStatus("1");
                msg.setBody("权限足够！");
            } else {
                msg.setStatus("-1");
                msg.setBody("权限不足！");
            }
        }else{
            msg.setStatus("0");
            msg.setBody("未登录！");
        }

        return msg;
    }
}
