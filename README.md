# Spring Boot Kafka - Produce and Consume

Proof of Concept application to show how you can produce and consume Kafka messages in Spring Boot.

### Getting started


##### Set up a Kafka Broker

For the sake of ease I´ve used a hosted Kafka Broker at [Cloudkarafka](https://www.cloudkarafka.com/) 
 
You can [Sign up here](https://customer.cloudkarafka.com/instance/create?plan=ducky) for a free :tada: Developer Duck plan and set up your own broker test instance (or you can set one up yourself locally) 

##### Env vars
After signing up and creating a new broker instance put your connection details in the env vars:

* CLOUDKARAFKA_USERNAME
* CLOUDKARAFKA_PASSWORD
* CLOUDKARAFKA_TOPIC_PREFIX 
* CLOUDKARAFKA_BROKERS


##### Create a new topic

Then go ahead and create a new topic called message (it will look like this=> \[yourusername\]-message)


##### That's it

Start the application and go to http://localhost:8080

