package com.yash.transaction_lab.service;

import com.yash.transaction_lab.dto.TransferRequest;
import com.yash.transaction_lab.dto.TransferResponse;
import com.yash.transaction_lab.entity.Account;
import com.yash.transaction_lab.exception.AccountNotFoundException;
import com.yash.transaction_lab.exception.InsufficientBalanceException;
import com.yash.transaction_lab.exception.SameAccountException;
import com.yash.transaction_lab.exception.TransferFailedException;
import com.yash.transaction_lab.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = TransferFailedException.class)
    public TransferResponse transfer(TransferRequest request) throws TransferFailedException {
        Account fromAccount = accountRepository.findById(request.getFromAccountId())
                .orElseThrow(() -> new AccountNotFoundException("Source account not found"));
        Account toAccount = accountRepository.findById(request.getToAccountId())
                .orElseThrow(() -> new AccountNotFoundException("Destination account not found"));

        if(request.getFromAccountId().equals(request.getToAccountId())){
            throw new SameAccountException("The account should not be same");
        }
        if (fromAccount.getBalance().compareTo(request.getAmount()) <= 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(request.getAmount()));
        throw new TransferFailedException("Transfer failed");
//        toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));
//        return new TransferResponse(
//                "Transfer completed successfully",
//                fromAccount.getId(),
//                toAccount.getId(),
//                request.getAmount()
//        );
    }
}
