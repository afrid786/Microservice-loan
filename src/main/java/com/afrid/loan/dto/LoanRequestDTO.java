package com.afrid.loan.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LoanRequestDTO {

    @NotEmpty(message = "mobile number can't be empty")
    @Pattern(regexp = "($|[0-9]{10})",message = "Mobile  number is not valid")
    private String mobileNumber; // user

    @NotEmpty(message = "Loan Type should be mentioned")
    private String loanType; // user

    @Positive(message = "Total required loan amount required")
    private int totalLoan; // user
}
