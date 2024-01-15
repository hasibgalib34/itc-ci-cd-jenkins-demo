FROM openjdk
WORKDIR usr/src
ADD ./target/HelloWorldProject-0.0.1-SNAPSHOT.jar /usr/src/HelloWorldProject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserAuthenticationService-0.0.1-SNAPSHOT.jar"]