package com.yash.transaction_lab.controller;

import com.yash.transaction_lab.service.IsolationService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/isolation")
public class IsolationController {

    private final IsolationService isolationService;

    public IsolationController(IsolationService isolationService){
        this.isolationService = isolationService;
    }

    @GetMapping("/read/{id}")
    public String readAccountTwice(@PathVariable Long id) {

        isolationService.readAccountTwice(id);

        return "Experiment completed";
    }

    @PostMapping("/update/{id}")
    public String updateBalance(
            @PathVariable Long id,
            @RequestParam BigDecimal balance
    ) {
        isolationService.updateAccountBalance(id, balance);

        return "Balance updated";
    }

    @GetMapping("/phantom")
    public String phantomRead() {

        isolationService.findHighBalanceAccounts();

        return "Phantom read experiment completed";
    }
}
