package com.afrid.loan.mapper;

import com.afrid.loan.dto.LoanDTO;
import com.afrid.loan.dto.LoanRequestDTO;
import com.afrid.loan.entity.Loan;

public class LoanMapper {

    public static LoanDTO LoanToLoanDTOMapper(Loan loan, LoanDTO loanDTO) {
        loanDTO.setLoanNumber(loan.getLoanNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setTotalLoan(loan.getTotalLoan());
        loanDTO.setAmountPaid(loan.getAmountPaid());
        loanDTO.setOutStandingAmount(loan.getOutStandingAmount());
        loanDTO.setMobileNumber(loan.getMobileNumber());
        return loanDTO;
    }

    // default fields are mapped
    public static Loan LoanRequestDTOToLoanMapper(LoanRequestDTO loanRequestDTO, Loan loan) {
        loan.setLoanType(loanRequestDTO.getLoanType());
        loan.setTotalLoan(loanRequestDTO.getTotalLoan());
        loan.setMobileNumber(loanRequestDTO.getMobileNumber());
        return loan;
    }
}
