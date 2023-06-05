package com.example.roleBased.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
    joinColumns = {
            @JoinColumn(name = "username")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "role_name")
            }
    )
    private Set<Role> roles = new HashSet<>();

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Cart cart;

}
