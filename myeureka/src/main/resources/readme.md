to build image : 
cd root/of/project  ( here root is myeureka )
docker build -t alpine/eureka:latest -f src/main/resources/Dockerfile .


TIPS
** how check and install cURL on alpine :
apk search curl
apk -av info curl
apk update
apk add curl

** Installing curl documentation and man pages
apk add curl-doc

** get ip
ip addr
