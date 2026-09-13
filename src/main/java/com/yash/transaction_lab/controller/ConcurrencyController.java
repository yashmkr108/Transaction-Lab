package com.yash.transaction_lab.controller;

import com.yash.transaction_lab.service.ConcurrencyService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/concurrency")
public class ConcurrencyController {

    private final ConcurrencyService concurrencyService;

    public ConcurrencyController(ConcurrencyService concurrencyService) {
        this.concurrencyService = concurrencyService;
    }

    @PostMapping("/withdraw/{id}")
    public String withdraw(
            @PathVariable Long id,
            @RequestParam BigDecimal amount
    ) {
        concurrencyService.withdraw(id, amount);

        return "Withdrawal completed";
    }
}