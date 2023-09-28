package com.afrid.loan.service.impl;

import com.afrid.loan.dto.LoanDTO;
import com.afrid.loan.dto.LoanRequestDTO;
import com.afrid.loan.dto.LoanUpdateDTO;
import com.afrid.loan.entity.Loan;
import com.afrid.loan.exception.ResourceAlreadyExistsException;
import com.afrid.loan.exception.ResourceNotFoundException;
import com.afrid.loan.mapper.LoanMapper;
import com.afrid.loan.repository.LoanRepository;
import com.afrid.loan.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {

    LoanRepository loanRepository;

    public LoanDTO getLoanDetails(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Doesn't exist with mobile number: " + mobileNumber));

        return LoanMapper.LoanToLoanDTOMapper(loan, new LoanDTO());
    }

    public boolean createLoan(LoanRequestDTO loanRequestDTO) {
        Optional<Loan> isLoanExists = loanRepository.findByMobileNumber(loanRequestDTO.getMobileNumber());
        if (isLoanExists.isPresent()) {
            throw new ResourceAlreadyExistsException("Loan with mobile number " + loanRequestDTO.getMobileNumber() + " already exists");
        }
        Loan loan = LoanMapper.LoanRequestDTOToLoanMapper(loanRequestDTO, new Loan());
        loanRepository.save(deriveLoanFields(loan));
        return true;
    }

    private Loan deriveLoanFields(Loan loan) {
        // setting derived values
        long loanNumber = 100000000L + new Random().nextInt(900000);
        loan.setLoanNumber(loanNumber);
        loan.setOutStandingAmount(loan.getTotalLoan() - loan.getAmountPaid());
        loan.setCreatedAt(LocalDateTime.now());
        loan.setCreatedBy("LOAN_MS");
        return loan;
    }

    public boolean updateLoanDetails(String mobileNumber, LoanUpdateDTO loanUpdateDTO) {
        Loan loanInfo = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan doesn't exists with this mobile number: " + mobileNumber));

        int currentAmountPaid = loanInfo.getAmountPaid();
        int latestTotalAmountPaid = currentAmountPaid + loanUpdateDTO.getAmountPaid();
        loanInfo.setAmountPaid(latestTotalAmountPaid);
        loanInfo.setOutStandingAmount(loanInfo.getTotalLoan() - latestTotalAmountPaid);
        loanRepository.save(loanInfo);
        return true;
    }

    public boolean deleteLoanDetails(String mobileNumber) {
        Loan loanInfo = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan doesn't exists with this mobile number: " + mobileNumber));

        loanRepository.deleteById(loanInfo.getLoanId());
        return true;
    }
}
