# News Server microservice in Groovy
This module demonstrates creating a simple microservice in Vert.x, using Groovy, which sends regular messages on the
Vert.x event bus.

## Build Instructions

* `mvn clean package`
* `mvn docker:build`
* If you need to push your Docker image, use `mvn docker:push`.

## Run Instructions

* `db-service-java` needs to be running.
* `mvn docker:start` to boot up a Docker container and `mvn docker:stop` to tear it down.

### Using Dockerfile
The [Dockerfile](/Dockerfile)  in the module mirrors Docker settings in `pom.xml` to illustrate different usage scenarios.

* `docker run -t -i vertxdemo/news-server-groovy:1.0-SNAPSHOT`

### Using IntelliJ

* Simply create a `Run 'xxx'` in IntelliJ
    
### Using java -jar
    
   * `java -jar target/news-server-groovy-1.0-SNAPSHOT-fat.jar -cp target/classes -ha`