# Employee Management System

A Java-based backend application built using **Spring Boot** to manage employee records through RESTful APIs. The project follows a layered architecture and demonstrates backend development concepts such as Spring MVC, Spring Data JPA, MySQL integration, validation, exception handling, and application configuration.

## Overview

The Employee Management System provides APIs to perform essential employee management operations, including creating, retrieving, updating, and deleting employee records.

The application is designed with a maintainable architecture that separates responsibilities across the Controller, Service, and Repository layers.

## Tech Stack

| Category | Technologies |
|---|---|
| Language | Java |
| Backend Framework | Spring Boot |
| Web Layer | Spring MVC, REST APIs |
| ORM | Hibernate, Spring Data JPA |
| Database | MySQL |
| Validation | Jakarta Bean Validation |
| Security | Spring Security |
| Testing | JUnit 5, Mockito |
| Build Tool | Maven |
| Development Tools | IntelliJ IDEA, Postman |
| Version Control | Git, GitHub |

## Features

### Employee Management
- Create new employee records.
- Retrieve all employees.
- Retrieve employee details using employee ID.
- Update existing employee information.
- Delete employee records.
- Retrieve employees using custom query methods.

### Backend Architecture
- Layered architecture using Controller, Service, and Repository.
- RESTful API design.
- Dependency Injection and Inversion of Control.
- Spring Data JPA for database operations.
- Hibernate ORM for entity management.

### Validation and Exception Handling
- Input validation using annotations such as `@NotBlank`, `@Email`, and `@Min`.
- Centralized exception handling using `@ControllerAdvice`.
- Custom exceptions for employee-related errors.
- Meaningful HTTP status codes and error responses.

### Advanced Spring Boot Concepts
- Logging using SLF4J.
- Caching using Spring Cache.
- Scheduled tasks using `@Scheduled`.
- Asynchronous processing using `@Async`.
- Environment-specific configuration using Spring Profiles.
- Externalized configuration using `@ConfigurationProperties`.

### Security
- Spring Security fundamentals.
- Authentication and authorization concepts.
- Role-based access control.
- Password encoding using BCrypt.
- JWT authentication, if enabled and verified in the current implementation.

### Testing
- Unit testing using JUnit 5.
- Mocking dependencies using Mockito.
- Service-layer testing.
- REST controller testing using MockMvc.

## Project Structure

```text
employee-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mukti/employee_management_system/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── EmployeeController.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── EmployeeService.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── EmployeeRepository.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   └── Employee.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │
│   │   │       ├── exception/
│   │   │       │
│   │   │       ├── config/
│   │   │       │
│   │   │       └── EmployeeManagementSystemApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/mukti/employee_management_system/
│
├── pom.xml
└── README.md
```

*The structure above is illustrative. Update it to match your actual package and file names.*

## Database Configuration

The project uses MySQL as its relational database.

### 1. Create the database

```sql
CREATE DATABASE employee_management_system;
```

### 2. Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace `YOUR_PASSWORD` with your local MySQL password. Do not commit real database credentials to GitHub.

## Installation and Setup

### Prerequisites

Make sure you have installed:

- Java JDK
- Maven
- MySQL Server
- IntelliJ IDEA or another Java IDE
- Postman (for API testing)

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Navigate to the project directory

```bash
cd employee-management-system
```

### 3. Configure MySQL

Create the database and update the database credentials in `application.properties`.

### 4. Build the project

```bash
mvn clean install
```

### 5. Run the application

```bash
mvn spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

## REST API Endpoints

The following table describes the standard employee CRUD endpoints. Confirm the paths and HTTP methods against your actual controller.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/employees` | Retrieve all employees |
| GET | `/employees/{id}` | Retrieve employee by ID |
| POST | `/employees` | Create a new employee |
| PUT | `/employees/{id}` | Update employee details |
| DELETE | `/employees/{id}` | Delete an employee |

### Example: Create Employee

**Request**

```http
POST /employees
Content-Type: application/json
```

**Request Body**

```json
{
  "name": "Rahul Sharma",
  "email": "rahul@gmail.com",
  "department": "Engineering",
  "salary": 50000
}
```

**Expected response:** HTTP `201 Created`, with the saved employee details.

### Example: Retrieve Employee

```http
GET /employees/1
```

**Expected response:** HTTP `200 OK`, with the employee details when the record exists.

## Testing

Run the test suite using:

```bash
mvn test
```

Testing technologies:

- **JUnit 5:** Writing and executing test cases.
- **Mockito:** Mocking repository and service dependencies.
- **MockMvc:** Testing REST controller endpoints.

## Learning Outcomes

Through this project, I am developing practical experience in:

- Building backend applications using Java and Spring Boot.
- Designing and implementing RESTful APIs.
- Working with relational databases using MySQL and Spring Data JPA.
- Applying layered architecture and clean code principles.
- Implementing validation and centralized exception handling.
- Understanding authentication and authorization.
- Writing unit and controller tests.
- Using Git and GitHub for version control.

## Future Enhancements

- API documentation using Swagger / OpenAPI.
- Redis-based distributed caching.
- Docker-based application deployment.
- Cloud deployment using AWS.
- Improved integration and end-to-end testing.
- Pagination, sorting, and filtering enhancements.

## Author

**Mukti Kumari**

B.Tech Computer Science and Engineering

Interested in Backend Development, Java, Spring Boot, Data Structures and Algorithms, and Software Engineering.

[GitHub Profile](https://github.com/MuktiKumari983)

---

*This project is part of my continuous learning journey in Java backend development and software engineering.*
