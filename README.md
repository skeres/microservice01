# Inspired from from (https://www.youtube.com/watch?v=2BzZQUlx_YY)
### Part 1 Micro Services avec Spring Cloud Concepts Gateway Registry Services


# This project illustrates microservices calling microservices in a load balanced mode
4 microservices are built : 
- myeureka : registry name/value of all microservices ( except myeureka, of cours ;o)  
- mygateway : loadbalancer role, using eureka to resolve microservices addresses
- inventory : a simple spring boot project
- customer : a simple spring boot project calling inventory to illustrate how a microservice
can call another one. 

# Pre-requirements
You need at least 3 VM to play with this project : i will call them VM 1 2 and 3
You need to have a dockerHub account to push and pull images

# Step 1
Build your 4 images and push them to dockerhub with a command line as below

`$ docker build -t alpine/gateway:latest -f src/main/resources/Dockerfile .`

# Step 2
Push image to your dockerhub. Example : 

`docker push skeres95250/alpine_gateway:latest`





# Tip : how access H2 database ?
http://localhost:8081/h2-console			: access H2 console with localhost
http://192.168.122.101:8082/h2-console		: access H2 console on VM ip 192.168.122.101


