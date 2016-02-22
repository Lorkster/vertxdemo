# Database microservice in Java
This module creates a very simple database service in Vert.x, using Java, and exposes it using Vert.x proxy technology. 
It demonstrates proxying of remote services, linking containers and using external configuration (by using the `--env-file` flag when running Docker) 
of environment variables. The entries in `dev.env.properties` will be exposed as environment properties in the Docker container.

## Build Instructions

* `mvn clean package`
* `mvn docker:build`
* If you need to push your Docker image, use `mvn docker:push`.
* If API changes have been made, you will need to push to local Maven: `mvn clean install` (might have to run from root dir).

## Run Instructions

* `mvn docker:start` to boot up a Docker container and `mvn docker:stop` to tear it down.

### Using Dockerfile
The [Dockerfile](/Dockerfile)  in the module mirrors Docker settings in `pom.xml` to illustrate different usage scenarios.
When starting we need to link this module to the database one (using `--link vertxdemo-mysql:db`), as well as pass in an external property file (`--env-file dev.env.properties`).

* `docker run -t -i --link vertxdemo-mysql:db --env-file ./dev.env.properties vertxdemo/db-service-java:1.0-SNAPSHOT`

### Using IntelliJ

* Simply create a `Run 'xxx'` in IntelliJ and set it up with the following environment properties (matching your local environment):
    - `DB_PORT=tcp://192.168.99.100:3306`
    - `DB_PORT_3306_TCP_PORT=3306`
    - `DB_PORT_3306_TCP_ADDR=192.168.99.100`
    - `MYSQL_USER=mysql`
    - `MYSQL_PASSWORD=vertxdemo_pw`
    - `MYSQL_DATABASE=vertxdemo_data`
    
### Using java -jar
    
 * Make sure the environment properties from "Using IntelliJ" are set.
 * `java -jar target/db-service-java-1.0-SNAPSHOT-fat.jar -cp target/classes -ha`  