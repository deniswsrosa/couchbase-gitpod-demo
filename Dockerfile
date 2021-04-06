FROM gitpod/workspace-full

RUN mkdir -p /tmp/couchbase && \
    cd /tmp/couchbase && \
    curl -O https://packages.couchbase.com/releases/couchbase-release/couchbase-release-1.0-amd64.deb && \
    sudo dpkg -i ./couchbase-release-1.0-amd64.deb && \
    sudo apt-get update && \
    sudo apt-get install couchbase-server && \
    cd /opt/couchbase/bin && \
    ./couchbase-cli cluster-init -c 127.0.0.1 --cluster-username Administrator --cluster-password password --services data,index,query --cluster-ramsize 512 && \
    ./couchbase-cli bucket-create -c 127.0.0.1:8091 --username Administrator --password password --bucket default --bucket-type couchbase --bucket-ramsize 256
