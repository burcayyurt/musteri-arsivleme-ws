package com.example.ws;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ByteArraySerializer extends StdSerializer<byte[]> {

    private static final long serialVersionUID = 1L;

    public ByteArraySerializer() {
        super(byte[].class);
    }

    @Override
    public boolean isEmpty(SerializerProvider prov, byte[] value) {
        return value.length == 0;
    }

    @Override
    public void serialize(byte[] value, JsonGenerator g, SerializerProvider provider)
            throws IOException {
        g.writeBinary(provider.getConfig().getBase64Variant(),
                value, 0, value.length);
    }
}

