# ecom-app-with-microservices

A small micro-service application developped using Spring boot 2.7.11, Spring Cloud Framework(2021.0.7) and Java 17:coffee:. 

We have tree business services : Billing + Customer + Inventory, each service has a small H2 database that contains one table for demo.

Billing service communicates with other services by sending REST requests using openfeign client.

All services sends their configurations to discovery service(netflix-eureka-server).

All HTTP requests should be go through Gateway(8888) that protect access to our services.

Gateway configuration was Dynamic, then you need just the name of service to send a requests.  

A picture below show us architecture of our micro-services :

<p align="center">
  <img src="https://github.com/najiboulhouch/ecom-app-with-microservices/blob/master/ecom-app-micro-service-architecture.drawio.png?raw=true" />
</p>



Feel free to downaload my code and make any updates.:fire:


<b>NAJIB</b> :v:
