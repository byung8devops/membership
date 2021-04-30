#!/bin/bash

sudo mkdir -p /data/membership/logs
sudo chown -R bd:bd /data

docker run -d -p 8080:8080 --restart=always --name membership \
-v /usr/share/zoneinfo/Asia/Seoul:/usr/share/zoneinfo/Asia/Seoul \
-v /etc/localtime:/etc/localtime \
-v /data/membership/logs:/data/membership/logs \
gw01.bd.com:5000/fitness/membership:0.1

