FROM openjdk:8-jdk-alpine

ARG TIMEZONE="Asia/Seoul"

RUN apk add tzdata
RUN cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime
RUN echo "Asia/Seoul" > /etc/timezone
ENV LANG=ko_KR.UTF-8

RUN addgroup -g 1000 bd
RUN adduser -u 1000 -G bd -D bd

RUN mkdir -p /membership/run
RUN mkdir -p /membership/logs
RUN mkdir -p /membership/lib
RUN mkdir -p /membership/conf
COPY target/membership-0.0.1-SNAPSHOT.jar /membership/lib/app.jar
COPY src/main/resources/application.yml /membership/conf/application.yml
RUN chown -R bd:bd /membership
USER bd

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.config.location=/membership/conf/application.yml","-Duser.timezone=Asia/Seoul","/membership/lib/app.jar"]
