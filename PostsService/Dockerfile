FROM maven:3.8 AS maven
LABEL MAINTAINER="vivek_dhiman@epam.com"

COPY pom.xml .
COPY src /src

RUN mvn package

FROM openjdk

ARG JAR_FILE=PostsService-0.1.jar

WORKDIR /opt/app
COPY --from=maven /target/${JAR_FILE} /opt/app/

EXPOSE 8080
ENTRYPOINT ["java","-jar", "PostsService-0.1.jar"]
