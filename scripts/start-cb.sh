#!/bin/bash
echo "Starting Couchbase manually..." >> /proc/1/fd/1
./etc/service/couchbase-server/run &
while [[ "$(curl -s -o /dev/null -w ''%{http_code}'' localhost:8091)" != "301" ]]; do sleep 5; done
cd /opt/couchbase/bin
./couchbase-cli cluster-init -c localhost --cluster-username Administrator --cluster-password password --services data,index,query --cluster-ramsize 512
./couchbase-cli bucket-create -c localhost:8091 --username Administrator --password password --bucket default --bucket-type couchbase --bucket-ramsize 256
