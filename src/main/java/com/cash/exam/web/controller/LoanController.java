package com.cash.exam.web.controller;

import com.cash.exam.domain.Loan;
import com.cash.exam.domain.service.LoanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("")
    @ApiOperation("Get all loans by user id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Loan not found"),
    })
    public ResponseEntity<List<Loan>> getLoanByUserId(@ApiParam(value = "Optional - The id of the user")
                                                          @RequestParam(required = false) String user_id) {
        if (user_id != null) {
            return loanService.getLoansByUserId(Integer.parseInt(user_id))
                    .map(loan -> new ResponseEntity<>(loan, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(loanService.getLoans(), HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    @ApiOperation("Get all loans")
    @ApiResponse(code = 200, message = "OK")
    @ResponseBody
    public ResponseEntity<List<Loan>> getLoans () {
        return new ResponseEntity<>(loanService.getLoans(), HttpStatus.OK);
    }
}