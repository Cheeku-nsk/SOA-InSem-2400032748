# SOA In-Semester Examination Project

A Microservices-based Student Management System built using **Spring Boot**, **Spring Cloud Netflix Eureka**, and **Spring Data JPA**.

---

## 📌 Architecture Overview

This project consists of two core microservices:

1. **`Eueka-Server`** (Eureka Discovery Server):
   - Service discovery registry that manages and tracks active microservice instances.
   - Runs on port **`8761`**.
   - Web Dashboard: [http://localhost:8761](http://localhost:8761)

2. **`Student-Serivce`** (Student Microservice):
   - RESTful service for managing student information (adding and displaying student records).
   - Backed by Spring Data JPA and an in-memory H2 database.
   - Registers as an Eureka client (`STUDENT-SERVICE`) with `Eueka-Server`.
   - Runs on port **`8081`**.

---

## 🚀 Features & API Endpoints

Base URL: `http://localhost:8081/student`

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/student/` | Welcome endpoint returning service status. |
| `GET` | `/student/displaystudent` | **Displays student details directly in the web browser** (JSON). If no student is stored yet, automatically seeds and displays default student details. (Also supports `/student/displayStudent`). |
| `GET` | `/student/displaystudent/{id}` | Displays details of a specific student by ID in the web browser. |
| `POST` | `/student/add` | Adds a new student record to the database (supports JSON payload). |

---

## 📋 API Usage & Browser Testing

### 1. Display Student Details on Web Browser
Simply open your web browser (Chrome, Edge, Firefox) and navigate to:
```
http://localhost:8081/student/displaystudent
```
**Sample Browser Response:**
```json
[
  {
    "id": 1,
    "name": "Kousik",
    "department": "CSE"
  }
]
```

To display a specific student by ID:
```
http://localhost:8081/student/displaystudent/1
```
**Sample Response:**
```json
{
  "id": 1,
  "name": "Kousik",
  "department": "CSE"
}
```

### 2. Add a Student Record (POST)
Send a POST request using Postman or cURL:
```bash
curl -X POST http://localhost:8081/student/add \
  -H "Content-Type: application/json" \
  -d '{"name": "Rahul", "department": "ECE"}'
```
**Response:**
```json
{
  "id": 2,
  "name": "Rahul",
  "department": "ECE"
}
```

---

## 🛠️ Prerequisites

- **Java JDK 17** or higher (Java 25 LTS supported)
- **Maven** (or use the included `mvnw` wrapper)

---

## 🏃 Running the Services

### Step 1: Start Eureka Server
Open a terminal in the project root:
```bash
cd Eueka-Server
# On Windows:
mvnw.cmd spring-boot:run
# On Linux/macOS:
./mvnw spring-boot:run
```
Once started, verify the Eureka dashboard at [http://localhost:8761](http://localhost:8761).

### Step 2: Start Student Service
Open a second terminal:
```bash
cd Student-Serivce
# On Windows:
mvnw.cmd spring-boot:run
# On Linux/macOS:
./mvnw spring-boot:run
```
The service will register with Eureka under the application name `STUDENT-SERVICE`.

### Step 3: Run Tests
To run the automated tests:
```bash
cd Student-Serivce
mvnw.cmd test
```

---

## 📦 Pushing to Git Repository

Follow these steps to initialize and push this project into your Git repository:

```bash
# 1. Initialize git in the root directory (if not already done)
git init

# 2. Add all files (the provided .gitignore excludes build and IDE metadata)
git add .

# 3. Create initial commit
git commit -m "feat: add displaystudent service and controller endpoints, tests, and documentation"

# 4. Set main branch
git branch -M main

# 5. Link your remote GitHub/GitLab repository
git remote add origin <YOUR_REPOSITORY_URL>

# 6. Push to your repository
git push -u origin main
```
