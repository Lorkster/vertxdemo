# VertxDemo

* Use IntelliJ...

* Run Java verticles simply by using `Run 'xxx'` in IntelliJ

* Run JS verticles in IntelliJ by creating a Run task:
    - Run -> Edit Configurations...
    - Add a new Application configuration
    - Main Class: ```io.vertx.core.Launcher```
    - Program arguments (using the server.js as an example): ```run ./frontend-js/src/main/resources/server.js -cluster```
    
* Running Ruby verticles in Intellij requires installation and setup in project of JRuby
    
# Easiest running of examples
* Run: `mvn package`
* Run the *-fat.jar for each respective module, for example: 
`java -jar java -jar target/news-server-rb-1.0-SNAPSHOT-fat.jar -cp target/classes -cluster`  

# Docker Maven
  * `mvn clean package` in project root or any module, or `mvn docker:build` in any module (still needs `mvn package`to have been run). 
  * For each module you want to deploy in Docker run: `mvn docker:start`
  * To stop, simply do `mvn docker:stop` in the same module.
  * Alternatively you can use the Docker command line and start with:
    * `docker run -t -i -p 8080:8080 vertxdemo/frontend-js:1.0-SNAPSHOT`
    * `docker run -t -i vertxdemo/news-server-java:1.0-SNAPSHOT`
  
# Docker Command Line
  * Currently hardcoded to a specific version of the fat jar, check in `Dockerfile`.
  * Install Docker... <https://www.docker.com/products/docker-toolbox>
  * Build by moving the each respective module and execute for example `docker build -t vertxdemo/frontend-js .`
  * Run with for example `docker run -t -i -P -p 8080:8080 vertxdemo/frontend-js`
  * Check your Docker container for it's ip and access frontend at that address i.e. <http://xxx.xxx.xxx.xxx:8080>.
  
