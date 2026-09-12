package com.yash.transaction_lab.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("Account not found");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
