package com.yash.transaction_lab.repository;

import com.yash.transaction_lab.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;


public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByBalanceGreaterThan(BigDecimal balance);
}
