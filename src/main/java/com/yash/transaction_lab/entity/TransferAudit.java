package com.yash.transaction_lab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer_audits")
public class TransferAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public TransferAudit() {
    }

    public TransferAudit(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
