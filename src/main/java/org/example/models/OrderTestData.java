package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTestData {
    double firstProductPrice;
    double secondProductPrice;
    double thirdProductPrice;
    double fourthProductPrice;
    String firstProductName;
    String secondProductName;
    String thirdProductName;
    String fourthProductName;
    String orderType;
}
