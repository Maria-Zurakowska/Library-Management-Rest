package com.library.entity;

import com.library.status.UserStatus;
import com.library.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String streetAddress;

    private String city;

    private String zipCode;

    private String phoneNumber;

    private String profilePicture;

    private LocalDate registrationDate;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "userEntity")
    private Set<BorrowingEntity> borrowings;

    @OneToOne(mappedBy = "userEntity")
    private LoginEntity loginEntity;
}
