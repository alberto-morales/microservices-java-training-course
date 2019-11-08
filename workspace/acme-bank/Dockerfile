FROM openjdk:oracle# copy jar file into container image under app directory  

VOLUME /tmp

COPY target/acme-bank-0.0.1-SNAPSHOT.jar app/acme-bank.jar # expose server port accept connections  

EXPOSE 8081 # start application  

CMD ["java", "-jar", "app/acme-bank.jar"]