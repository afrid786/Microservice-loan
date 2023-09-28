package com.afrid.loan.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LoanUpdateDTO {

    @Positive(message = "Loan amount should be more than 0 and can't be negative value")
    private int amountPaid;
}
