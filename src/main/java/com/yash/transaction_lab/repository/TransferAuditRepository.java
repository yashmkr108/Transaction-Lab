package com.yash.transaction_lab.repository;

import com.yash.transaction_lab.entity.TransferAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferAuditRepository extends JpaRepository<TransferAudit,Long> {
}
