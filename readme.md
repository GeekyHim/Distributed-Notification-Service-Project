# 🚀 Distributed Notification Engine

A **production-grade, event-driven notification system** built using **Spring Boot and Apache Kafka**.
This project demonstrates scalable backend architecture with asynchronous processing, fault tolerance, and clean design patterns.

---

## 📌 Overview

This system allows users to send notifications (Email, SMS) via a REST API.
Instead of processing requests synchronously, messages are pushed to Kafka and handled asynchronously by consumers.

---

## 🏗️ Architecture

```
Client → REST API → Kafka (Producer) → Consumer → Strategy → Notification Sent
                                      ↓
                                   DLQ (on failure)
```

---

## ⚙️ Tech Stack

* **Backend:** Spring Boot (Java 21)
* **Messaging:** Apache Kafka
* **Containerization:** Docker
* **Build Tool:** Maven
* **Design Patterns:** Strategy Pattern
* **Architecture Style:** Event-Driven Microservice

---

## ✨ Features

### ✅ Asynchronous Processing

* Decouples request handling using Kafka
* Improves scalability and responsiveness

### ✅ Strategy Pattern

* Clean separation for notification channels
* Easily extendable (Email, SMS, Push, etc.)

### ✅ Retry + Dead Letter Queue (DLQ)

* Failed messages are retried automatically
* After retries, messages are routed to a DLQ topic

### ✅ Rate Limiting

* Prevents users from spamming the system
* Fixed window rate limiting per user

### ✅ Fault Tolerance

* Ensures no message loss
* Handles failures gracefully

---

## 📂 Project Structure

```
com.example.notificationengine
├── controller/
├── model/
├── service/
├── strategy/
├── config/
```

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/GeekyHim/Distributed-Notification-Service-Project.git
cd notification-engine
```

---

### 2️⃣ Start Kafka using Docker

```bash
docker-compose up -d
```

---

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

---

## 📩 API Usage

### 🔹 Send Notification

**POST** `/api/v1/notifications/send`

#### Request Body:

```json
{
  "userId": "123",
  "message": "Hello from Kafka",
  "channel": "EMAIL",
  "recipient": "test@example.com"
}
```
**Note:** To simulate a failed respnse, use the word "fail" in message field.

---

## 🧪 Testing Scenarios

### ✅ Success Case

* Message processed and sent via selected strategy

### ❌ Failure Case

* Message retried 3 times
* Then moved to `notification-dlq` topic

---

## 📊 Key Concepts Demonstrated

* Event-driven architecture
* Producer-consumer pattern
* Backpressure handling
* Fault tolerance with DLQ
* Rate limiting
* Clean code principles

---

## 🚀 Future Improvements

* Redis-based distributed rate limiting
* Notification history with database
* API Gateway integration
* Monitoring & logging 

---

## 👨‍💻 Author

**Himanshu Gupta** <br>
Computer Science Engineering | Chandigarh University

---

## ⭐ If you found this useful, consider giving it a star!
