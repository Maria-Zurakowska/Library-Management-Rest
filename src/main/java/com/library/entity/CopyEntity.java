package com.library.entity;

import com.library.status.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "copies")
@Getter
@Setter
public class CopyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @OneToMany(mappedBy = "copyEntity")
    private Set<BorrowingEntity> borrowings;

    private String location;

    private String condition;

    private LocalDate addedDate;
}
