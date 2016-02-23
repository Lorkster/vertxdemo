# Docker Mysql
The project has a custom `Dockerfile` for setting up a MySql 5.7 instance. It demonstrates how you can extend the official
container and add custom database scripts that will be executed on the first run. The Dockerfile` also contains a workaround
specifically for executing on OSX.

## Instructions

  * Either just use `docker pull vertxdemo/mysql:latest` to fetch an already pushed container, or build your own 
  with `docker build -t vertxdemo/mysql:latest .`
  * Start with `docker run -p 3306:3306 --name vertxdemo-mysql -v /path/to/my/data:/var/lib/mysql -d vertxdemo/mysql:latest .`
  and substitute `/path/to/my/data` with a relevant path on your host machine.
    * On first run the `create_db.sql` script will be run (it's packaged in the container). If you want to force a rerun
    you will need to delete the contents of the data directory used in the `docker run ...` command.
  * If persistence between reboots of the container isn't desired, just start without the volume argument instead:
  `docker run -p 3306:3306 --name vertxdemo-mysql -d vertxdemo/mysql:latest .`.
  * OSX/Linux users can use `./startdb.sh /path/to/my/data` for convenience. It will stop, remove and run the container in one go.