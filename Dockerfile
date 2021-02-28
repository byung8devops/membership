FROM openjdk:8-jdk-alpine

RUN addgroup -g 1000 bd
RUN adduser -u 1000 -G bd -D bd

RUN mkdir -p /membership/run
RUN mkdir -p /membership/logs
RUN mkdir -p /membership/lib
COPY target/membership-0.0.1-SNAPSHOT.jar /membership/lib/app.jar
RUN chown -R bd:bd /membership
USER bd

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","/membership/lib/app.jar"]

