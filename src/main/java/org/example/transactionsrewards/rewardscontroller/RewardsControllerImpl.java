package org.example.transactionsrewards.rewardscontroller;

import org.example.transactionsrewards.RewardsService.RewardsService;
import org.example.transactionsrewards.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * The type Rewards controller.
 */
@Controller
public class RewardsControllerImpl implements RewardsController {


    @Autowired
     private  RewardsService rewardsService;

    @Override
    public ResponseEntity<?> totalRewards() {
        List<Transaction> transactions = rewardsService.findAll();
        Map<Integer, Map<Integer,Integer>> result = rewardsService.findTotalPointsByCustomerAndMonth(transactions);
        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<?> calculateTotalRewardsForCustomer() {
        List<Transaction> transactions = rewardsService.findAll();
        Map<Integer, Integer> result = rewardsService.calculateTotalRewardsForCustomer(transactions);
        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<?> rewardsById(Integer id) {
        List<Transaction> transactions = rewardsService.findById(id);
        int totalRewards=rewardsService.calculateRewards(transactions);
        return new ResponseEntity<>(totalRewards, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<?> rewardsByIdPerMonth(Integer id, Integer month) {
        List<Transaction> transactions = rewardsService.findById(id);

        List<Transaction> monthTransactions= transactions.stream()
                                                        .filter(transaction->{
                                                                LocalDate date = transaction.getTransactionDate();
                                                                return date.getMonthValue()==month;
                                                                }).toList();
        int totalRewards= rewardsService.calculateRewards(monthTransactions);
        return new ResponseEntity<>(totalRewards, HttpStatusCode.valueOf(200));
    }
}
