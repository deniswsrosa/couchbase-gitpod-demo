FROM gitpod/workspace-full

#RUN apt-get -qq update && \
#    apt-get install -yq runit wget chrpath tzdata \
#    lsof lshw sysstat net-tools numactl bzip2 && \
#    apt-get autoremove && apt-get clean && \
#    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
#
#RUN if [ ! -x /usr/sbin/runsvdir-start ]; then \
#        cp -a /etc/runit/2 /usr/sbin/runsvdir-start; \
#    fi
#
#ENV PATH=$PATH:/opt/couchbase/bin:/opt/couchbase/bin/tools:/opt/couchbase/bin/install
#RUN groupadd -g 1000 couchbase && useradd couchbase -u 1000 -g couchbase -M

RUN mkdir -p /tmp/couchbase && \
    cd /tmp/couchbase && \
    wget -qO https://packages.couchbase.com/releases/7.0.0-beta/couchbase-server-enterprise_7.0.0-beta-ubuntu20.04_amd64.deb
