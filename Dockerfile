FROM tomcat:jre11-slim
EXPOSE 8080
ARG WAR_FILE=/build/libs/kafka-produce-consume-0.0.1-SNAPSHOT.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/app.war
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/local/tomcat/webapps/app.war" ]
