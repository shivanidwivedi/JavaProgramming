package restful;

/**
 https://spring.io/guides/gs/rest-service/
 https://github.com/spring-guides/gs-rest-service

 What You Will Build
 You will build a service that will accept HTTP GET requests at http://localhost:8080/greeting.

 It will respond with a JSON representation of a greeting, as the following listing shows:

 {"id":1,"content":"Hello, World!"}COPY
 You can customize the greeting with an optional name parameter in the query string, as the following listing shows:

 http://localhost:8080/greeting?name=UserCOPY
 The name parameter value overrides the default value of World and is reflected in the response, as the following listing shows:

 {"id":1,"content":"Hello, User!"}

 */