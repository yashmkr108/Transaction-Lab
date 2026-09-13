
# Transaction Lab

A Spring Boot project for learning and practicing database transactions, concurrency control, and JPA transaction management with Spring Data JPA, Hibernate, and PostgreSQL.

The project uses a simple account transfer system to explore how transactions behave in real backend applications through hands-on experiments.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

## Current Features

### Account & Transfer Operations

- Create accounts
- Retrieve accounts
- Transfer money between accounts
- Account balance validation
- Custom exceptions for account and balance errors

### Transaction Management

- `@Transactional`
- Transaction boundaries
- Transaction rollback behavior
- Runtime vs checked exception rollback
- `rollbackFor`
- `noRollbackFor`
- Transaction propagation
  - `REQUIRED`
  - `REQUIRES_NEW`
  - `MANDATORY`
  - `SUPPORTS`
  - `NOT_SUPPORTED`
  - `NEVER`
  - `NESTED`
- Read-only transactions using `readOnly = true`

### Transaction Isolation

- `READ_UNCOMMITTED`
- `READ_COMMITTED`
- `REPEATABLE_READ`
- `SERIALIZABLE`
- `Non-repeatable read experiment`
- `Phantom read experiment`

### JPA & Hibernate

- JPA Persistence Context
- Entity lifecycle
- Managed vs detached entities
- Hibernate dirty checking
- Flush vs commit
- Understanding when `save()` is and isn't necessary

### Concurrency Control

- Lost update problem
- Optimistic locking using `@Version`
- Optimistic locking conflict handling
- Pessimistic locking using `PESSIMISTIC_WRITE`
- Concurrent withdrawal experiments
- Deadlocks
- Deadlock prevention using consistent lock ordering
- Lock duration and transaction design

### Spring Transaction Internals

- Spring transaction proxies
- Self-invocation
- Why `@Transactional` can be bypassed during self-invocation
- Using separate Spring beans for independent transactional boundaries

## Project Structure

```text
src/main/java/com/yash/transaction_lab/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
│   ├── request/
│   └── response/
├── mapper/
└── exception/
````

## Key Concepts Practiced

The project is designed around practical experiments rather than only theoretical examples.

Some of the core experiments include:

```text
Transaction
    ↓
ACID
    ↓
@Transactional
    ↓
Rollback Rules
    ↓
Transaction Boundaries
    ↓
Propagation
    ↓
Isolation
    ↓
Concurrency
    ↓
Optimistic Locking
    ↓
Pessimistic Locking
    ↓
Deadlocks
    ↓
Persistence Context
    ↓
Dirty Checking
    ↓
Spring Proxy
    ↓
Production Transaction Design
```

## Purpose

This project is part of my backend engineering learning process.

The goal is not simply to learn how to use `@Transactional`, but to understand the engineering decisions behind transaction management.

The project focuses on:

* Why transactions are required
* How Spring manages transactions
* How transaction boundaries should be designed
* How rollback rules work
* How transaction propagation works
* How isolation affects concurrent reads
* How concurrent transactions can cause lost updates
* How optimistic and pessimistic locking solve concurrency problems
* How deadlocks occur and how to reduce them
* How JPA Persistence Context and dirty checking work
* The difference between flush and commit
* How Spring proxies affect transactional behavior
* How transaction duration affects locking and contention
* How to design transactions for production systems