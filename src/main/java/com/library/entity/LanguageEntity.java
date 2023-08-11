package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@Getter
@Setter
public class LanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private BookEntity bookEntity;

    @OneToMany(mappedBy = "languageEntity")
    private Set<EBookEntity> ebooks;
}
