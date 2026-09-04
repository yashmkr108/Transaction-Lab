package com.yash.transaction_lab.service;

import com.yash.transaction_lab.dto.AccountResponse;
import com.yash.transaction_lab.dto.CreateAccountRequest;
import com.yash.transaction_lab.entity.Account;
import com.yash.transaction_lab.exception.AccountNotFoundException;
import com.yash.transaction_lab.mapper.AccountMapper;
import com.yash.transaction_lab.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountResponse createAccount(CreateAccountRequest request) {
        Account account = accountMapper.toEntity(request);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toResponse(savedAccount);
    }

    public List<AccountResponse> findAll() {
        return accountRepository.findAll().stream().map(accountMapper::toResponse).toList();
    }

    public AccountResponse findById(Long id) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));

        return accountMapper.toResponse(existingAccount);
    }
}
