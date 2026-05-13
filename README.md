# Library Management System

A RESTful API for managing a library built with Spring Boot, JWT Authentication, Spring Security, and PostgreSQL.

## Tech Stack
- Java 21
- Spring Boot 4.x
- Spring Security 6 + JWT
- PostgreSQL
- Spring Data JPA + Hibernate
- Lombok
- Bean Validation

## Features
- User Registration & Login with JWT Authentication
- Book CRUD (Create, Read, Update, Delete)
- User Management
- Role-based access (ADMIN, USER)
- Global Exception Handling
- Bean Validation

## API Endpoints

### Auth (Public)
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |

### Books (Protected)
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/books/add | Add a new book |
| GET | /api/books/all | Get all books |
| GET | /api/books/{id} | Get book by ID |
| PUT | /api/books/update/{id} | Update book |
| DELETE | /api/books/delete/{id} | Delete book |

### Users (Protected)
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/users/all | Get all users |
| GET | /api/users/{id} | Get user by ID |
| PUT | /api/users/update/{id} | Update user |
| DELETE | /api/users/delete/{id} | Delete user |

## Setup

1. Clone the repo
2. In application.properties there are details
3. Fill in your PostgreSQL credentials
4. Run `mvn spring-boot:run`

## Security
All endpoints except `/api/auth/**` require a valid JWT token in the Authorization header:
```
Authorization: Bearer <your_token>
```
