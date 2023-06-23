package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    String email;
    String password;
    String userData;
    String phone;
    String age;
    String occupation;
    String street;
    String house;
    String apartment;
    String porch;
    String floor;
}
