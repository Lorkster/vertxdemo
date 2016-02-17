# VertxDemo

* Use IntelliJ...

* Run Java verticles simply by using `Run 'xxx'` in IntelliJ

* Run JS verticles in IntelliJ by creating a Run task:
    - Run -> Edit Configurations...
    - Add a new Application configuration
    - Main Class: ```io.vertx.core.Launcher```
    - Program arguments (using the server.js as an example): ```run ./frontend-js/src/main/resources/server.js -cluster```
    
* Running Ruby verticles in Intellij requires installation and setup in project of JRuby
    
## Easiest running of examples
* Run: `mvn package`
* Run the *-fat.jar for each respective module, for example: 
`java -jar target/news-server-rb-1.0-SNAPSHOT-fat.jar -cp target/classes -cluster`  

## Docker

* Install Docker using the instructions for your OS found here <https://docs.docker.com/v1.8/installation/>
* Running the Docker container locally might compromise your network interfaces and making the normal `java -jar xxx -cluster`
usage not work. Just a heads up. Running everything inside of Docker should work fine (the issue is related to port bindings and 
Vert.x usage of Hazelcast for setting up discovery etc).


### Docker Mysql
  * Navigate to the database directory.
  * Either just use `docker pull vertxdemo/mysql:latest` to fetch an already pushed container, or build your own 
  with `docker build -t vertxdemo/mysql:latest .`
  * Start with `docker run -p 3306:3306 --name vertxdemo-mysql -v /path/to/my/data:/var/lib/mysql -d vertxdemo/mysql:latest .`
  and substitute `/path/to/my/data` with a relevant path on your host machine.
    * On first run the `create_db.sql` script will be run (it's packaged in the container). If you want to force a rerun
    you will need to delete the contents of the data directory used in the `docker run ...` command.
  * If persistence between reboots of the container isn't desired, just start without the volume argument instead:
  `docker run -p 3306:3306 --name vertxdemo-mysql -d vertxdemo/mysql:latest .`.
  * OSX/Linux users can use `./startdb.sh /path/to/my/data` for convenience. It will stop, remove and run the container in one go.


### Docker Maven
  * `mvn clean package` in project root or any module, or `mvn docker:build` in any module (still needs `mvn package` to have been run). 
  * For each module you want to deploy in Docker run: `mvn docker:start`, or just run it in the root to start everything at once.
  * To stop, simply do `mvn docker:stop` in the same module or the root.
  * Alternatively you can use the Docker command line and start with:
    * `docker run -t -i -p 8080:8080 vertxdemo/frontend-js:1.0-SNAPSHOT`
    * `docker run -t -i vertxdemo/news-server-java:1.0-SNAPSHOT`
  * Check your Docker container for it's ip and access frontend at that address i.e. <http://xxx.xxx.xxx.xxx:8080>.  
  
### Docker Command Line
  * Currently hardcoded to a specific version of the fat jar, check in `Dockerfile`.
  * Install Docker... <https://www.docker.com/products/docker-toolbox>
  * Build by moving the each respective module and execute for example `docker build -t vertxdemo/frontend-js .`
  * Run with for example `docker run -t -i -P -p 8080:8080 vertxdemo/frontend-js`
  * Check your Docker container for it's ip and access frontend at that address i.e. <http://xxx.xxx.xxx.xxx:8080>.
  
### Docker Compose
  * A simple docker-compose setup exists in the project root. While standing in root, calling `docker-compose up` will start
  all modules, using the `Dockerfile` files as settings.
  
