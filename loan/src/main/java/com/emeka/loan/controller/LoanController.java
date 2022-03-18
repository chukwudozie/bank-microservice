package com.emeka.loan.controller;

import com.emeka.loan.config.LoanServiceConfig;
import com.emeka.loan.model.Customer;
import com.emeka.loan.model.Loan;
import com.emeka.loan.model.Properties;
import com.emeka.loan.repository.LoanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanServiceConfig config;

    @PostMapping("/myLoan")
    public List<Loan> getLoanDetails(@RequestBody Customer customer){
        List<Loan> customerLoans = loanRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());
        if(customerLoans != null){
            System.out.println(customerLoans.size() + " Loans present" );
            return customerLoans;
        } else{
            System.out.println(0 + " Loans present" );
            return null;
        }
    }

    @GetMapping("/loan/properties")
    private String getPropertyDetails() throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(config.getMsg(),config.getBuildVersion()
                ,config.getMailDetails(),config.getActiveBranches());
        return ow.writeValueAsString(properties);

    }

}
