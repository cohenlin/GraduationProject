package com.cohen.scheduletracking.common.service.impl;

import com.cohen.scheduletracking.common.dao.TaskMapper;
import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.common.service.TaskService;
import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public MessageBody insert(Task task, MessageBody msg, HttpSession session) {
        Employee user = (Employee) session.getAttribute("user");
        task.setEmpId(user.getId());// 用户自己新增任务,managerId和empId都是自己
        task.setManagerId(user.getId());
        task.setCreateTime(new Date());
        task.setProjectId(0);
        task.setSchedule(0);
        task.setCreateUser(user.getId());
//        task.setBeginTime(new Date());// 可以根据前端表单选择，也可以默认设置为当前时间
        task.setStatus("0");
        task.setDelete("0");
        if (taskMapper.insert(task) == 1) {
            msg.setStatus("1");
        } else {
            msg.setStatus("0");
        }
        return msg;
    }

    @Override
    public List<Task> list(HttpSession session) {
        Employee emp = (Employee) session.getAttribute("user");
        List<Task> result = taskMapper.list(emp.getId());
        return result == null ? new ArrayList<>() : result;
    }

    @Override
    public MessageBody changeTaskToFinish(int id, MessageBody msg, HttpSession session) {
        Task task = taskMapper.getTaskById(id);
        Employee user = (Employee) session.getAttribute("user");
        // 封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("endTime", new Date());
        params.put("updateUser", user.getId());
        params.put("updateTime", new Date());
        boolean b = false;
        if (task != null && task.getId() > 0) {// 若该任务有效，则执行后续操作
            if (task.getProjectId() == 0) {// 若projectId为0, 该任务为个人任务，直接执行修改
                params.put("status", "1");
                b = true;
            } else {// 若任务为项目所属任务，则验证权限是否足够确认完成
                if (user.getId() == task.getManagerId() || user.getId() == task.getCreateUser()) {// 若当前用户为任务的创建者或管理者,则执行修改
                    params.put("status", "1");
                    b = true;
                } else {// 权限不够，进入审核状态
                    params.put("status", "2");
                    b = true;
                }
            }
            if(b){
                if (taskMapper.changeTaskToFinish(params) == 1) {
                    msg.setStatus("1");
                    msg.setBody("任务已确认完成！");
                } else {
                    msg.setStatus("0");
                    msg.setBody("任务确认过程出错，请重试！");
                }
            }
        } else {// 若该任务无效，则返回错误信息
            msg.setStatus("0");
            msg.setBody("该任务不存在！");
        }

        return msg;
    }

    @Override
    public MessageBody delete(int id, MessageBody msg, HttpSession session) {
        Task task = taskMapper.getTaskById(id);
        boolean b = false;
        if(task != null && task.getId() > 0){
            if(task.getProjectId() == 0){// 为0属于个人任务
                b = true;
            } else {// 为项目所属任务
                Employee user = (Employee) session.getAttribute("user");
                if(user.getId() == task.getCreateUser() || user.getId() == task.getManagerId()){// 当前用户权限足够，执行
                    b = true;
                } else {// 用户权限不足
                    b = false;
                    msg.setStatus("2");
                    msg.setBody("您的权限不足！");
                }
            }
            if(b){
                if (taskMapper.delete(id) == 1) {
                    msg.setStatus("1");
                    msg.setBody("删除成功！");
                } else {
                    msg.setStatus("0");
                    msg.setBody("删除失败！");
                }
            }
        } else {// 任务无效，返回错误信息
            msg.setStatus("0");
            msg.setBody("该任务不存在！");
        }

        return msg;
    }

    @Override
    public MessageBody edit(int id, MessageBody msg, HttpSession session) {
        // 按照id取出当前任务信息
        Task task = taskMapper.getTaskById(id);
        if (task != null && task.getId() > 0) {// 若该任务有效，则执行后续操作，若无效，则直接返回
            if (task.getProjectId() == 0) {// 若projectId为0，说明该任务为个人任务,直接填充至个人任务编辑表单
                msg.setStatus("1");// 个人任务修改设为1
                msg.setBody("编辑任务请求成功！");
                msg.setData(task);
            } else {// 若projectId不为0，说明该任务为项目任务，验证当前用户是否权限足够
                Employee user = (Employee) session.getAttribute("user");
                if (user.getId() == task.getManagerId() || user.getId() == task.getCreateUser()) {// 若当前用户为项目创建人或者被指定管理人，则可以修改项目
                    msg.setStatus("2");// 项目任务修改设为2
                    msg.setBody("编辑任务请求成功！");
                    msg.setData(task);
                } else {// 权限不够，返回错误信息
                    msg.setStatus("3");
                    msg.setBody("您的权限不够！");
                    msg.setData(null);
                }
            }
        } else {
            msg.setStatus("0");
            msg.setBody("您编辑的任务不存在，请确认后重试！");
            msg.setData(null);
        }

        return msg;
    }
}
