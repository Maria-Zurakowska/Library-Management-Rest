package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Getter
@Setter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisherEntity;

    @OneToMany(mappedBy = "bookEntity")
    private Set<LanguageEntity> languages;

    @OneToMany(mappedBy = "bookEntity")
    private Set<CopyEntity> copies;

    @OneToMany(mappedBy = "bookEntity")
    private Set<EBookEntity> ebooks;

    private String isbn;

    private int pagesNumber;

    private int publicationYear;

    private String edition;

    private int quantityAvailable;

    private String description;

    private String coverImageUrl;

    private boolean isAvailable;

    private double rating;

    private LocalDate createdAt;
}
