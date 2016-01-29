# VertxDemo

* Use IntelliJ...

* Run Java verticles simply by using `Run 'xxx'` in IntelliJ

* Run JS verticles in IntelliJ by creating a Run task:
    - Run -> Edit Configurations...
    - Add a new Application configuration
    - Main Class: ```io.vertx.core.Launcher```
    - Program arguments (using the server.js as an example): ```run ./frontend-js/src/main/resources/server.js -cluster```