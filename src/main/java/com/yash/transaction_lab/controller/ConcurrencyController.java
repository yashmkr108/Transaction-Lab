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

    @PostMapping("/withdraw-pessimistic/{id}")
    public String withdrawWithPessimisticLock(
            @PathVariable Long id,
            @RequestParam BigDecimal amount
    ) {

        concurrencyService.withdrawWithPessimisticLock(id, amount);

        return "Withdrawal completed";
    }

    @PostMapping("/deadlock/aThenB")
    public String deadlockCreationAThenB(
            @RequestParam Long aId,
            @RequestParam Long bId
    ) {

        concurrencyService.lockAThenB(aId, bId);

        return "Withdrawal completed";
    }

    @PostMapping("/deadlock/bThenA")
    public String deadlockCreationBThenA(
            @RequestParam Long aId,
            @RequestParam Long bId
    ) {

        concurrencyService.lockBThenA(aId,bId);

        return "Withdrawal completed";
    }

}