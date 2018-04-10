FROM java:8-jre
ADD target/email-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","./email-0.0.1-SNAPSHOT.jar", "--port=80"]