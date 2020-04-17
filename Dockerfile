FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
COPY target/transactions-666.jar transactions.jar
ENTRYPOINT ["java","-jar","transactions.jar"]