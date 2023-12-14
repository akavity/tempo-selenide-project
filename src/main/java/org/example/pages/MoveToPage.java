package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MoveToPage {
    private final SelenideElement registrationButton =
            $(By.xpath("//a[contains(text(), 'Регистрация')]"));
//    private final SelenideElement pizzaButton =
//            $(By.xpath("//li[@class='other']//a[contains(@href, 'menu/pizza')]"));
    //div[@class='mainmenu']//span[contains(text(), '" + typeOrder + "')]
    private final SelenideElement basketButton =
            $(By.xpath("//div[@class='basket']//div[@class='bs-price-col']"));

    public SelenideElement getTOrderTypeButton(String typeOrder) {
        return $(By.xpath("//div[@class='mainmenu']//span[contains(text(), '" + typeOrder + "')]"));
    }

    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }

//    public SelenideElement getPizzaButton() {
//        return pizzaButton;
//    }

    public SelenideElement getBasketButton() {
        return basketButton;
    }
}
