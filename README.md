# User Management Backend API

A production-ready, lightweight User Management REST API built using **Spring Boot 3** and **Java 17**. This project implements a fully decoupled **3-Tier Architecture** (Controller, Service, Repository) to manage user entity life cycles cleanly with structured CRUD processing.

---

## 🚀 Features

- **Full CRUD Capabilities:** Support for creating, reading, updating, and deleting user entries.
- **3-Tier Architecture:** Complete separation of concerns between HTTP layers, business logic, and database access.
- **In-Memory Storage:** Lightweight data storage utilizing an embedded H2 database.
- **Automated Object Relational Mapping:** Managed via Spring Data JPA and Hibernate schemas.

---

## 🛠️ Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3.x
- **Data Access:** Spring Data JPA / Hibernate
- **Database:** H2 (In-Memory Database)
- **Build Tool:** Maven

---

## 📐 Project Architecture

```text
Incoming HTTP Request
       │
       ▼
 [ Controller Layer ]   --> UserController.java (Manages endpoints & HTTP routing)
       │
       ▼
  [ Service Layer ]    --> UserService.java (Executes core business logic rules)
       │
       ▼
 [ Repository Layer ]  --> UserRepository.java (Performs direct database access actions)
       │
       ▼
   [ Database ]        --> H2 Memory Data Engine


🚦 API Endpoints
HTTP Method	Endpoint	Description	Sample JSON Payload
GET	/api/users	Fetch all registered users	None
POST	/api/users	Register a new user profile	{"name": "Pooja Singh", "email": "pooja@example.com"}
PUT	/api/users/{id}	Update an existing user's details	{"name": "Pooja Singh Updated", "email": "new@example.com"}
DELETE	/api/users/{id}	Permanently drop a user entry	None
