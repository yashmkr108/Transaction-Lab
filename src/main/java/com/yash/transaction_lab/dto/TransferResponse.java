package com.yash.transaction_lab.dto;

import java.math.BigDecimal;

public class TransferResponse {

    private String message;
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;

    public TransferResponse(String message, Long fromAccountId, Long toAccountId, BigDecimal amount) {
        this.message = message;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}