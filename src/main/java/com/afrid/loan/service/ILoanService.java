package com.afrid.loan.service;

import com.afrid.loan.dto.LoanDTO;
import com.afrid.loan.dto.LoanRequestDTO;
import com.afrid.loan.dto.LoanUpdateDTO;

public interface ILoanService {

    LoanDTO getLoanDetails (String mobileNumber);

    boolean createLoan (LoanRequestDTO loanRequestDTO);

    boolean updateLoanDetails (String mobileNumber, LoanUpdateDTO loanUpdateDTO);

    boolean deleteLoanDetails(String mobileNumber);
}
