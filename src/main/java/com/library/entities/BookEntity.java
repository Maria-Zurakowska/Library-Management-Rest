package com.library.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private int id;
    private String title;
    private String authorName;
    private String authorLastName;
    private String publishingHouse;
    private int publicationYear;
    private int languageId;
    private int pagesNumber;
    private String isbn;
}
