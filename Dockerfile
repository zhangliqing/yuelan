FROM java:openjdk-8-alpine

ADD build/libs/yuelan-1.0.0.jar app.jar
ADD src/main/resources/application.properties  application.properties
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=/application.properties" ]
