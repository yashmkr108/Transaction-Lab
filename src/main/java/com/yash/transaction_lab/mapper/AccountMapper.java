package com.yash.transaction_lab.mapper;

import com.yash.transaction_lab.dto.AccountResponse;
import com.yash.transaction_lab.dto.CreateAccountRequest;
import com.yash.transaction_lab.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toEntity(CreateAccountRequest request) {
        return new Account(request.getOwnerName(), request.getBalance());
    }

    public AccountResponse toResponse(Account account) {
        return new AccountResponse(account.getId(), account.getOwnerName(), account.getBalance());
    }

}
