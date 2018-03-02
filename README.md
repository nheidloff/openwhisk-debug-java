# Debugging Java OpenWhisk Functions in local IDEs

This [project](https://github.com/nheidloff/openwhisk-debug-java) shows how [Apache OpenWhisk](http://openwhisk.org/) functions can be developed and debugged locally via ....


to be done







docker-compose up --build


docker build -t nheidloff/openwhisk-docker-spring-boot:latest .
docker run -p 8080:8080 --rm=true nheidloff/openwhisk-docker-spring-boot:latest



bx login -a api.ng.bluemix.net
$ bx target -o <your-ibm-cloud-organization> -s <your-ibm-cloud-space>
$ bx plugin install Cloud-Functions -r Bluemix
$ cd openwhisk-debug-nodejs/functions/docker

docker build -t <dockerhub-name>/openwhisk-docker-spring-boot:latest .
docker build -t nheidloff/openwhisk-docker-spring-boot:latest .


docker push <dockerhub-name>/openwhisk-docker-spring-boot
docker push nheidloff/openwhisk-docker-spring-boot

bx wsk action create actionDockerSpring --docker <dockerhub-name>/openwhisk-docker-spring-boot:latest

bx wsk action update actionDockerSpring --docker nheidloff/openwhisk-docker-spring-boot:latest



bx wsk action invoke --blocking actionDockerSpring --param-file parameters.json 
 

curl --request POST \
  --url http://localhost:8080/run \
  --header 'Cache-Control: no-cache' \
  --header 'Content-Type: application/json' \  
  --data '{ "value": {"parameter1":"Niklas","parameter2":"Heidloff"}}'