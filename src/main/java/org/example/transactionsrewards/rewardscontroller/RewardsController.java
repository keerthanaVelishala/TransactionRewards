package org.example.transactionsrewards.rewardscontroller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The interface Rewards controller.
 */
@RestController
@RequestMapping("/calculaterewards")
public interface RewardsController {

    /**
     * Total rewards response entity.
     *
     * @return the response entity
     */
    @GetMapping("/rewards/summary/monthly")
    ResponseEntity<?> totalRewards();

    /**
     * Calculate total rewards for customer response entity.
     *
     * @return the response entity
     */
    @GetMapping("/rewards/summary")
    ResponseEntity<?> calculateTotalRewardsForCustomer();

    /**
     * Rewards by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/rewards/customers/{id}")
    ResponseEntity<?> rewardsById(@PathVariable Integer id);

    /**
     * Rewards by id per month response entity.
     *
     * @param id    the id
     * @param month the month
     * @return the response entity
     */
    @GetMapping("/rewards/customers/{id}/monthly")
    ResponseEntity<?> rewardsByIdPerMonth(@PathVariable Integer id, @RequestParam Integer month);

}
