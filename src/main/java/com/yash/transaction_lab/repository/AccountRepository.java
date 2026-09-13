package com.yash.transaction_lab.repository;

import com.yash.transaction_lab.entity.Account;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByBalanceGreaterThan(BigDecimal balance);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("Select a from Account a where a.id = :id")
    Optional<Account> findByIdForUpdate(@Param("id") Long id);

}
