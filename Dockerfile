From tomcat:9.0.40-jdk15-openjdk-buster

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/roulette-api.war /usr/local/tomcat/webapps/roulette-api.war

CMD ["catalina.sh","run"]