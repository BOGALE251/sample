# Dependecies

- Java EE 8
- Glassfish 5.0.1
- db-derb 10.14.2.0

Tests were done using postman. 

### Example1 : create user service

Method : POST

Url : http://localhost:8080/demo1-1.0-SNAPSHOT/api/user

Body : {
    "userName": "John",
    "age" : 19,
    "email": "someemail@gmail.com",
    "country" : "France"
}

### Example 2 : get user service

Method : GET 

Url : http://localhost:8080/demo1-1.0-SNAPSHOT/api/user?userName=John
