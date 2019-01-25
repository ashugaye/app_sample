package com.gd.azure.poc.domain;

//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Document
public class Store implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


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
