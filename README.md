# Stompy Rhino API

Spring Boot API server for resource management, secured with Spring Security.

## Description

This project is an API for a secure resource management system. It uses Spring Boot and Spring Security to provide a foundation for role-based and ownership-based access control for various resources.

## Prerequisites

To build and run this project, you will need:
- **Java 21**: Ensure you have a JDK 21 distribution installed.
- **Apache Maven**: The project uses Maven for dependency management and build automation.
- **Docker**: Required for running integration tests against a real database via Testcontainers.

## Getting Started

### Running the Application
To start the application, run the following command from the project root:

./mvnw spring-boot:run


The application will start on the default port (usually 8080).
### Running Tests
To run the full test suite, including the Testcontainers-based integration tests, run:

`./mvnw test`

Make sure Docker is running before executing the tests.
### Security Configuration
For local development, a default in-memory user has been configured in `src/main/resources/application.yml`:
- **Username**: `user`
- **Password**: `password`
- **Role**: `READER`