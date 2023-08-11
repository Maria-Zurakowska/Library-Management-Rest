package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books_genres")
@Getter
@Setter
public class BookGenreEntity {

    @EmbeddedId
    private PrimaryKey primaryKey;

    @Embeddable
    public static class PrimaryKey implements Serializable {

        @Column(name = "book_id")
        private int bookId;

        @Column(name = "genre_id")
        private int genreId;
    }
}
