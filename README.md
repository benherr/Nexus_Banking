# 🏦 Nexus Bank Management System

A full-stack, secure, digital banking platform. Built with a robust Spring Boot backend and a modern React frontend, this application provides a complete digital banking lifecycle including self-service registration, real-time ledger tracking, and an administrative oversight portal.

## ✨ Features

- **Dynamic Auto-Generation:** Secure 4-digit PINs and unique Account Numbers are auto-generated and safely assigned upon registration.
- **Full Transaction Lifecycle:** Instantly process and record deposits, withdrawals, and inter-account peer-to-peer transfers.
- **Smart Global Ledger:** The system automatically tracks counterparty logic (`To: Account` vs `From: Account`) across a system-wide unified ledger.
- **Secure Admin Portal:** Database-backed authentication for bank administrators to view all global transactions and the entire customer directory.
- **Premium UI/UX:** A bespoke "Nordic Earth" design language utilizing sleek glassmorphism, fluid micro-animations, and a responsive component architecture.

## 📸 Screenshots

### Modern Registration & Success Flow
![Registration Success](assets/success_ui.png)
*Beautiful inline credential generation replacing traditional browser alerts.*

### Customer Dashboard
![Customer Dashboard](assets/dashboard.png)
*Real-time balance, user details, and smart transaction history.*

### Admin Oversight Portal
![Admin Portal](assets/admin.png)
*Secure administrative access to global customer and ledger data.*

## 🛠️ Technology Stack

**Frontend:**
- React (Vite)
- Vanilla CSS with Glassmorphism Principles
- Axios & Lucide-React Icons

**Backend:**
- Java 17 / Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL Database

## 🚀 Getting Started

### Prerequisites
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.

### ⚡ Quick Start (Docker)
The easiest way to run the entire system is using Docker Compose:

1. Clone this repository.
2. Run the following command in the project root:
   ```bash
   docker-compose up --build
   ```
3. Access the applications:
   - **Frontend:** [http://localhost](http://localhost)
   - **Backend API:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## ☁️ Cloud Deployment (Production)

Follow these steps to deploy the system live on the internet.

### 1. Database (TiDB Cloud)
- Create a free **Starter** instance on [TiDB Cloud](https://tidb.cloud/).
- Note your **Host**, **Port (4000)**, **Username**, and **Password**.
- In the TiDB SQL Editor, create the database:
  ```sql
  CREATE DATABASE bank_management_system_db;
  ```

### 2. Backend (Render.com)
- Deploy your code as a **Web Service** on Render.
- Set the **Root Directory** to `Bank_Management_System`.
- Add these **Environment Variables**:
  - `SPRING_DATASOURCE_URL`: `jdbc:mysql://<YOUR_HOST>:4000/bank_management_system_db?useSSL=true`
  - `SPRING_DATASOURCE_USERNAME`: `<YOUR_USERNAME>`
  - `SPRING_DATASOURCE_PASSWORD`: `<YOUR_PASSWORD>`

### 3. Frontend (Vercel.com)
- Deploy the repository to Vercel.
- Set the **Root Directory** to `frontend`.
- Add these **Environment Variables**:
  - `VITE_API_URL`: (Your live Render backend URL ending in `/api/customers`)
  - `VITE_ADMIN_API_URL`: (Your live Render backend URL ending in `/api/admin`)

---

## 🔒 Security Note
This project uses auto-generated PINs and secure database-backed authentication. For production use, ensure all traffic is served over HTTPS and secret keys are stored in environment variables (already configured in this repository).
