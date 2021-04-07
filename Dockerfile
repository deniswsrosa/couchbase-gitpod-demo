FROM gitpod/workspace-full

RUN mkdir -p /tmp/couchbase && \
    cd /tmp/couchbase && \
    sudo apt-get update && \
    curl -O https://packages.couchbase.com/releases/7.0.0-beta/couchbase-server-enterprise_7.0.0-beta-ubuntu20.04_amd64.deb && \
    sudo dpkg -i ./couchbase-server-enterprise_7.0.0-beta-ubuntu20.04_amd64.deb

ENTRYPOINT cd /opt/couchbase/bin && \
    ./couchbase-cli cluster-init -c localhost --cluster-username Administrator --cluster-password password --services data,index,query --cluster-ramsize 512 && \
    ./couchbase-cli bucket-create -c localhost:8091 --username Administrator --password password --bucket default --bucket-type couchbase --bucket-ramsize 256