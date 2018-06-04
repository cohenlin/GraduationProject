package com.cohen.scheduletracking.controller;

import com.cohen.scheduletracking.config.ApplicationProperty;
import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.entity.Project;
import com.cohen.scheduletracking.service.ProjectService;
import com.cohen.scheduletracking.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Controller
@ResponseBody
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ApplicationProperty applicationProperty;

    @PostMapping(value = "addProject")
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
//            project.setSchemeFile(timeStamp + "_" + project.getSchemeFile());
            projectService.save(project, session);
            msg.put("status", "1");
        }

        return msg;
    }

    /**
     * 上传项目文档
     */
    @ResponseBody
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public MessageBody fileUpload(HttpServletRequest request,
                                  @RequestParam(value = "file", required = false) MultipartFile file, int flg, int id) {
        MessageBody msg = new MessageBody();

        System.out.println(request);

//        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
        String path = applicationProperty.getFilePath();
        path = path.concat(File.separator).concat(String.valueOf(flg)).concat(File.separator).concat(String.valueOf(id));
        if (file == null) {
            msg.setStatus("0");
            msg.setBody("上传文件失败！");
        }

        String fileName = file.getOriginalFilename();
        if (fileName == "" || fileName.equals("") || fileName == null || fileName.equals(null)) {
            msg.setStatus("0");
            msg.setBody("上传文件失败！");
        }
        File upload = new File(path);
        File target = new File(path, fileName);
        // 判断该文件是否已存在
        if (!upload.exists()) {
            // 该文件不存在，创建
            upload.mkdirs();
        }

        try {
            file.transferTo(target);
        } catch (IllegalStateException e) {
            msg.setStatus("0");
            msg.setBody("上传文件失败！");
            e.printStackTrace();
        } catch (IOException e) {
            msg.setStatus("0");
            msg.setBody("上传文件失败！");
            e.printStackTrace();
        }
        // 上传文件成功, 保存当前文件与对应项目、任务的关联关系
        projectService.saveFile(file.getOriginalFilename(), path, id, flg);
        msg.setStatus("1");
        msg.setBody("上传文件成功！");
        Map<String, String> map = new HashMap<>();
        map.put("fileName", fileName);
        map.put("filePath", path);
        msg.setData(map);
        return msg;
    }

    public void getFileContentFromShiroRequest(HttpServletRequest request) {
        System.out.println(request);
        ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());

        Iterator<String> itr = multipartRequest.getFileNames();
        MultipartFile file = null;

        while (itr.hasNext()) {
            file = multipartRequest.getFile(itr.next());
        }
        System.out.println();
    }

    @ResponseBody
    @RequestMapping(value = "listFiles", method = RequestMethod.GET)
    public MessageBody listFiles(@RequestParam("pid") int pid, MessageBody msg) {
        return projectService.listFiles(msg, pid);
    }

    @ResponseBody
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName, @RequestParam("filePath") String filePath) throws IOException {
        File file = new File(filePath, fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("deleteFile")
    public MessageBody deleteFile(@RequestParam("fileName") String fileName, @RequestParam("filePath") String filePath, @RequestParam("pid") Integer pid, MessageBody msg) throws IOException {
        return projectService.deleteFiles(msg, fileName, filePath, pid);
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

    /**
     * 将当前任务设置为完成，若为个人任务，直接设置为完成，若为项目任务，则进入审核状态
     *
     * @return
     */
    @RequestMapping(value = "finish", method = RequestMethod.PUT)
    public MessageBody finish(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return projectService.finish(id, msg, session);
    }

    /**
     * 审核项目，改为完成状态
     */
    @RequestMapping(value = "rollBack", method = RequestMethod.PUT)
    public MessageBody rollBack(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return projectService.rollBack(id, msg, session);
    }

    /**
     * 审核项目，改为完成状态
     */
    @RequestMapping(value = "examine", method = RequestMethod.PUT)
    public MessageBody examine(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return projectService.examine(id, msg, session);
    }

    /**
     * 点击删除任务按钮，认证用户权限，若通过则删除，否则提示权限不足
     *
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public MessageBody delete(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return projectService.delete(id, msg, session);
    }

    /**
     * 查询显示所有当前账户相关待审核项目
     */
    @RequestMapping(value = "listExamine", method = RequestMethod.GET)
    public MessageBody listExamine(MessageBody msg, HttpSession session) {
        return projectService.listExamine(msg, session);
    }

//    @ExceptionHandler(value = {ShiroException.class})
//    @ResponseBody
//    public MessageBody exceptionHandler(Exception e) {
//        MessageBody msg = new MessageBody();
//        if(e instanceof AuthorizationException){
//            msg.setStatus("403");
//            msg.setBody("您没有访问权限， 请联系管理员！");
//        }
//        if(e instanceof AuthenticationException){
//            msg.setStatus("304");
//            msg.setBody("您没有认证， 请登录！");
//        }
//        return msg;
//    }
}