FROM mysql:5.7

ENV MYSQL_ROOT_PASSWORD vertxdemo_pw
ENV MYSQL_PASSWORD vertxdemo_pw
ENV MYSQL_DATABASE vertxdemo_data

# this need to stay the same for script to work
ENV MYSQL_USER mysql
COPY ./create_db.sql /docker-entrypoint-initdb.d/create_db.sql

COPY ./localdb-run.sh /
RUN chmod 755 /localdb-run.sh

ENTRYPOINT ["/localdb-run.sh"]

