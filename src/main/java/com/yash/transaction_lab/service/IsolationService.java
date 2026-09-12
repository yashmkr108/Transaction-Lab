package com.yash.transaction_lab.service;

import com.yash.transaction_lab.entity.Account;
import com.yash.transaction_lab.exception.AccountNotFoundException;
import com.yash.transaction_lab.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IsolationService {

    private final AccountRepository accountRepository;

    public IsolationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ) //prevent dirty reads   //By default it is on Read_commited
    public void readAccountTwice(Long accountId) {

        Account account1 = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);

        System.out.println("First Read " + account1.getBalance());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Account account2 = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);

        System.out.println("Second Read " + account2.getBalance());
    }

    @Transactional
    public void updateAccountBalance(Long accountId, BigDecimal newBalance) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(AccountNotFoundException::new);

        System.out.println("T2 updating balance...");

        account.setBalance(newBalance);

        System.out.println("T2 new balance: " + account.getBalance());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void findHighBalanceAccounts() {

        BigDecimal threshold = new BigDecimal("9999");

        List<Account> firstRead =
                accountRepository.findByBalanceGreaterThan(threshold);

        System.out.println("First read count: " + firstRead.size());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<Account> secondRead =
                accountRepository.findByBalanceGreaterThan(threshold);

        System.out.println("Second read count: " + secondRead.size());
    }
}
