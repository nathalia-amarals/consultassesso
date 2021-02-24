FROM tomcat:9.0-alpine

LABEL MAINTAINER=nathalia_amaral

EXPOSE 3002

ADD /target/consultaassesso.war /usr/local/tomcat/webapps/