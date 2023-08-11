package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books_authors")
@Getter
@Setter
public class BookAuthorEntity {

    @EmbeddedId
    private PrimaryKey primaryKey;

    @Embeddable
    public static class PrimaryKey implements Serializable {
        @Column(name = "book_id")
        private int bookId;

        @Column(name = "author_id")
        private int authorId;
    }
}
