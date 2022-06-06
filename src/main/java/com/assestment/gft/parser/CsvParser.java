package com.assestment.gft.parser;

import com.assestment.gft.entity.NaceEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<NaceEntity> csvToNaceEntityList(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<NaceEntity> naceEntities = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                NaceEntity nace = NaceEntity.builder()
                        .order(csvRecord.get(0))
                        .level(csvRecord.get(1))
                        .code(csvRecord.get(2))
                        .parent(csvRecord.get(3))
                        .description(csvRecord.get(4))
                        .itemIncludes(csvRecord.get(5))
                        .itemAlsoIncludes(csvRecord.get(6))
                        .rulings(csvRecord.get(7))
                        .itemExcludes(csvRecord.get(8))
                        .isicReference(csvRecord.get(9))
                        .build();
                naceEntities.add(nace);
            }

            return naceEntities;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
