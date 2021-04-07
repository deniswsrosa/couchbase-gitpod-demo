FROM ubuntu:18.04

RUN apt-get -qq update && \
    apt-get -qq install curl && \
    mkdir -p /tmp/couchbase && \
    cd /tmp/couchbase && \
    curl -O https://packages.couchbase.com/releases/couchbase-release/couchbase-release-1.0-amd64.deb && \
    dpkg -i ./couchbase-release-1.0-amd64.deb && \
    apt-get -qq update && \
    apt-get -qq install couchbase-server


COPY scripts/start-cb.sh /
RUN chmod 777 start-cb.sh

ENTRYPOINT ./start-cb.sh  > allout.txt 2>&1

# 8091: Couchbase Web console, REST/HTTP interface
# 8092: Views, queries, XDCR
# 8093: Query services (4.0+)
# 8094: Full-text Search (4.5+)
# 8095: Analytics (5.5+)
# 8096: Eventing (5.5+)
# 11207: Smart client library data node access (SSL)
# 11210: Smart client library/moxi data node access
# 11211: Legacy non-smart client library data node access
# 18091: Couchbase Web console, REST/HTTP interface (SSL)
# 18092: Views, query, XDCR (SSL)
# 18093: Query services (SSL) (4.0+)
# 18094: Full-text Search (SSL) (4.5+)
# 18095: Analytics (SSL) (5.5+)
# 18096: Eventing (SSL) (5.5+)
EXPOSE 8091 8092 8093 8094 8095 8096 11207 11210 11211 18091 18092 18093 18094 18095 18096
VOLUME /opt/couchbase/var