package edu.iu.se.primeservice.repository;

import org.springframework.stereotype.Repository;
import edu.iu.se.primeservice.model.Customer;

import org.springframework.data.repository.CrudRepository;;



@Repository
public interface AuthenticationDBRepository extends CrudRepository<Customer, String>

{
    Customer findByUsername(String username);
}