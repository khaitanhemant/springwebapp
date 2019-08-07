FROM java:8-jdk-alpine

COPY ./target/springmvcapp-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch springmvcapp-0.0.1-SNAPSHOT.jar'


ENTRYPOINT ["java","-jar","springmvcapp-0.0.1-SNAPSHOT.jar"]