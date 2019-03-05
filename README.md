# Spring Boot Kafka - Produce and Consume

Proof of Concept application to show how you can produce and consume Kafka messages in Spring Boot.

* send message to broker
* consume message from broker
* show message in browser via a socket

### Getting started


##### Set up a Kafka Broker

For the sake of ease I´ve used a hosted Kafka Broker at [Cloudkarafka](https://www.cloudkarafka.com/) 
 
You can [Sign up here](https://customer.cloudkarafka.com/instance/create?plan=ducky) for a free :tada: Developer Duck plan and set up your own broker test instance (or you can set one up yourself locally) 

##### Environment variables
After signing up and creating a new broker instance put your connection details in the env vars:


- CLOUDKARAFKA_USERNAME
- CLOUDKARAFKA_PASSWORD
- CLOUDKARAFKA_TOPIC_PREFIX 
- CLOUDKARAFKA_BROKERS


##### Create a new topic

Then go ahead and create a new topic called message (it will look like this=> \[yourusername\]-message)


##### That's it

Start the application and go to http://localhost:8080




## Docker/Kubernetes (minikube)

Set environment variables in `deployment.yaml file

`$ minikube start` start minikube or do it from Docker menu

`$ kubectl config use-context minikube` switch to minikube

`$ gradle clean build` 

`$ eval $(minikube docker-env)` enable local docker registry

`$ docker build --no-cache -t kafka-messaging .`

`$ docker image ls` verify docker image

`$ kubectl create -f deployment.yaml` create a new deployment

`$ kubectl get pods` verify pod

`$ kubectl expose deployment/kafka-messaging --type="NodePort" --port 8080` expose your app 

`$ minikube service kafka-messaging` open the running app in default browser


##### Clean up

`$ kubectl delete service kafka-messaging`

`$ kubectl delete deployment kafka-messaging`
