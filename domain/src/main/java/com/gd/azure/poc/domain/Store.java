package com.gd.azure.poc.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Store(String displayName, StoreType storeType, String phone, Date openDate, String url, boolean active,
        Address address) {
        this.displayName = displayName;
        this.storeType = storeType;
        this.phone = phone;
        this.openDate = openDate;
        this.url = url;
        this.active = active;
        this.address = address;
    }

    private String displayName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "STORE_TYPE_PK", nullable = false, updatable = false, referencedColumnName = "STORE_TYPE_PK")
    private StoreType storeType;
    private String phone;
    private Date openDate;
    private String url;
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_PK", nullable = false, updatable = false, referencedColumnName = "ADDRESS_PK")
    private Address address;
}
