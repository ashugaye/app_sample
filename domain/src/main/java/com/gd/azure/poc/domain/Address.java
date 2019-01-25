package com.gd.azure.poc.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ADDRESS_PK"))
public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String zipCode;

}
