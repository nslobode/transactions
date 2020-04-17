# Transactions

### to package:

* `mvn clean package`

### to run:

* `java -jar transactions-666.jar`

### to build image
* `docker build -t transactions:1.0 .`

Multithreading is implemented via @Async method, for you shan't bicycle.
Database is H2, because light.

//TODO:
* switch to webFlux
* switch H2 to postgres via docker-compose
