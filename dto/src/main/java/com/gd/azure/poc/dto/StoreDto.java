package com.gd.azure.poc.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto implements Serializable {
    private String id;
    private String displayName;
    private String storeType;
    private String phone;
    private Date openDate;
    private String url;
    private boolean active;
    private String address;
}
