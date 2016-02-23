# News Server microservice in Ruby

This module demonstrates creating a simple microservice in Vert.x, using Ruby, which sends regular messages on the
Vert.x event bus.

## Build Instructions

* `mvn clean package`
* `mvn docker:build`
* If you need to push your Docker image, use `mvn docker:push`.

## Run Instructions

* `mvn docker:start` to boot up a Docker container and `mvn docker:stop` to tear it down.

### Using Dockerfile
The [Dockerfile](/Dockerfile)  in the module mirrors Docker settings in `pom.xml` to illustrate different usage scenarios.

* `docker run -t -i vertxdemo/news-server-rb:1.0-SNAPSHOT`

### Using IntelliJ

* Running Ruby verticles in Intellij requires installation and setup in project of JRuby
* Run Ruby verticles in IntelliJ by creating a Run task:
    - Run -> Edit Configurations...
    - Add a new Application configuration
    - Main Class: `io.vertx.core.Launcher`
    - Program arguments: `run ./news-server-rb/src/main/rb/app/news_server.rb -ha`
    
### Using java -jar
    
   * `java -jar target/news-server-rb-1.0-SNAPSHOT-fat.jar -cp target/classes -ha` 