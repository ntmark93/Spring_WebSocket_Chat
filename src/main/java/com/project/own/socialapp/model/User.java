package com.project.own.socialapp.model;

import com.project.own.socialapp.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;

    @JoinColumn(name = "email")
    @Column(nullable = false, unique = true)
    private String email;

    @JoinColumn(name = "password")
    @Column(nullable = false)
    private String password;

    @JoinColumn(name = "first_name")
    @Column(nullable = false)
    private String firstName;

    @JoinColumn(name = "last_name")
    @Column(nullable = false)
    private String lastName;

    @JoinColumn(name = "birth_date")
    @Column(nullable = false)
    private LocalDate birthDate;

    @JoinColumn(name = "reg_date")
    @Column(nullable = false)
    private LocalDate registrationDate;

    @JoinColumn(name = "gender")
    @Column(nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private Set<Friendship> friendsList;

    public User(String firstName) {
        this.firstName = firstName;
    }
}
