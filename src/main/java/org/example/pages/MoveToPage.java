package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MoveToPage {
    private final SelenideElement registrationButton =
            $(By.xpath("//a[contains(text(), 'Регистрация')]"));

    private final SelenideElement pizzaButton =
            $(By.xpath("//li[@class=\"other\"]//a[ contains(@href, 'menu/pizza')]"));

    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }

    public SelenideElement getPizzaButton() {
        return pizzaButton;
    }
}
