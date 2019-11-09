FROM openjdk:oracle   

VOLUME /tmp

COPY target/acme-bank-0.0.1-SNAPSHOT.jar app/acme-bank.jar   

EXPOSE 8081  

CMD ["java", "-jar", "app/acme-bank.jar"]
