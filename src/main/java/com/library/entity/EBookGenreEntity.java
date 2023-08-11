package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ebooks_genres")
@Getter
@Setter
public class EBookGenreEntity {

    @EmbeddedId
    private PrimaryKey primaryKey;

    @Embeddable
    public static class PrimaryKey implements Serializable {

        @Column(name = "ebook_id")
        private int ebookId;

        @Column(name = "genre_id")
        private int genreId;
    }
}
