#!/bin/bash

VERSION=2.3.0

# Hive Common
mvn  deploy:deploy-file -Durl=scpexe://kompics.i.sics.se/home/maven/repository \
                      -DrepositoryId=sics-release-repository \
                      -Dfile=./common/target/hive-common-${VERSION}.jar \
                      -DgroupId=io.hops \
                      -DartifactId=hive-common \
                      -Dversion=${VERSION} \
                      -Dpackaging=jar \
                      -DpomFile=./common/pom.xml \
-DgeneratePom.description="Hive Common"

mvn  deploy:deploy-file -Durl=scpexe://kompics.i.sics.se/home/maven/repository \
                      -DrepositoryId=sics-release-repository \
                      -Dfile=./jdbc/target/hive-jdbc-${VERSION}.jar \
                      -DgroupId=io.hops \
                      -DartifactId=hive-jdbc \
                      -Dversion=${VERSION} \
                      -Dpackaging=jar \
                      -DpomFile=./jdbc/pom.xml \
-DgeneratePom.description="Hive JDBC"

mvn  deploy:deploy-file -Durl=scpexe://kompics.i.sics.se/home/maven/repository \
                      -DrepositoryId=sics-release-repository \
                      -Dfile=./jdbc-handler/target/hive-jdbc-handler-${VERSION}.jar \
                      -DgroupId=io.hops \
                      -DartifactId=hive-jdbc-handler \
                      -Dversion=${VERSION} \
                      -Dpackaging=jar \
                      -DpomFile=./jdbc-handler/pom.xml \
-DgeneratePom.description="Hive JDBC Handler"

mvn  deploy:deploy-file -Durl=scpexe://kompics.i.sics.se/home/maven/repository \
                      -DrepositoryId=sics-release-repository \
                      -Dfile=./service/target/hive-service-${VERSION}.jar \
                      -DgroupId=io.hops \
                      -DartifactId=hive-service \
                      -Dversion=${VERSION} \
                      -Dpackaging=jar \
                      -DpomFile=./service/pom.xml \
-DgeneratePom.description="Hive Service"

mvn  deploy:deploy-file -Durl=scpexe://kompics.i.sics.se/home/maven/repository \
                      -DrepositoryId=sics-release-repository \
                      -Dfile=./service-rpc/target/hive-service-rpc-${VERSION}.jar \
                      -DgroupId=io.hops \
                      -DartifactId=hive-service-rpc \
                      -Dversion=${VERSION} \
                      -Dpackaging=jar \
                      -DpomFile=./service-rpc/pom.xml \
-DgeneratePom.description="Hive Service"
