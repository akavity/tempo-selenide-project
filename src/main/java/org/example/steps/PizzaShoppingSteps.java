package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.PizzaShoppingPage;

@Log4j2
public class PizzaShoppingSteps {
    PizzaShoppingPage pizzaShoppingPage = new PizzaShoppingPage();

    @Step("Enter pizza button")
    public void enterPizzaButton(String pizzaName) {
        log.info("Enter " + pizzaName + " pizza");
        pizzaShoppingPage.getPizzaButton(pizzaName).click();
    }

    @Step("Remove pizza from cart")
    public void isBasketEmpty() {
        int flag = 0;
        while (!pizzaShoppingPage.getEmptyBasketField().isDisplayed()) {
            if (flag == 0) {
                pizzaShoppingPage.getOpenCloseButton().click();
            }
            pizzaShoppingPage.getRemoveOrderButton().click();
            flag++;
        }
        flag = 0;
    }

    @Step("Enter submit button")
    public void enterSubmitButton() {
        log.info("Enter submit button");
        pizzaShoppingPage.getSubmitButton().click();
    }

    @Step("Get pizza price")
    public String getPrice() {
        log.info("Get pizza price");
        return pizzaShoppingPage.getPriceField().getAttribute("data-price");
    }
}
