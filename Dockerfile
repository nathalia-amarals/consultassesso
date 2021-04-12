FROM tomcat:9.0-alpine

LABEL MAINTAINER=nathalia_amaral

EXPOSE 3002

RUN sed -i 's/port="8080"/port="3002"/' ${CATALINA_HOME}/conf/server.xml

ADD /target/consultaassesso.war /usr/local/tomcat/webapps/