package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PizzaShoppingPage {
    private final SelenideElement bavariaPizzaButton =
            $(By.xpath("//span[contains(text(), 'Баварская')]/../following-sibling::div//button"));
    private final SelenideElement temptingPizzaButton =
            $(By.xpath("//span[contains(text(), 'Аппетитная')]/../following-sibling::div//button"));
    private final SelenideElement sicilyPizzaButton =
            $(By.xpath("//span[contains(text(), 'Сицилийская')]/../following-sibling::div//button"));
    private final SelenideElement submitButton =
            $(By.xpath("//*[@id='order_pizza_popup']//button[contains(text(), 'Заказ')]"));
    private final SelenideElement priceField =
            $(By.xpath("//div[@class='basketOuter']//span[@class='bs-price']//span[@class='price_byn']"));
    private final SelenideElement emptyBasketField =
            $(By.xpath("//div[@class='bs-empty-col']"));
    private final SelenideElement removeOrderButton =
            $(By.xpath("//a[@title='Удалить из заказа']"));
    private final SelenideElement openCloseButton =
            $(By.xpath("//div[@class='basket_placeholder']//div[@class='bs-toggler openClose']"));

    public SelenideElement getBavarianPizzaButton() {
        return bavariaPizzaButton;
    }

    public SelenideElement getTemptingPizzaButton() {
        return temptingPizzaButton;
    }

    public SelenideElement getSicilyPizzaButton() {
        return sicilyPizzaButton;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getPriceField() {
        return priceField;
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
