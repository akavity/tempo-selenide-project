package org.example.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.CartPage;
import org.example.utils.Utils;

import java.util.Objects;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();
    Utils utils = new Utils();
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";

    @Step("Remove pizza from cart")
    public void cleanCart() {
        while (!(isPriceStringEmpty(cartPage.getPriceOrder()))) {
            log.info("Click button and remove order");
            cartPage.getRemoveOrderButton().click();
            utils.sleep(900);
        }
    }

    @Step
    public double getTotalPrice() {
        cartPage.getTotalAmount().scrollIntoView(PARAMETER);
        double result = Double.parseDouble(Objects.requireNonNull(cartPage.getTotalAmount().getAttribute("data-price")));
        log.info("Total prise is " + result);
        return result;
    }

    private boolean isPriceStringEmpty(SelenideElement text) {
        String result = text.getText();
        boolean emptyString = result.isEmpty();
        if (!emptyString) {
            log.info("Price string = " + result);
        } else {
            log.info("Price string is empty");
        }
        return emptyString;
    }
}
