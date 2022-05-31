# Micros services using Host Network

Inspired from from (https://www.youtube.com/watch?v=2BzZQUlx_YY)
Part 1 Micro Services avec Spring Cloud Concepts Gateway Registry Services


## This project illustrates microservices calling microservices in a load balanced mode
4 microservices are built : 
- myeureka : registry name/value of all microservices ( except myeureka, of cours ;o)  
- mygateway : loadbalancer role, using eureka to resolve microservices addresses
- inventory : a simple spring boot project
- customer : a simple spring boot project calling inventory to illustrate how a microservice
can call another one. 

## Pre-requirements
You need at least 3 VM to play with this project : i will call them VM 1 2 and 3
You need to have a dockerHub account to push and pull images

## Step 1 : build images
Build your 4 images and push them to dockerhub with a command line as below ( don't forget to pick up the "dot" at the end of the command line ).
Example for "mygateway". The docker file is in mygateway/src/main/resources/Dockerfile

`$ docker build -t alpine/gateway:latest -f src/main/resources/Dockerfile .`

## Step 2 : push images
Push your 4 images to your dockerhub. Example for "mygateway" : 

`docker push skeres95250/alpine_gateway:latest`

## Step 3 : launch Virtual Machines
Launch VM 1 , 2 and 3

## Step 3.1 : customize eureka for static ip
Im using KVM/Qemu for VM instance. My personnal ip for Eureka is 192.168.122.99. Customize your own so that Eureka will always have the same IP. this can be done using VM1 MAC adresse  : virsh net-edit default, then configure range ip for DHCP, and fix Eureka Mac address on a specific port. Please Google this step depending on VM you have installed.

## Step 3.2 : set Eureka ip in each docker-compose files
example for my personnal desktop Ubuntu 20.04 :  eureka.client.service-url.defaultZone: http://192.168.122.99:8761/eureka

### Step 4 : copy files on each VM
Using compose_for_VM/eureka/docker-compose-eureka.yml, copy and paste this file on VM1
Using compose_for_VM/gateway_et_services/docker-compose-gateway.yml, copy and paste this file on VM1
Using compose_for_VM/gateway_et_services/docker-compose-inventory8090.yml, copy and paste this file on VM1
Using compose_for_VM/gateway_et_services/docker-compose-inventory8091.yml, copy and paste this file on VM2
Using compose_for_VM/gateway_et_services/docker-compose-inventory8092.yml, copy and paste this file on VM3
Using compose_for_VM/gateway_et_services/docker-compose-customer.yml, copy and paste this file on VM3

### Step 5 : run containers in  each VM
You have to run 1 Eureka, 1 Gateway, 3 inventory, 1 customer. Repeat the command below for each instance : 
`$ docker-compose -f docker-compose-eureka.yml up -d`

### Step 6 : check running containers
Using Chrome or Mozilla, go to Eureka address to check health of each containers : http://192.168.122.99:8761


### Step 7 : check the result, it works !
Using chrome or Mozilla, connect to the customer instance and try to call inventory using customer API
With KVM, you can use this virsh command to get all ip address of running VMs : 

`virsh net-dhcp-leases default`

Calling API : 

`http://192.168.122.:198/callInventory`


You should get this message : 

`le message de retour de inventory est : le test fonctionne`

You can verify the load balancing round robin mode by cheking logs in an inventory container. After 3 refresh on the web page, the log file will display your request : 

`docker logs container-id --follow`


## Tip : how access H2 database ?
http://localhost:8081/h2-console			: access H2 console with localhost
http://192.168.122.101:8082/h2-console		: access H2 console on VM ip 192.168.122.101


