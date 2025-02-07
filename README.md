# Java Ticket Booking System

This is a simple **Ticket Booking System** written in Java. It uses **JDBC (Java Database Connectivity)** to interact with a MySQL database and allows users to perform basic operations such as adding, modifying, deleting, and finding ticket booking records.

## Features

- **User Authentication**: Requires a username and password to access the system.
- **Add Ticket**: Allows users to enter and store ticket booking details in the database.
- **Modify Ticket**: Updates user phone numbers based on their ticket ID.
- **Delete Ticket**: Removes booking records from the database based on the "From" location.
- **Find Ticket**: Retrieves and displays ticket details based on ticket cost.

## Technologies Used

- Java
- MySQL Database
- JDBC (Java Database Connectivity)

## Setup Instructions

1. **Clone the Repository**
   ```sh
   git clone https://github.com/YOUR_USERNAME/Java-Ticket-Booking.git
   cd Java-Ticket-Booking

   
Set Up the MySQL Database

Create a MySQL database named project.

Create a table userdata with the following structure:

CREATE TABLE userdata (
    T_ID INT PRIMARY KEY,
    B_NAME VARCHAR(50),
    T_FROM VARCHAR(50),
    T_TO VARCHAR(50),
    T_DATE VARCHAR(20),
    PHONE_NO BIGINT,
    ID_PROOF VARCHAR(50),
    ID_PROOF_NO VARCHAR(50),
    TICKET_COST INT
);
