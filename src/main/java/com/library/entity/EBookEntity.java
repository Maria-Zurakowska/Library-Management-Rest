package com.library.entity;

import com.library.BookFormat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ebooks")
@Getter
@Setter
public class EBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity languageEntity;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisherEntity;

    @Enumerated(EnumType.STRING)
    private BookFormat format;
}
