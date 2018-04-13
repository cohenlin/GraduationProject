package com.cohen.scheduletracking.leader.service.impl;

import com.cohen.scheduletracking.entity.Project;
import com.cohen.scheduletracking.leader.dao.CommonMapper;
import com.cohen.scheduletracking.leader.dao.ProjectMapper;
import com.cohen.scheduletracking.leader.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    private static Logger logger = Logger.getLogger(ProjectServiceImpl.class);
    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 保存当前项目信息，并把此项目绑定到负责人
     */
    @Override
    public Integer save(Project project) {
        // 给Project填充其余属性
        project.setSchedule(0.00);// 项目进度
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

    @Override
    public Integer update(Integer id, Project project) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Project getProjectById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Project> getProjectByDate(Date begin, Date end) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Project> getProjectByIsFinished(Boolean isFinished) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Project> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
