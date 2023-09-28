package com.afrid.loan.service;

import com.afrid.loan.dto.LoanDTO;
import com.afrid.loan.dto.LoanRequestDTO;

public interface ILoanService {

    LoanDTO getLoanDetails (String mobileNumber);

    boolean createLoan (LoanRequestDTO loanRequestDTO);
}
