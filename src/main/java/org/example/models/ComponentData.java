package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentData {
    String orderType;
    String productName;
    double productPrice;
    String firstComponent;
    double firstComponentPrice;
    String secondComponent;
    double secondComponentPrice;
    String thirdComponent;
    double thirdComponentPrice;
}
