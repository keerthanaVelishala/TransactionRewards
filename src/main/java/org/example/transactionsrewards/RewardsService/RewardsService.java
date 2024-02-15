package org.example.transactionsrewards.RewardsService;


import org.example.transactionsrewards.RewardsRepo.RewardsRepository;
import org.example.transactionsrewards.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Rewards service.
 */
@Service
public class RewardsService {

    @Autowired
    private RewardsRepository rewardsRepo;


    /**
     * Find by id list.
     *
     * @param id the id
     * @return the list
     */
    public List<Transaction> findById(int id) {
        return rewardsRepo.findByCustomerId(id);
    }

    /**
     * Calculate rewards int.
     *
     * @param transactions the transactions
     * @return the int
     */
    public int calculateRewards(List<Transaction> transactions){
        int totalRewards=0;
        for(Transaction tr : transactions){
            if(tr.getAmount()>100){
                totalRewards+= (int) (50+((tr.getAmount()-100)*2));
            }
            else if(tr.getAmount()>50 && tr.getAmount()<100){
                totalRewards+= (int) (tr.getAmount()-50);
            }
        }
        return totalRewards;
    }


    /**
     * Calculate total rewards for customer map.
     *
     * @param transactions the transactions
     * @return the map
     */
    public Map<Integer, Integer> calculateTotalRewardsForCustomer(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCustomerId,
                        Collectors.summingInt(transaction -> calculatePointsForTransaction(transaction.getAmount()))
                ));
    }

    /**
     * Find total points by customer and month map.
     *
     * @param transactions the transactions
     * @return the map
     */
    public Map<Integer, Map<Integer, Integer>> findTotalPointsByCustomerAndMonth(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCustomerId,
                        Collectors.groupingBy(
                                transaction -> transaction.getTransactionDate().getMonthValue(),
                                Collectors.summingInt(transaction -> calculatePointsForTransaction(transaction.getAmount()))
                        )
                ));
    }

    private int calculatePointsForTransaction(double amount) {
        if (amount <= 50) {
            return 0;
        } else if (amount <= 100) {
            return (int) amount - 50;
        } else {
            return 50 + 2 * ((int) amount - 100);
        }
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Transaction> findAll() {
        return rewardsRepo.findAll();
    }
}
