package com.afrid.loan.dto;

import lombok.Data;

@Data
public class LoanDTO  {

    private String mobileNumber;
    private long loanNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outStandingAmount;
}
