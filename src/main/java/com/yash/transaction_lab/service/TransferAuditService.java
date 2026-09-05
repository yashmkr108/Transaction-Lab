package com.yash.transaction_lab.service;

import com.yash.transaction_lab.entity.TransferAudit;
import com.yash.transaction_lab.repository.TransferAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferAuditService {

    private final TransferAuditRepository auditRepository;

    public TransferAuditService(TransferAuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void record() {
        auditRepository.save(
                new TransferAudit("Transfer attempted")
        );
    }

}
