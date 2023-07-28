package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "borrowings")
@Getter
@Setter
public class BorrowingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "copy_id")
    private CopyEntity copyEntity;

    private LocalDate borrowedDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private double fineAmount;

    private boolean isReturned;

    private LocalDate createdAt;
}
