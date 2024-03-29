package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.MoveToPage;

@Log4j2
public class MoveToSteps {
    MoveToPage moveToPage = new MoveToPage();
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";

    @Step("Move to registration form")
    public void moveToRegistrationForm() {
        log.info("Move to registration form");
        moveToPage.getRegistrationButton().click();
    }

    @Step("Move to order type")
    public void moveToOrderType(String orderType) {
        log.info("/// Move to " + orderType);
        moveToPage.getTOrderTypeButton(orderType).scrollIntoView(PARAMETER);
        moveToPage.getTOrderTypeButton(orderType).click();
    }

    @Step("Move to basket")
    public void moveToCart() {
        log.info("Move to basket");
        moveToPage.getCartButton().click();
    }
}
