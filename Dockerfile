FROM java:8-alpine
VOLUME /tmp
EXPOSE 8080
ADD abcourses-*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar","/app.jar"]
