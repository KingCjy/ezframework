#!/bin/bash


cd /Users/kingcjy/git/ezframework

mvn clean install -pl ezframework -am
mvn clean package -pl sample -am
mv sample/target/sample-1.0-SNAPSHOT.jar server/plugins/sample-1.0.jar

cd /Users/kingcjy/git/ezframework/server
java -jar -Xmx2G -Xms1G -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 spigot-1.15.2.jar
