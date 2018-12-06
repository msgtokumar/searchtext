FROM frolvlad/alpine-oraclejdk8:slim
COPY target/SearchText-1.0.0.war app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
