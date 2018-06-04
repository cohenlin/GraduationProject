package com.cohen.scheduletracking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 林金成
 * @date 2018/5/1223:06
 */
@ConfigurationProperties
public class ApplicationProperty {

    @Value("${redis.cache.enable}")
    private boolean redisCacheEnable;

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    @Value("${mail.send-from}")
    private String sendFrom = "18264180308@163.com";
    @Value("${mail.send-by}")
    private String sendBy = "Cohen";

    @Value("${path.file-upload}")
    private String filePath = "/opt/upload";

    public boolean getRedisCacheEnable() {
        return redisCacheEnable;
    }

    public void setRedisCacheEnable(boolean redisCacheEnable) {
        this.redisCacheEnable = redisCacheEnable;
    }

    public String getSpringProfilesActive() {
        return springProfilesActive;
    }

    public void setSpringProfilesActive(String springProfilesActive) {
        this.springProfilesActive = springProfilesActive;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
