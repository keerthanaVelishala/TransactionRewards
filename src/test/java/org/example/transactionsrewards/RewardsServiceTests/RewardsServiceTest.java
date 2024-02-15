package org.example.transactionsrewards.RewardsServiceTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.transactionsrewards.RewardsService.RewardsService;
import org.example.transactionsrewards.RewardsRepo.RewardsRepository;
import org.example.transactionsrewards.entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * The type Rewards service test.
 */
@ExtendWith(MockitoExtension.class)
public class RewardsServiceTest {

    @Mock
    private RewardsRepository rewardsRepository;

    @InjectMocks
    private RewardsService rewardsService;

    private Transaction transactionBelow50, transactionBetween50And100, transactionAbove100;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        transactionBelow50 = new Transaction(1, LocalDate.now(),49.99);
        transactionBetween50And100 = new Transaction(2 , LocalDate.now(),75.00);
        transactionAbove100 = new Transaction(3, LocalDate.now(),150.00);
    }

    /**
     * Calculate rewards below 50.
     */
    @Test
    public void calculateRewardsBelow50() {
        List<Transaction> transactions = Collections.singletonList(transactionBelow50);
        int rewards = rewardsService.calculateRewards(transactions);
        assertEquals(0, rewards);
    }

    /**
     * Calculate rewards between 50 and 100.
     */
    @Test
    public void calculateRewardsBetween50And100() {
        List<Transaction> transactions = Collections.singletonList(transactionBetween50And100);
        int rewards = rewardsService.calculateRewards(transactions);
        assertEquals(25, rewards);
    }

    /**
     * Calculate rewards above 100.
     */
    @Test
    public void calculateRewardsAbove100() {
        List<Transaction> transactions = Collections.singletonList(transactionAbove100);
        int rewards = rewardsService.calculateRewards(transactions);
        assertEquals(150, rewards);
    }

    /**
     * Find by id should return transactions for customer id.
     */
    @Test
    public void findByIdShouldReturnTransactionsForCustomerId() {
        when(rewardsRepository.findByCustomerId(1)).thenReturn(Arrays.asList(transactionBelow50, transactionBetween50And100, transactionAbove100));
        List<Transaction> transactions = rewardsService.findById(1);
        assertEquals(3, transactions.size());
        verify(rewardsRepository).findByCustomerId(1);
    }

    /**
     * Find all should return all transactions.
     */
    @Test
    public void findAllShouldReturnAllTransactions() {
        when(rewardsRepository.findAll()).thenReturn(Arrays.asList(transactionBelow50, transactionBetween50And100, transactionAbove100));
        List<Transaction> transactions = rewardsService.findAll();
        assertEquals(3, transactions.size());
        verify(rewardsRepository).findAll();
    }


    /**
     * Calculate total rewards for customer should return correct totals.
     */
    @Test
    public void calculateTotalRewardsForCustomerShouldReturnCorrectTotals() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, LocalDate.now(),49.99),
                new Transaction(2 , LocalDate.now(),75.00),
                new Transaction(3,   LocalDate.now(),150.00)
        );

        //when(rewardsRepository.findAll()).thenReturn(transactions);


        Map<Integer, Integer> rewards = rewardsService.calculateTotalRewardsForCustomer(transactions);


        assertNotNull(rewards);
        assertEquals(3, rewards.size());
        assertTrue(rewards.containsKey(1));
        assertEquals(0, rewards.get(1));
    }

    /**
     * Find total points by customer and month should return correct structure and values.
     */
    @Test
    public void findTotalPointsByCustomerAndMonthShouldReturnCorrectStructureAndValues() {

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, LocalDate.of(2022, Month.JANUARY, 1),49.9),
                new Transaction(2,LocalDate.of(2022, Month.FEBRUARY, 1),75.00),
                new Transaction(3, LocalDate.of(2022, Month.FEBRUARY, 15),150.00)
        );

        //when(rewardsRepository.findAll()).thenReturn(transactions);


        Map<Integer, Map<Integer, Integer>> rewardsByCustomerAndMonth = rewardsService.findTotalPointsByCustomerAndMonth(transactions);


        assertNotNull(rewardsByCustomerAndMonth);
        assertEquals(3, rewardsByCustomerAndMonth.size());
        assertTrue(rewardsByCustomerAndMonth.containsKey(1));
        Map<Integer, Integer> rewardsByMonth = rewardsByCustomerAndMonth.get(1);
        System.out.println(rewardsByMonth);
        assertEquals(0, rewardsByMonth.get(1));
    }

}
