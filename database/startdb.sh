#!/usr/bin/env bash
# Just to make starting Docker Mysql easier...
MY_PATH="$1"
docker stop vertxdemo-mysql
docker rm -f vertxdemo-mysql
docker run -p 3306:3306 --name vertxdemo-mysql -v $MY_PATH:/var/lib/mysql -d vertxdemo/mysql:latest .
