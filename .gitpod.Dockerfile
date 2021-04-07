FROM ubuntu:18.04

RUN apt-get -qq update && \
    apt-get install -yq runit wget chrpath tzdata \
    lsof lshw sysstat net-tools numactl bzip2 lsb-release && \
    apt-get autoremove && apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN apt-get -qq update && \
    apt-get -qq install curl && \
    mkdir -p /tmp/couchbase && \
    cd /tmp/couchbase && \
    curl -O https://packages.couchbase.com/releases/couchbase-release/couchbase-release-1.0-amd64.deb && \
    dpkg -i ./couchbase-release-1.0-amd64.deb && \
    apt-get -qq update && \
    apt-get install couchbase-server