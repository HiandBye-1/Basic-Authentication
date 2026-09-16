# Basic Authentication System

A Java-based authentication project focused on implementing user registration, login, password security, and database-backed credential management.

> **Status:** In Progress

## Features

* User registration and login
* MySQL database integration
* Password hashing with BCrypt
* Authentication and credential validation
* Environment-based database configuration
* Docker containerization
* Docker Compose configuration for the application and database

## Technologies

* **Java**
* **MySQL**
* **JDBC**
* **BCrypt**
* **Docker**
* **Docker Compose**

## Project Structure

```text
Basic-Authentication/
├── src/              # Java source code
├── lib/              # Project dependencies
├── bin/              # Compiled Java classes
├── DB.sql            # Database schema
├── Dockerfile        # Application container configuration
├── compose.yaml      # Application and MySQL services
├── .env.example      # Example environment configuration
├── .dockerignore
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

Make sure you have:

* Java
* Docker Desktop
* Docker Compose

### 1. Clone the repository

```bash
git clone https://github.com/HiandBye-1/Basic-Authentication.git
cd Basic-Authentication
```

### 2. Configure environment variables

Copy `.env.example` to `.env`:

```bash
cp .env.example .env
```

On Windows PowerShell:

```powershell
Copy-Item .env.example .env
```

Open `.env` and enter your own MySQL credentials.

**Do not commit `.env` to the repository.**

### 3. Start the application

Build and start the containers:

```bash
docker compose up -d --build
```

Check the running containers:

```bash
docker compose ps
```

### 4. Stop the application

```bash
docker compose down
```

To also remove the database volume:

```bash
docker compose down -v
```

> Removing the volume deletes the MySQL data stored in that Docker volume.

## Database

The project uses MySQL for storing authentication-related data.

The database schema is provided in:

```text
DB.sql
```

Database credentials are configured through environment variables rather than being stored directly in the Java source code.

## Security

This project is being developed with basic authentication security practices in mind.

Current security-related work includes:

* BCrypt password hashing
* Keeping database credentials outside the source code
* Using environment variables for configuration
* Avoiding plaintext password storage

> This project is intended for learning and development purposes and should not be considered production-ready authentication software.

## Current Development

The project is currently **in progress**. Planned development includes improving authentication workflows, expanding validation, strengthening security practices, and adding additional testing.

## What I Am Learning

Through this project, I am practicing:

* Java authentication logic
* Password hashing and verification
* JDBC and MySQL
* Environment-based configuration
* Docker and Docker Compose
* Database design
* Debugging and testing
* Basic application security
