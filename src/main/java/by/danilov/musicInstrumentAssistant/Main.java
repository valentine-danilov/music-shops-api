package by.danilov.musicInstrumentAssistant;

import by.danilov.musicInstrumentAssistant.domain.entities.Country;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"name\":\"Belarus\"}";
        Country country = objectMapper.readValue(json, Country.class);
        System.out.println(country);
    }
}
