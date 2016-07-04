package com.muran.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.swagger.util.Json;
import org.apache.log4j.Logger;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Provider
@Produces({MediaType.APPLICATION_JSON})
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {

    private final static Logger log = Logger.getLogger(JacksonJsonProvider.class);
    private static ObjectMapper commonMapper = Json.mapper();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    static {
        commonMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new DateSerializer());
        module.addDeserializer(Date.class, new DateDerializer());
        commonMapper.registerModule(module);
    }

    public JacksonJsonProvider() {
        super.setMapper(commonMapper);
        configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }


    public static class DateSerializer extends JsonSerializer<Date> {

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeString(sdf.format(date));
        }
    }

    public static class DateDerializer extends JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            try {
                return sdf.parse(jsonParser.getText());
            } catch (ParseException e) {
                log.error("解析Date错误" + jsonParser.getText());
                e.printStackTrace();
            }
            return null;
        }
    }

}