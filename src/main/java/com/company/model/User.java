package com.company.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String username;

    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(50) default 'NONE'")
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
}
