package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement deleteProductButton =
            $(By.xpath("//div[@id='basket_expand']//a[contains(@class,'del')]"));
    private final SelenideElement priceOrder = $(By.xpath("//div[@id='basket_sum_all']//span[@class='price_byn']"));

    public SelenideElement getProductNameField(String name) {
        return $(By.xpath("//div[contains(@id,'basket_expand')]//div[contains(text(),'" + name + "')]"));
    }

    public SelenideElement getRemoveOrderButton() {
        return deleteProductButton;
    }

    public SelenideElement getPriceOrder() {
        return priceOrder;
    }
}
