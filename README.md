# Template for a browser clicker game
This would work as a template for any web game that barely requires anything besides simple server requests.
However, it should be used for personal testing and not for a professional project, since the login system is not secure at all, the limit for a user's score is a 32 bit integer's limit and due to other issues.
The purpose is to illustrate how a clicker game might work in a very simple way and maybe power a small game to play with your friends.
## Usage
Clone the repository, set up a database using the sql file in it and change the configuration in
``src/main/resources/application.properties``, start the database service and run:
```
mvn spring-boot:run
```

This will start the server, then you can enter https://localhost:8080/ in a browser to interact with it.
## Tools/languages used
#### Backend
- Java
- Spring-boot
- Maven
- Hibernate
#### Frontend
- HTML
- JavaScript

Mariadb for the database, but since it's completely separated from the server you may use any.
