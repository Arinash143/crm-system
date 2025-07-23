# 📄 CRM Application
A simple Customer Relationship Management (CRM) application built with Spring Boot, MySQL, and a lightweight HTML + JavaScript frontend.
This project demonstrates full-stack development with a backend-first focus and a minimal frontend to interact with the APIs.

## 🔷 Features
- Register leads (name, email, phone)
- Convert a lead into a customer
- Search customers by email
- Prevent duplicate emails
- Frontend form for lead registration, conversion, and search
- Data persistence with MySQL
- REST APIs tested with Postman

## 🔷 Tech Stack
Backend: 
- Java 17
- Spring Boot
- Spring Data JPA

Frontend: 
- HTML
- CSS
- JavaScript

Database: 
- MySQL

Build & Tools: 
- Maven
- Git
- Postman

## 🔷 Setup Instructions

1️⃣ Clone the Repository : 

git clone <https://github.com/arinash143/crm-system.git>
cd crm-application

2️⃣ Build the Project : 

mvn clean install

3️⃣ MySQL Setup : 

✅ Create the database:
CREATE DATABASE crmdb;

✅ Update your MySQL credentials in : 
src/main/resources/application.properties
- spring.datasource.username=your_mysql_username
- spring.datasource.password=your_mysql_password

4️⃣ Run the Application : 

mvn spring-boot: run

📌 Application runs on :
http://localhost:8080

## 🔷 API Endpoints

[Method] |  [Endpoint]            |             	[Description]
- POST	 | /api/leads	                     ( Register a new lead )
- POST	 | /api/crm/convert?leadId=1 	     ( Convert a lead to customer )
- GET	   | /api/customers/search?email=.. .(	Search customer by email )
- GET	   | /api/leads	                     ( Get all leads )
- GET    | /api/customers	                 ( Get all customers )

## 🔷 Frontend
A lightweight HTML + JavaScript page is included at:

src/main/resources/static/crm.html

## Features:
- Lead registration form
- Convert lead to customer form
- Search customer by email form
- Uses fetch API to call backend endpoints.

## To access it:

- Run the app.
- Open in browser:
  
http://localhost:8080/search.html

## 👤 Author  
**Arinash C**
