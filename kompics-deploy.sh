#!/bin/bash

VERSION=2.3.0

mvn  deploy:deploy-file -Durl=scpexe://kompics.i.sics.se/home/maven/repository \
                      -DrepositoryId=sics-release-repository \
                      -Dfile=./jdbc-handler/target/hive-jdbc-handler-${VERSION}.jar \
                      -DgroupId=io.hops \
                      -DartifactId=hive-jdbc-handler \
                      -Dversion=${VERSION} \
                      -Dpackaging=jar \
                      -DpomFile=./jdbc-handler/pom.xml \
-DgeneratePom.description="Hive JDBC Handler"
