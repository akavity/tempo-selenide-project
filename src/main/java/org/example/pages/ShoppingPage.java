package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage {
    private final SelenideElement submitButton =
            $(By.xpath("//div[@class='popupContent']//button"));
    private final SelenideElement resultButton = $(By.id("getResultPickup"));
    private final SelenideElement priceBasketTopField =
            $(By.xpath("//div[@class='basketOuter']//span[@class='bs-price']//span[@class='price_byn']"));
    private final SelenideElement priceCartField =
            $(By.xpath("//div[@id='basket_sum_all']//span[@class='price_byn']"));
    private final ElementsCollection productNamesFields = $$(By.xpath("//h3//span"));

    public SelenideElement getGoodNameField(String goodName) {
        return $(By.xpath("//h3//span[contains(text(), '" + goodName + "')]"));
    }

    public SelenideElement getPizzaTypeButton(String pizzaType) {
        return $(By.xpath("//div[@class='pizzaType']//label[@class='" + pizzaType + "']"));
    }

    public SelenideElement getProductButton(String productName) {
        return $(By.xpath("//span[contains(text(), '" + productName + "')]/../following-sibling::div//button"));
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getResultButton() {
        return resultButton;
    }

    public SelenideElement getPriceBasketTopField() {
        return priceBasketTopField;
    }

    public SelenideElement getPriceCartField() {
        return priceCartField;
    }

    public ElementsCollection getProductNames() {
        return productNamesFields;
    }
}
