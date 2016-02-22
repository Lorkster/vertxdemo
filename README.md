# VertxDemo
This project aims to demonstrate a minimal working asynchronous microservice architecture, using [Vert.x](http://vertx.io/) 
and [Docker](https://www.docker.com/) as the main technological choices.

The projects show how to:

  * Start a custom MySql container that starts with a pre-defined schema and data.
  * Deploy a simple set of microservices using Vert.x and demonstrating the polyglot abilities of that framework.
  * Deploy a frontend that receives updates from the different microservices over an event bus.
  * Have a database service accessible from the other services, but using Vert.x proxy class technology.
  * Inject external properties in a Docker container to expose them as system properties.
  * Access injected Docker properties from the database service.
  * User for both `Dockerfile` and Maven for starting Docker containers.
  
All modules will be packaged as fat jars and are runnable as such, but it's recommended to setup and use Docker  
  
## Requirements
Using Docker is highly recommended. You can install it using the instructions for your OS found here <https://docs.docker.com/v1.8/installation/> .

Running the Docker container locally, at least on OSX, might compromise your network interfaces and making the normal `java -jar xxx -cluster`
usage not work. Just a heads up. Running everything inside of Docker should work fine (the issue is related to port bindings and 
Vert.x usage of Hazelcast for setting up discovery etc).
  
If you don't want to use Docker, you will need a Java 1.8 environment and setup MySql manually.  
  
## Build Instructions  

* From the root run: `mvn clean install` . This makes sure you push everything to your local maven repos. If no changes 
have been made to `db-service-java` then `mvn clean package` should be enough.

* Use `mvn docker:build` to create Docker images for all Maven modules.

* If you have setup a remote Docker repository (Docker Hub, for example), with proper user settings, you can push your
image with `mvn docker:push`.

## Run Instructions

* Start your custom MySql container. Please see documentation here [README.md](/database/README.md)

* From the root run: `mvn docker:start`. This will initialize all Docker containers for all Maven modules.

* Check your Docker container for it's ip and access frontend at that address i.e. <http://xxx.xxx.xxx.xxx:8080>.

* `mvn docker:stop` will tear all the Docker containers.

* It's also possbile to use the fat-jars directly for each respective module, for example: 
`java -jar target/news-server-rb-1.0-SNAPSHOT-fat.jar -cp target/classes -cluster`

### Docker Compose
  * A simple docker-compose setup exists in the project root. While standing in root, calling `docker-compose up` will start
  all modules, using the `Dockerfile` files as settings.





# OLD STUFF BELOW

* Run Java verticles simply by using `Run 'xxx'` in IntelliJ
* Running Ruby verticles in Intellij requires installation and setup in project of JRuby
    
## Easiest running of examples
* Run: `mvn package`
* Run the *-fat.jar for each respective module, for example: 
`java -jar target/news-server-rb-1.0-SNAPSHOT-fat.jar -cp target/classes -cluster`  



### Docker Maven
  * `mvn clean package` in project root or any module, or `mvn docker:build` in any module (still needs `mvn package` to have been run). 
  * For each module you want to deploy in Docker run: `mvn docker:start`, or just run it in the root to start everything at once.
  * To stop, simply do `mvn docker:stop` in the same module or the root.
  * Alternatively you can use the Docker command line and start with:
    * `docker run -t -i -p 8080:8080 vertxdemo/frontend-js:1.0-SNAPSHOT`
    * `docker run -t -i vertxdemo/news-server-java:1.0-SNAPSHOT`
  * Check your Docker container for it's ip and access frontend at that address i.e. <http://xxx.xxx.xxx.xxx:8080>.  

  
  

  
