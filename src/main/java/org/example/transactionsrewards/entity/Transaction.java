package org.example.transactionsrewards.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * The type Transaction.
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private int customerId;
    @NonNull
    @Column(columnDefinition = "DATE")
    private LocalDate transactionDate;
    @NonNull
    private double amount;
}
