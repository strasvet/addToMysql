package com.company.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//@ToString
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    private String city;

    private String country;

    @Column(unique = true)
    private String address;

    @Override
    public String toString() {
        return "UserDetails: " +
                "id=" + id +
                ", user= " + user +
                ", city= '" + city + '\'' +
                ", country= '" + country + '\'' +
                ", address= '" + address + '\'' + ' ';
    }
}
