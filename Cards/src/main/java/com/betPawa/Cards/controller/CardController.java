package com.betPawa.Cards.controller;

import com.betPawa.Cards.config.CardServiceConfig;
import com.betPawa.Cards.model.Card;
import com.betPawa.Cards.model.Customer;
import com.betPawa.Cards.model.Properties;
import com.betPawa.Cards.repository.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardServiceConfig config;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer){
        List<Card> customerCards = cardRepository.findByCustomerId(customer.getCustomerId());

        if(customerCards !=  null){
            System.out.println(customerCards.size()+ " cards for customer");
            return customerCards;
        }else{
            System.out.println(customerCards.size()+ " cards for customer");
            return null;
        }

    }
    @GetMapping("/cards/properties")
    public Properties getPropertyDetails() throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return new Properties(config.getMsg(), config.getBuildVersion(),
                config.getMailDetails(),config.getActiveBranches());

    }
}
