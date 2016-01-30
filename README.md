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
* Run: ```mvn package``
* Run the *-fat.jar for each respective module, for example: 
```java -jar java -jar target/news-server-rb-1.0-SNAPSHOT-fat.jar -cp target/classes -cluster```    