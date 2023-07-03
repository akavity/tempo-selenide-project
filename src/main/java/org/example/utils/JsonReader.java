package org.example.utils;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.example.models.PizzaTestData;
import org.example.models.PizzaTypeData;
import org.example.models.UserData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    @DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        String filePath = "src/test/resources/test-data/userData.json";
        List<UserData> userDataList = readTestDataFromJson(filePath);

        Object[][] data = new Object[userDataList.size()][1];
        for (int i = 0; i < userDataList.size(); i++) {
            data[i][0] = userDataList.get(i);
        }

        return data;
    }

    private List<UserData> readTestDataFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return mapper.readValue(fis, new TypeReference<>() {
            });
        }
    }

    @DataProvider(name = "pizzaTestData")
    public Object[][] getPizzaData() throws IOException {
        String filePath = "src/test/resources/test-data/pizzaTestData.json";
        List<PizzaTestData> pizzaTestDataList = readPizzaDataFromJson(filePath);

        Object[][] data = new Object[pizzaTestDataList.size()][1];
        for (int i = 0; i < pizzaTestDataList.size(); i++) {
            data[i][0] = pizzaTestDataList.get(i);
        }

        return data;
    }

    private List<PizzaTestData> readPizzaDataFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return mapper.readValue(fis, new TypeReference<>() {
            });
        }
    }

    @DataProvider(name = "pizzaTypeData")
    public Object[][] getPizzaTypeData() throws IOException {
        String filePath = "src/test/resources/test-data/pizzaTypeData.json";
        List<PizzaTypeData> pizzaTypeDataList = readPizzaTypeDataFromJson(filePath);

        Object[][] data = new Object[pizzaTypeDataList.size()][1];
        for (int i = 0; i < pizzaTypeDataList.size(); i++) {
            data[i][0] = pizzaTypeDataList.get(i);
        }

        return data;
    }

    private List<PizzaTypeData> readPizzaTypeDataFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return mapper.readValue(fis, new TypeReference<>() {
            });
        }
    }
}
