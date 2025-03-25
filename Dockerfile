FROM openjdk:17
EXPOSE 8080
COPY target/order.jar order.jar
ENTRYPOINT ["java", "-jar", "order.jar"]