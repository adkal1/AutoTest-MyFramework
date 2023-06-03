package Datas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataUtil {
    private final File fileConfig = new File("src/main/resources/configData.json");
    private final File fileTestData = new File("src/main/resources/testData.json");
    private final File fileTestTableData = new File("src/main/resources/testDataTables.json");
    private final ObjectMapper objectMapper = new ObjectMapper();


    public ConfigData readConfig() {
        try {
            return objectMapper.readValue(fileConfig, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TestData readTestData() {
        try {
            return objectMapper.readValue(fileTestData, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TestTableData> readTestTableData() {
        try {
            return objectMapper.readValue(fileTestTableData, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}