package com.gd.azure.poc.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "STORE_TYPE_PK"))
public class StoreType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public StoreType(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    private String name;
    private String displayName;

}
