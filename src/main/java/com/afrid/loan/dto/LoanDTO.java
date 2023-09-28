package com.afrid.loan.dto;

import com.afrid.loan.entity.BaseEntity;
import lombok.Data;

@Data
public class LoanDTO  {

    private String mobileNumber; // user
    private long loanNumber; // dervice
    private String loanType; // user
    private int totalLoan; // user
    private int amountPaid; // derive
    private int outStandingAmount; // derive
}
