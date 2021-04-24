FROM openjdk:8-jdk-alpine

ARG TIMEZONE="Asia/Seoul"

RUN apk add tzdata
RUN cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime
RUN echo "Asia/Seoul" > /etc/timezone
ENV LANG=ko_KR.UTF-8

RUN addgroup -g 1000 bd
RUN adduser -u 1000 -G bd -D bd

RUN mkdir -p /data/membership/run
RUN mkdir -p /data/membership/logs
RUN mkdir -p /data/membership/lib
RUN mkdir -p /data/membership/conf
COPY target/membership-0.0.1-SNAPSHOT.jar /data/membership/lib/app.jar
COPY src/main/resources/application.yml /data/membership/conf/application.yml
RUN chown -R bd:bd /membership
USER bd

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.config.location=/data/membership/conf/application.yml","-Duser.timezone=Asia/Seoul","/data/membership/lib/app.jar"]
