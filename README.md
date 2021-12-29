Photomanager 2021 - Testproject ![Build Status](https://travis-ci.org/shekhargulati/spring-boot-maven-angular-starter.svg?branch=master)
-----

This ist just a test project to train the spring and angular skills.

This project provides productive setup for building Spring Boot Angular applications. The application is divided into two Maven modules:



## Running the full application

You can build the package as a single artifact by running the `./mvnw clean install`.
Next, you can run the application by executing:

```bash
$ java -jar backend/target/ngboot-app.jar
```

The application will be accessible at `http://localhost:8080`.

## Features


## Running the backend for development mode

There are multiple ways to run the backend. For development, you can use your favorite IDE and run the
`com.example.app.Application`. As soon as your code compiles, Spring Boot DevTools will reload the code.

You can also run the application using Maven.

```bash
$ cd backend
$  ../mvnw spring-boot:run
```

## Running the frontend for development mode

Make sure to install [yarn on your development machine](https://yarnpkg.com/en/docs/install).

To install all the required binaries for your project, you can run following command.

```
$ cd frontend
$ ../mvnw frontend:install-node-and-yarn frontend:yarn
```

Once the above command finishes, you can start the frontend using the `yarn start` command.

## Hot reloading

Both the front-end and back-end modules support hot reloading.
