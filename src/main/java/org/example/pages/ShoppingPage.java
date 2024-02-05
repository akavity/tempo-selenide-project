package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage {
    private final SelenideElement submitButton =
            $(By.xpath("//div[@class='popupContent']//button"));
    private final SelenideElement modifySubmitButton = $(By.xpath("//button[@id='modifyOrderBtn']"));
    private final SelenideElement resultButton = $(By.id("getResultPickup"));
    private final SelenideElement priceBasketTopField =
            $(By.xpath("//div[@class='basketOuter']//span[@class='bs-price']//span[@class='price_byn']"));
    private final SelenideElement priceCartField =
            $(By.xpath("//div[@id='basket_sum_all']//span[@class='price_byn']"));
    private final ElementsCollection productNamesFields = $$(By.xpath("//h3//span"));
    private final SelenideElement emptyBasketField =
            $(By.xpath("// div[contains(@id,'basket')]//span[contains(text(),'пуста')]"));
    private final SelenideElement removeOrderButton = $(By.xpath("//a[@title='Удалить из заказа']"));
    private final SelenideElement openCloseButton =
            $(By.xpath("//div[@class='basket_placeholder']//div[@class='bs-toggler openClose']"));

    public final SelenideElement addComponentButton(String component) {
        return $(By.xpath("//div[@class='components']//label[contains(text(),'" + component + "')]" +
                "/../..//div[contains(@class,'inc')]"));
    }

    public final SelenideElement removeComponentButton(String component) {
        return $(By.xpath("//div[@class='components']//label[contains(text(),'" + component + "')]" +
                "/../..//div[contains(@class,'dec')]"));
    }

    public SelenideElement getProductNameField(String productName) {
        return $(By.xpath("//h3//span[contains(text(), '" + productName + "')]"));
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

    public SelenideElement getModifySubmitButton() {
        return modifySubmitButton;
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

    public SelenideElement getEmptyBasketField() {
        return emptyBasketField;
    }

    public SelenideElement getRemoveOrderButton() {
        return removeOrderButton;
    }

    public SelenideElement getOpenCloseButton() {
        return openCloseButton;
    }
}
