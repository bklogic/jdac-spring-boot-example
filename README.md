# JDAC Spring Boot Example Application

The purpose of this example application is

- To showcase the streamlined data access development process with JDAC Spring Boot Starter 
backed by data access services; and
- To provide a working example of Spring Boot Application using JDAC Spring Boot Starter.

You should be able to clone this application and run it against the 
[Example Data Access Application](https://github.com/bklogic/data-access-service-example) deployed into
a BackLogic workspace of yours.

Once you have the `Example Data Access Application` deployed into your BackLogic workspace using `Service Builder`,
you may navigate to `show workspace` to get the baseUrl and a JWT token to reconfigure the 
`baseUrl` and `jwtProvider.jwt` properties in the `application.yml` file.

The JDAC example application has enabled Swagger, and therefore you may view and test the example APIs 
with the link below, assuming you are running your JDAC Spring Boot application from your local machine:

http://localhost:8090/swagger-ui/index.html

These example should be able to show you how to use the `@QueryService`, `@CommandService` and 
`@RepositoryService` interfaces, and also show you how complex the objects that you read and write can be.

