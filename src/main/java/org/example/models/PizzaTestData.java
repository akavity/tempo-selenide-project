package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaTestData {
    double bavariaPizzaPrice;
    double temptingPizzaPrice;
    double sicilyPizzaPrice;
    double vesuviusPizzaPrice;
    String bavariaPizzaName;
    String temptingPizzaName;
    String sicilyPizzaName;
    String vesuviusPizzaName;
    String orderType;
}
