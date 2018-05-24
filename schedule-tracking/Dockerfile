FROM centos-jre
MAINTAINER Cohen
#create settings/server.properties
RUN mkdir /opt/settings
touch "env=dev" > /opt/settings/server.properties
#ADD server.properties /opt/settings
#端口
EXPOSE 8080
#添加项目源码
ADD schedule-tracking-1.0.war /opt/
#进入项目根目录
WORKDIR /opt/
#start app
ENTRYPOINT ["java" ,"-jar", "schedule-tracking-1.0.war"]