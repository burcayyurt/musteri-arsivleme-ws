package com.example.ws;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ByteArrayDeSerializer extends JsonDeserializer<byte[]> {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(ByteArrayDeSerializer.class);

    @Override
    public byte[] deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException {
        String data = jsonparser.getText();
        try {
            return org.apache.commons.codec.binary.Base64.decodeBase64(data.getBytes()); // here is the major change
        } catch (Exception e) {
            logger.error("ByteArrayDeSerializer error : " + e);
            throw new IOException(e);
        }
    }
}
