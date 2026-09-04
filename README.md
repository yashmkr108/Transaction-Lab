# Transaction Lab

A Spring Boot project for learning and practicing database transactions with Spring Data JPA and PostgreSQL.

The project focuses on understanding how transactions work in a real application through a simple account transfer system.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

## Current Features

- Create accounts
- Retrieve accounts
- Transfer money between accounts
- Account balance validation
- Custom exceptions for account and balance errors
- Transaction management using `@Transactional`
- Rollback behavior for different types of exceptions
- `rollbackFor` and `noRollbackFor`
- Hibernate dirty checking

## Project Structure

```text
controller/
service/
repository/
entity/
dto/
mapper/
exception/
````

## Purpose

This project is part of my backend engineering learning process.

The goal is not just to use `@Transactional`, but to understand:

* Why transactions are required
* How Spring manages transactions
* How Hibernate persistence context and dirty checking work
* When transactions commit or roll back
* How exception types affect rollback behavior
* How transaction boundaries should be designed

The project will be expanded as more transaction and concurrency concepts are covered.
