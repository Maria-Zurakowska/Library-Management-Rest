package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "logins")
@Getter
@Setter
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private UserEntity userEntity;

    private String username;

    private String password;

    private LocalDate lastLogin;
}
