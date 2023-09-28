package com.afrid.loan.controller;

import com.afrid.loan.dto.LoanDTO;
import com.afrid.loan.dto.LoanRequestDTO;
import com.afrid.loan.dto.ResponseDTO;
import com.afrid.loan.loanConstants.LoanConstants;
import com.afrid.loan.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {

    ILoanService iLoanService;

    @GetMapping("/loanDetails")
    public ResponseEntity<LoanDTO> getLoanDetails (@RequestParam String mobileNumber) {
        LoanDTO loanDetails = iLoanService.getLoanDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(loanDetails);
    }

    @PostMapping("/createLoan")
    public ResponseEntity<ResponseDTO> createLoan (@RequestBody LoanRequestDTO loanRequestDTO) {
        boolean loanCreated = iLoanService.createLoan(loanRequestDTO);
        if(loanCreated) {
          return   ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDTO(LoanConstants.STATUS_200,LoanConstants.MESSAGE_200));
        }else {
           return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR
            ).body(new ResponseDTO(LoanConstants.STATUS_201,LoanConstants.MESSAGE_201));
        }
    }
}
