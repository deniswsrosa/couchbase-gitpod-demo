FROM ubuntu:18.04

RUN apt-get -qq update && \
    apt-get -qq install curl && \
    mkdir -p /tmp/couchbase