package com.muran.util;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


public class BooleanSerializer extends JsonSerializer<Boolean> {

        @Override
        public void serialize(Boolean value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
                jgen.writeString(value.booleanValue()?"男":"女");
        }
}