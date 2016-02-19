FROM mysql:5.7

ENV MYSQL_ROOT_PASSWORD vertxdemo_pw
ENV MYSQL_PASSWORD vertxdemo_pw
ENV MYSQL_DATABASE vertxdemo_data

EXPOSE 3306

# this user need to stay the same for script to work
ENV MYSQL_USER mysql
COPY ./create_and_populate_db.sql /docker-entrypoint-initdb.d/create_and_populate_db.sql

COPY ./localdb-run.sh /
RUN chmod 755 /localdb-run.sh

ENTRYPOINT ["/localdb-run.sh"]

