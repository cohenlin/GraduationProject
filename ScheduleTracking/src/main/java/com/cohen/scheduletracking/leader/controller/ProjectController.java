package com.cohen.scheduletracking.leader.controller;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.entity.Project;
import com.cohen.scheduletracking.leader.service.ProjectService;
import com.cohen.scheduletracking.utils.DateEditor;
import com.cohen.scheduletracking.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 拦截页面请求，设置一个类型转换器，转换字符串与Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    @ResponseBody
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
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public MessageBody list(MessageBody msg, HttpSession session) {
        return projectService.list(msg, session);
    }

    @ResponseBody
    @RequestMapping(value = "getEmpByProId", method = RequestMethod.GET)
    public MessageBody getEmpByProId(@RequestParam("pid") int pid, MessageBody msg) {
        return projectService.getEmpByProId(pid, msg);
    }
}
