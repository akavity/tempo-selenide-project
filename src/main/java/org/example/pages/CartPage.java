package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement deleteProductButton =
            $(By.xpath("//div[@id='basket_expand']//a[contains(@class,'del')]"));
    private final SelenideElement priceOrder =
            $(By.xpath("//div[@id='basket_sum_all']//span[@class='price_byn']"));

    private final SelenideElement totalAmount =
            $(By.xpath("//div[@class='checkout']//td[contains(@class,'price s_o')]/span"));

    public SelenideElement getProductNameField(String productName) {
        return $(By.xpath("//div[@id='basket_expand']//a[contains(text(),'" + productName + "')]"));
    }

    public SelenideElement getRemoveOrderButton() {
        return deleteProductButton;
    }

    public SelenideElement getPriceOrder() {
        return priceOrder;
    }

    public SelenideElement getTotalAmount() {
        return totalAmount;
    }
}
