package com.betPawa.Accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "created_date")
    private LocalDate createdDate;


}
