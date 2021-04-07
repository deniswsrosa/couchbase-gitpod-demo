FROM ubuntu:16.04

RUN apt-get -qq update && \
    apt-get -qq install curl && \
    mkdir -p /tmp/couchbase