package com.cohen.scheduletracking.controller;

import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.entity.Project;
import com.cohen.scheduletracking.service.ProjectService;
import com.cohen.scheduletracking.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/addProject")
    public Map<String, String> addProjectInfo(@Valid Project project, BindingResult result, HttpSession session) {
        Map<String, String> msg = new HashMap<>();
        String timeStamp = StringUtils.getDateWithCommonString();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fe : fieldErrors) {
                msg.put(fe.getField(), fe.getDefaultMessage());
            }
            msg.put("status", "0");
        } else {
            project.setSchemeFile(timeStamp + "_" + project.getSchemeFile());
            projectService.save(project);
            msg.put("status", "1");
        }
        session.setAttribute("timeStamp", timeStamp);

        return msg;
    }

    /**
     * 上传项目策划案，返回json结果
     */
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(HttpServletRequest request,
                             @RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) {
        String msg = null;
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
        if (file == null) {
            return "error";
        }

        String fileName = session.getAttribute("timeStamp") + "_" + file.getOriginalFilename();
        if (fileName == "" || fileName.equals("") || fileName == null || fileName.equals(null)) {
            return "error";
        }
        File target = new File(path, fileName);
        // 判断该文件是否已存在
        if (!target.exists()) {
            // 该文件不存在，创建
            target.mkdirs();
        }

        try {
            file.transferTo(target);
            msg = "success";
        } catch (IllegalStateException e) {
            msg = "error";
            e.printStackTrace();
        } catch (IOException e) {
            msg = "error";
            e.printStackTrace();
        }

        return msg;
    }

    /**
     * 检索当前用户的项目信息
     *
     * @param msg
     * @param session
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public MessageBody list(MessageBody msg, HttpSession session) {
        return projectService.list(msg, session);
    }

    @RequestMapping(value = "getEmpByProId", method = RequestMethod.GET)
    public MessageBody getEmpByProId(@RequestParam("pid") int pid, MessageBody msg) {
        return projectService.getEmpByProId(pid, msg);
    }

    /**
     * 项目编辑回显
     *
     * @param id
     * @param msg
     * @return
     */
    @RequestMapping(value = "getProjectById", method = RequestMethod.GET)
    public MessageBody getProjectById(@RequestParam("id") int id, MessageBody msg) {
        return projectService.getProjectById(id, msg);
    }

    /**
     * 校验当前用户是否有权限编辑项目
     *
     * @param pid
     * @param session
     * @param msg
     * @return
     */
    @RequestMapping(value = "checkLevel", method = RequestMethod.GET)
    public MessageBody checkLevel(@RequestParam("pid") int pid, HttpSession session, MessageBody msg) {
        return projectService.checkLevel(pid, session, msg);
    }
}