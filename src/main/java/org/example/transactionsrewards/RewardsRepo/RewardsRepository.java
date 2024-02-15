package org.example.transactionsrewards.RewardsRepo;

import org.example.transactionsrewards.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Rewards repository.
 */
@Repository
public interface RewardsRepository extends JpaRepository<Transaction,Integer> {

    /**
     * Find by customer id list.
     *
     * @param customer_Id the customer id
     * @return the list
     */
    List<Transaction> findByCustomerId(Integer customer_Id);


    List<Transaction> findAll();
}
