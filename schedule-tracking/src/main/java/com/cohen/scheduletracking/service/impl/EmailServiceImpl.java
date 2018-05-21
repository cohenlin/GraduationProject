package com.cohen.scheduletracking.service.impl;

import com.cohen.redis.assembly.cache.RedisDao;
import com.cohen.scheduletracking.config.ApplicationProperty;
import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.UUID;

/**
 * @author 林金成
 * @date 2018/5/1313:17
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private static final String FIND_PASSWORD_BASE_URL_LOCAL = "http://127.0.0.1:8080/changePassword";
    private static final String EMAIL_163 = "https://mail.163.com/";
    private static final String EMAIL_QQ = "https://en.mail.qq.com/cgi-bin/loginpage";
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private ApplicationProperty property;

    /**
     * 发送找回密码的链接到目标邮箱
     *
     * @param email
     */
    @Override
    public MessageBody sendUrlForPasswordChange(String email, String userName, MessageBody msg) {
        String code = null;
        if (redisDao.contains(userName)) {// 如果redis中存在code，说明上次发送的url仍然有效，不再重发，提示用户查看邮箱
            msg.setStatus("-1");// 已经发送过邮件
            msg.setBody("邮件已经发送过了，请确认邮箱！");
            return msg;
        } else {
            // 生成code，存入redis
            code = UUID.randomUUID().toString().substring(0, 32);
            redisDao.setex(userName, 1800, code.concat("_").concat(email));// userName: code_email
        }
        MimeMessage message = null;
        try {
            message = sender.createMimeMessage();
            // from
            message.setFrom(new InternetAddress(property.getSendFrom(), property.getSendBy(), "UTF-8"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));//设置收件人邮箱地址
            message.setSubject(MimeUtility.encodeText("密码找回", "UTF-8", "B"));  //生成邮件标题
            String text = "找回密码请点击：" + FIND_PASSWORD_BASE_URL_LOCAL + "?code=" + code + "&userName=" + userName;// 邮件正文内容,找回密码URL
            message.setContent(text, "text/plain;charset=utf-8");   //生成邮件正文
            sender.send(message);// 发送邮件
        } catch (Exception e) {
            redisDao.del(userName);// 删除code
            msg.setStatus("0");// 已经发送过邮件
            msg.setBody("邮件发送失败！请重试！");
            return msg;
        }
        msg.setStatus("1");// 已经发送过邮件
        msg.setBody("邮件发送成功！");
        String emailType = email.split("@")[1];
        if (emailType.equals("163.com")) {
            msg.setData(EMAIL_163);
        }
        if (emailType.equals(EMAIL_QQ)) {
            msg.setData(EMAIL_163);
        }
        return msg;
    }
}
