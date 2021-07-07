package com.example.ws.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class MusteriDTO  implements Serializable {

    private static final long serialVersionUID = 1871409791412322308L;

    @JsonProperty("musteri_AdiSoyadi")
    private String musteriAdi;

    @JsonProperty("musteri_email")
    private String musteriEmail;

    @JsonProperty("musteri_id")
    private Long musteriId;

}
