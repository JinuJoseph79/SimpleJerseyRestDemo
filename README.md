# Project
SimpleJerseyRestDemo is simple project to demonstrate Jersey Restful web services. HTTP methods, GET, POST, PUT, DELETE is used in the application. POST is used to save employee details to Microsoft SQL Server database table Employees. Get fetch the employee details from table and display in browser. PUT is used to update employee details and Delete to delete employee from the table

## Getting Started
This repository contains the code for the HackOn registration application. The code can be cloned to local directory.

Dependencies:
org.glassfish.jersey
org.glassfish.jersey.containers
com.microsoft.sqlserver

Run the application on Tomcat server. You can use browser or Postman to test the methods

 
## Features
Create, fetch, update and delete Employee details using Jersey Rest HTTP methods

## Deployment 
Run on Tomcat server. 

Test using Postman
GET - http://localhost:8080/SimpleJerseyRestDemo/webapi/Employees

## Technology used

Eclipse Jersey is used for developing RESTful Web services. Jersey RESTful Web Services framework which is an open source,
 production quality, framework for developing RESTful Web Services in Java that provides support for JAX-RS APIs.

HTTP Methods:
The PUT, GET, POST and DELETE methods are typical used in REST based architectures. The following table gives an explanation of these operations.

GET defines a reading access of the resource without side-effects. The resource is never changed via a GET request, e.g., the request has no side effects (idempotent).

PUT creates a new resource. It must also be idempotent.

DELETE removes the resources. The operations are idempotent. They can get repeated without leading to different results.

POST updates an existing resource or creates a new resource

Microsoft SQL Server 2019 is used for database.  Microsoft SQL Server Management Studio is used to connect to the database server using SQL Server Authentication. After login create database and create Employee table to save the Employees details.

## Environment

Operation System: Windows 10

Java Version: Java 8
 
