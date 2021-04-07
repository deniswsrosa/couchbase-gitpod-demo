FROM couchbase:enterprise-7.0.0-beta

RUN apt-get update \
 && apt-get install -y sudo
 
RUN chmod -R 777 /opt/couchbase/var/lib/