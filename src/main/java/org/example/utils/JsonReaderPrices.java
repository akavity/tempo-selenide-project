package org.example.utils;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.example.models.PizzaPrice;
import org.example.models.UserData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReaderPrices {
    @DataProvider(name = "pizzaPrice")
    public Object[][] getPizzaPrice() throws IOException {
        String filePath = "src/test/resources/test-data/pizzaPrice.json";
        List<PizzaPrice> pizzaPriceList = readTestDataFromJson(filePath);

        Object[][] data = new Object[pizzaPriceList.size()][1];
        for (int i = 0; i < pizzaPriceList.size(); i++) {
            data[i][0] = pizzaPriceList.get(i);
        }

        return data;
    }

    private List<PizzaPrice> readTestDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<PizzaPrice>>() {
            });
        }
    }
}
