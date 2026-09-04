package com.yash.transaction_lab.controller;

import com.yash.transaction_lab.dto.TransferRequest;
import com.yash.transaction_lab.dto.TransferResponse;
import com.yash.transaction_lab.exception.TransferFailedException;
import com.yash.transaction_lab.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public TransferResponse transfer(
            @Valid @RequestBody TransferRequest request
    ) throws TransferFailedException {
        return transferService.transfer(request);
    }
}
