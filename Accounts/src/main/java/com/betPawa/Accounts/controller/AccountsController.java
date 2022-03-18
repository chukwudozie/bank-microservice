package com.betPawa.Accounts.controller;

import com.betPawa.Accounts.config.AccountServiceConfig;
import com.betPawa.Accounts.model.Account;
import com.betPawa.Accounts.model.Customer;
import com.betPawa.Accounts.model.Properties;
import com.betPawa.Accounts.repository.AccountRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountServiceConfig config;

    @PostMapping("myAccount")// post mapping used here as "get" would expose the id in the url
    public Account getAccountDetails (@RequestBody Customer customer){

        Account account  = accountRepository.findByCustomerId(customer.getCustomerId());
        if(account != null){
            System.out.println(account.getAccountNumber());
            return account;
        } else {
            System.out.println("Account doesnt exist");
            return new Account();
        }

    }

    /**
     *This API returns all the properties of account based on the current environment.
     * The Properties class helps to use the Jackson API to convert the objects of the config class to Json
     */
    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(config.getMsg(), config.getBuildVersion()
                ,config.getMailDetails(),config.getActiveBranches());
        return ow.writeValueAsString(properties);

    }
}
