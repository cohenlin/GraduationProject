package com.cohen.scheduletracking.leader.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cohen.scheduletracking.entity.Project;

@Controller(value = "projectController")
@RequestMapping(value = "/project")
public class ProjectController {

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProjectInfo(Project project, HttpServletRequest request, Map<String, String> map) {
        String msg = null;
        System.out.println(project);

        return "success";
    }

    /**
     * 上传项目策划案，返回json结果
     */
    @ResponseBody
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request) {
        String msg = null;
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
        String fileName = file.getOriginalFilename();
        File target = new File(path, fileName);
        // 判断该文件是否已存在
        if (!target.exists()) {
            // 该文件不存在，创建
            target.mkdirs();
        }

        try {
            file.transferTo(target);
            msg = "1";
        } catch (IllegalStateException e) {
            msg = "0";
            e.printStackTrace();
        } catch (IOException e) {
            msg = "0";
            e.printStackTrace();
        }

        return msg;
    }
}
