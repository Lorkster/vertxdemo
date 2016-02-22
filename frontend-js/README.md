# Frontend Module
The frontend module uses the JavaScript version of Vert.x to expose a simple web page listening to the Vert.x event bus.

[server.js](/src/main/resources/server.js) sets up a JavaScript verticle that bridges the Vert.x event bus to SockJs and then serves a web page on port 8080.

## Build Instructions

* `mvn clean package`
* `mvn docker:build`
* If you need to push your Docker image, use `mvn docker:push`.

## Run Instructions

* `mvn docker:start` to boot up a Docker container and `mvn docker:stop` to tear it down.

### Using Dockerfile
The [Dockerfile](/Dockerfile)  in the module mirrors Docker settings in `pom.xml` to illustrate different usage scenarios.

* `docker run -t -i -p 8080:8080 vertxdemo/frontend-js:1.0-SNAPSHOT`

### Using IntelliJ

* Run JS verticles in IntelliJ by creating a Run task:
    - Run -> Edit Configurations...
    - Add a new Application configuration
    - Main Class: `io.vertx.core.Launcher`
    - Program arguments (using the server.js as an example): `run ./frontend-js/src/main/resources/server.js -cluster`
    
### Using java -jar
    
   * `java -jar target/frontend-js-1.0-SNAPSHOT-fat.jar -cp target/classes -ha`
   