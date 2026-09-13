package com.yash.transaction_lab.service;

import com.yash.transaction_lab.entity.Account;
import com.yash.transaction_lab.exception.AccountNotFoundException;
import com.yash.transaction_lab.exception.InsufficientBalanceException;
import com.yash.transaction_lab.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static java.lang.Thread.sleep;

@Service
public class ConcurrencyService {

    private final AccountRepository accountRepository;

    public ConcurrencyService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void withdraw(Long accountId, BigDecimal amount) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(AccountNotFoundException::new);

        System.out.println(
                Thread.currentThread().getName()
                        + " read balance: "
                        + account.getBalance()
        );

        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        BigDecimal newBalance =
                account.getBalance().subtract(amount);

        account.setBalance(newBalance);

        System.out.println(
                Thread.currentThread().getName()
                        + " writing balance: "
                        + newBalance
        );
    }

    @Transactional
    public void withdrawWithPessimisticLock(
            Long accountId,
            BigDecimal amount
    ) {

        Account account = accountRepository.findByIdForUpdate(accountId)
                .orElseThrow(AccountNotFoundException::new);

        System.out.println(
                Thread.currentThread().getName()
                        + " acquired lock. Balance: "
                        + account.getBalance()
        );

        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        account.setBalance(
                account.getBalance().subtract(amount)
        );

        System.out.println(
                Thread.currentThread().getName()
                        + " new balance: "
                        + account.getBalance()
        );
    }

    @Transactional
    public void lockAThenB(Long aId, Long bId) {

        Account a = accountRepository.findByIdForUpdate(aId)
                .orElseThrow();

        System.out.println(
                Thread.currentThread().getName()
                        + " locked A"
        );

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Account b = accountRepository.findByIdForUpdate(bId)
                .orElseThrow();

        System.out.println(
                Thread.currentThread().getName()
                        + " locked B"
        );
    }

    @Transactional
    public void lockBThenA(Long aId, Long bId) {

        Account b = accountRepository.findByIdForUpdate(bId)
                .orElseThrow();

        System.out.println(
                Thread.currentThread().getName()
                        + " locked B"
        );

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Account a = accountRepository.findByIdForUpdate(aId)
                .orElseThrow();

        System.out.println(
                Thread.currentThread().getName()
                        + " locked A"
        );
    }
}
