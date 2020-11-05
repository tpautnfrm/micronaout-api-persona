FROM openjdk:14-alpine
COPY target/tpaPrueba-*.jar tpaPrueba.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "tpaPrueba.jar"]