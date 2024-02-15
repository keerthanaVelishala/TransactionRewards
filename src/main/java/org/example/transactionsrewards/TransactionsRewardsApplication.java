package org.example.transactionsrewards;

import jakarta.annotation.PostConstruct;
import org.example.transactionsrewards.RewardsRepo.RewardsRepository;
import org.example.transactionsrewards.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * The type Transactions rewards application.
 */
@SpringBootApplication
public class TransactionsRewardsApplication {

    /**
     * The Rewards repository.
     */
    @Autowired
    RewardsRepository rewardsRepository;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(TransactionsRewardsApplication.class, args);
    }

    /**
     * Init.
     */
    @PostConstruct
    public void init(){
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, LocalDate.of(2024, 1, 3), 70.00),
                new Transaction(1, LocalDate.of(2024, 1, 6), 45.00),
                new Transaction(1, LocalDate.of(2024, 1, 9), 80.00),
                new Transaction(1, LocalDate.of(2024, 1, 12), 150.00),
                new Transaction(1, LocalDate.of(2024, 1, 18), 230.00),
                new Transaction(1, LocalDate.of(2024, 1, 24), 50.00),
                new Transaction(1, LocalDate.of(2024, 1, 30), 120.00),
                new Transaction(1, LocalDate.of(2024, 2, 2), 110.00),
                new Transaction(1, LocalDate.of(2024, 2, 14), 90.00),
                new Transaction(1, LocalDate.of(2024, 2, 20), 40.00),
                new Transaction(1, LocalDate.of(2024, 2, 28), 160.00),
                new Transaction(1, LocalDate.of(2024, 3, 3), 95.00),
                new Transaction(1, LocalDate.of(2024, 3, 9), 60.00),
                new Transaction(1, LocalDate.of(2024, 3, 15), 200.00),
                new Transaction(1, LocalDate.of(2024, 3, 22), 130.00),
                new Transaction(2, LocalDate.of(2024, 1, 4), 40.00),
                new Transaction(2, LocalDate.of(2024, 1, 11), 65.00),
                new Transaction(2, LocalDate.of(2024, 1, 16), 75.00),
                new Transaction(2, LocalDate.of(2024, 1, 21), 150.00),
                new Transaction(2, LocalDate.of(2024, 1, 27), 190.00),
                new Transaction(2, LocalDate.of(2024, 2, 3), 60.00),
                new Transaction(2, LocalDate.of(2024, 2, 17), 300.00),
                new Transaction(2, LocalDate.of(2024, 2, 23), 130.00),
                new Transaction(2, LocalDate.of(2024, 3, 2), 85.00),
                new Transaction(2, LocalDate.of(2024, 3, 11), 50.00),
                new Transaction(2, LocalDate.of(2024, 3, 18), 170.00),
                new Transaction(2, LocalDate.of(2024, 3, 25), 110.00),
                new Transaction(3, LocalDate.of(2024, 1, 5), 55.00),
                new Transaction(3, LocalDate.of(2024, 1, 13), 95.00),
                new Transaction(3, LocalDate.of(2024, 1, 19), 120.00),
                new Transaction(3, LocalDate.of(2024, 1, 28), 140.00),
                new Transaction(3, LocalDate.of(2024, 2, 7), 160.00),
                new Transaction(3, LocalDate.of(2024, 2, 16), 70.00),
                new Transaction(3, LocalDate.of(2024, 2, 24), 180.00),
                new Transaction(3, LocalDate.of(2024, 3, 24), 180.00));


        rewardsRepository.saveAll(transactions);

    }

}
