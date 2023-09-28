package com.afrid.loan.dto;

import lombok.Data;

@Data
public class LoanRequestDTO {

    private String mobileNumber; // user
    private String loanType; // user
    private int totalLoan; // user
}
