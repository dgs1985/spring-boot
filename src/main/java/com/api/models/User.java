package com.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false, length = 200)
    private String name;

    @Column(name="username", nullable = false, length = 200, unique = true)
    private String username;

    @Column(name="password", nullable = false, length = 200)
    private String password;    

    @Column(name="email", nullable = false, length = 300)
    private String email;    
}
