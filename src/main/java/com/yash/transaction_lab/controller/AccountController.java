package com.yash.transaction_lab.controller;

import com.yash.transaction_lab.dto.AccountResponse;
import com.yash.transaction_lab.dto.CreateAccountRequest;
import com.yash.transaction_lab.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse createAccount(@Valid @RequestBody CreateAccountRequest request){
        return accountService.createAccount(request);
    }

    @GetMapping
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable("id") Long id){
        return accountService.findById(id);
    }
}
