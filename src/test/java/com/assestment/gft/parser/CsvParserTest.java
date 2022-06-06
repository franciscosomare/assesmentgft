package com.assestment.gft.parser;

import com.assestment.gft.entity.NaceEntity;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvParserTest {

    @Test
    public void shouldParseAllCSVRecordsCorrectly() throws IOException {
        // given
        File file = new File("src/test/resources/NACE_REV2_20220605_232521.csv");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file",
                file.getName(), "text/plain", IOUtils.toByteArray(input));


        // when
        List<NaceEntity> naceEntities = CsvParser.csvToNaceEntityList(multipartFile.getInputStream());

        // then
        assertEquals(naceEntities.size(), 996);
    }

    @Test
    public void shouldParseCSVtoNaceEntityCorrectly() throws IOException {
        // given
        File file = new File("src/test/resources/NACE_REV2_20220605_232521.csv");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file",
                file.getName(), "text/plain", IOUtils.toByteArray(input));


        // when
        List<NaceEntity> naceEntities = CsvParser.csvToNaceEntityList(multipartFile.getInputStream());

        // then
        assertEquals(naceEntities.get(0).getOrder(), "398481");
        assertEquals(naceEntities.get(0).getLevel(), "1");
        assertEquals(naceEntities.get(0).getCode(), "A");
        assertEquals(naceEntities.get(0).getParent(), "");
        assertEquals(naceEntities.get(0).getDescription(), "AGRICULTURE, FORESTRY AND FISHING");
        assertEquals(naceEntities.get(0).getItemIncludes(), "This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.");
        assertEquals(naceEntities.get(0).getItemAlsoIncludes(), "");
        assertEquals(naceEntities.get(0).getRulings(), "");
        assertEquals(naceEntities.get(0).getItemExcludes(), "");
        assertEquals(naceEntities.get(0).getIsicReference(), "A");
    }

}