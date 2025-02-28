# To-Do List Service

A simple RESTful API built with Spring Boot for managing To-Do items. This project allows users to create and view their To-Do list items, with authentication and authorization for user-specific data.

---

## Features
- Create new To-Do items
- Retrieve To-Do items by user
- H2 in-memory database for quick setup and testing

---

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- MapStruct (for object mapping)

---

## Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven

---

## Getting Started

1. **Clone the repository:**
```bash
git clone https://github.com/huuphuoc2105/todo-list-service.git
cd todo-list-service
```

2. **Run the application**
```bash
mvn spring-boot:run
```

## API Endpoints

### Create a new To-Do item with username="abc"
```
curl --location 'http://localhost:8080/api/todos/abc' \
--header 'Content-Type: application/json' \
--data '{
    "title": "Test2", 
    "description": "Test description2",
    "completed": true
}'
```

### Get all To-Do items belong to username="abc"
```
curl --location 'http://localhost:8080/api/todos/abc'
```
