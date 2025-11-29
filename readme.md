# Spring Boot Backend Practice - Hani Ismail - 202495201

This project is part of the Backend Framework Practice Assignment.  
It implements a simple REST API using **Spring Boot**, following the requirements from the course.

## Project Features

- 8 REST API endpoints  
  - 2 GET  
  - 2 POST  
  - 2 PUT  
  - 2 DELETE  
- Standardized JSON responses  
- Custom logging middleware  
- Usage of multiple HTTP status codes (2xx, 4xx, 5xx)  
- Tested using Postman

---

## How to Run

```bash
mvn spring-boot:run
```

The server runs on:

```bash
http://localhost:8080
```

## API Endpoints

### **GET**
- `GET /users` – return all users
- `GET /users/{id}` – return a user by ID

### **POST**
- `POST /users` – create a new user
- `POST /users/crash` – simulate a server crash (500)

### **PUT**
- `PUT /users/{id}` – update an existing user
- `PUT /users/validate` – validate user data (returns 400 on invalid input)

### **DELETE**
- `DELETE /users/{id}` – delete a user
- `DELETE /users/crash` – simulate a delete crash (500)


## Middleware

A simple logging middleware prints each incoming request:

```bash
[REQUEST] METHOD /path | time=xxxx
```

## Standard Response Format

All API endpoints return the same JSON structure:

```json
{
  "status": "success" or "error",
  "data": ...,
  "message": "optional message"
}
```

---

## Submission

This repository includes:

- Source code
- README
- Screenshots (Postman + IntelliJ)
