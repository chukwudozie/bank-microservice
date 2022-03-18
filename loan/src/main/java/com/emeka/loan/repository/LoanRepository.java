package com.emeka.loan.repository;

import com.emeka.loan.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    List<Loan> findByCustomerIdOrderByStartDateDesc(int customerId);

}
