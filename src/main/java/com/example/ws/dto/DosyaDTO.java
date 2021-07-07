package com.example.ws.dto;

import com.example.ws.ByteArrayDeSerializer;
import com.example.ws.ByteArraySerializer;
import com.example.ws.entity.Musteri;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Lob;
import java.io.Serializable;

@Data
public class DosyaDTO implements Serializable {

    private static final long serialVersionUID = 1871409791412322308L;

    @JsonProperty("dosya")
    @JsonSerialize(using = ByteArraySerializer.class)
    @JsonDeserialize(using = ByteArrayDeSerializer.class)
    private byte[] dosya;

    @JsonProperty("dosyaAdi")
    private String dosyaAdi;

    @JsonProperty("dosya_id")
    private Long dosyaId;

    @JsonProperty("musteri_id")
    private Long musteriId;

}