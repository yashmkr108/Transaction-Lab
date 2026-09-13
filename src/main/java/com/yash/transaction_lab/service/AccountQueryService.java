package com.yash.transaction_lab.service;

import com.yash.transaction_lab.entity.Account;
import com.yash.transaction_lab.exception.AccountNotFoundException;
import com.yash.transaction_lab.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountQueryService {

    private final AccountRepository accountRepository;

    public AccountQueryService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public Account getAccount(Long id) {

        return accountRepository.findById(id)
                .orElseThrow(AccountNotFoundException::new);
    }

}
