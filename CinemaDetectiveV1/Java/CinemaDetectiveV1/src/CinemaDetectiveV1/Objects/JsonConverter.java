package CinemaDetectiveV1.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReaderHeaderAware;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonConverter {


public String convertCsvToJson(File file){



    try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(file))) {

        List<Map<String, String>> rows = new ArrayList<>();
        Map<String, String> row;

        while ((row = reader.readMap()) != null) {
            rows.add(row);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rows);

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}



}
