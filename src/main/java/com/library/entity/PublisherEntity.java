package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publishers")
@Getter
@Setter
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    private String website;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String country;

    @OneToMany(mappedBy = "publisherEntity")
    private Set<BookEntity> books;

    @OneToMany(mappedBy = "publisherEntity")
    private Set<AuthorEntity> authors;

    @OneToMany(mappedBy = "publisherEntity")
    private Set<EBookEntity> ebooks;
}
