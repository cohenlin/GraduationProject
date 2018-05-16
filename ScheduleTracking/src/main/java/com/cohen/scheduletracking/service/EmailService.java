package com.cohen.scheduletracking.service;

import com.cohen.scheduletracking.entity.MessageBody;

/**
 * @author 林金成
 * @date 2018/5/1314:55
 */
public interface EmailService {
    public MessageBody sendUrlForPasswordChange(String email, String userName, MessageBody msg);
}
