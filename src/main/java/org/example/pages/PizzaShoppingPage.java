package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PizzaShoppingPage {
    private final SelenideElement submitButton =
            $(By.xpath("//*[@id='order_pizza_popup']//button[contains(text(), 'Заказ')]"));
    private final SelenideElement resultButton = $(By.id("getResultPickup"));
    private final SelenideElement priceBasketTopField =
            $(By.xpath("//div[@class='basketOuter']//span[@class='bs-price']//span[@class='price_byn']"));
    private final SelenideElement priceCartField =
            $(By.xpath("//div[@id='basket_sum_all']//span[@class='price_byn']"));
    private final SelenideElement emptyBasketField =
            $(By.xpath("//div[@class='bs-empty-col']"));
    private final SelenideElement removeOrderButton =
            $(By.xpath("//a[@title='Удалить из заказа']"));
    private final SelenideElement openCloseButton =
            $(By.xpath("//div[@class='basket_placeholder']//div[@class='bs-toggler openClose']"));
    private final ElementsCollection pizzaNamesFields = $$(By.xpath("//h3//span"));

    public SelenideElement getPizzaTypeButton(String pizzaType) {
        return $(By.xpath("//div[@class='pizzaType']//label[@class='" + pizzaType + "']"));
    }

    public SelenideElement getPizzaButton(String pizzaName) {
        return $(By.xpath("//span[contains(text(), '" + pizzaName + "')]/../following-sibling::div//button"));
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

    public SelenideElement getEmptyBasketField() {
        return emptyBasketField;
    }

    public SelenideElement getRemoveOrderButton() {
        return removeOrderButton;
    }

    public SelenideElement getOpenCloseButton() {
        return openCloseButton;
    }

    public ElementsCollection getPizzaNames() {
        return pizzaNamesFields;
    }
}
