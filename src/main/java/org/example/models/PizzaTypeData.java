package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaTypeData {
    String orderType;
    String pizzaType;
    List<String> pizzaNames;
}
