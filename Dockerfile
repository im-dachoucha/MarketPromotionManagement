FROM tomcat:10-jdk17

ADD ./target/MarketPromotionManagement-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

EXPOSE 8080

CMD ["catalina.sh", "run"]