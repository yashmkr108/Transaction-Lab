package com.yash.transaction_lab.dto;

import java.math.BigDecimal;

public class AccountResponse {

    private Long id;

    private String ownerName;

    private BigDecimal balance;

    public AccountResponse() {

    }

    public AccountResponse(Long id,String ownerName, BigDecimal balance) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
