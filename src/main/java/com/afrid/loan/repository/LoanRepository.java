package com.afrid.loan.repository;

import com.afrid.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    Optional<Loan> findByMobileNumber (String mobileNumber);
}
