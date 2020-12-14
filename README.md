# Enrollee Microservice
 demo microservice implementation using Spring Boot 

This is the full scale (not exactly, but close to be) microservice for Enrollee / Dependent service, besides the Enrollee service and Dependent service, it has other microservices components, such as config server, service discovery server, API gateway, distribute tracing, centralized logging (Zipkin server), etc.

Here are some basic requirements, include:

Enrollee must have id, name, status and birth date Enrollee may have a phone number Enrollee may have zero or more dependents Each Dependents must have an id, name, and birth date

If you have more interesting of how the Restful API was implemented, check out another project (RestApiV1), this project will focus more on the microservice modules.

Step 1: 

clone this project (git clone), or download source code as zip file, then unzip it to local, import the projects into IDE (such as Eclipse or Intellij).

Step 2:

Build the Eureka Discovery Server, start it at port 8761

note: 
check http://localhost:8761 for registered service (wait after each service started, refresh and be patient)

Step 3:

Build the Config Server, start it at port 8888

note: 
check http://localhost:8888/application/default for default setting
check http://localhost:8888/enrolleeservice/default for default setting of enrollee service
check http://localhost:8888/dependenteservice/default for default setting of dependent service

Step 4:

Build the Dependent Service, start it at port 8081

note:
check out its endpoint mapping, and test it in postman

Step 5:

Build the Enrollee Service, start it at port 8080

note:
check out its endpoint mapping, and test it in postman, pay attention to rest service call, such as get list of dependents for one enrollee, create list of dependents for one enrollee, delete all the dependents for one enrollee

Step 6:

Build the Zuul Server, start it at port 8762

note:
test the API routing, such as http://localhost:8762/dependentservice/dependent

Step 7:

Start Zipkin Server from command line (assume the Zipkind server was downloaded and installed properly), such as

> java -jar zipkin-server-VERSION-exec.jar

note:
check the log (or call trace) from Zipkin server, http://localhost:9411/zipkin/, add service name, then run query, remember to use Postman to test the endpoint, and check its trace.


Hint:

If any step failed, it may be the configuration issue, or the dependency issue (like missing jar or version mismatch).

Future enhancements:

1. create slightly different version for DEV, QA

2. One key missing point is the security, it will be a nice add on feature if add security

3. add one more service call implementation using webclient (Reactive approach)

4. add circuit break (Hystrix) between enrollee and dependent, in case dependent rest call is failed, it will return an empty object as default

5. add redis cache for dependent service, so there is no need to retrieve the same information if it was cached (and not expired)

6. add RabbitMQ as message queue, so the request can be send to message queue, and handle async (it may be overcut for this simple scenario)

7. ELK can be set up as the logging collection, analysis tool, it is relatively easy to be done.

8. build as docker image, and deploy it local for testing, or deploy it to AWS Elastic Beanstalk for testing.

Any suggestion other than what I listed here.
