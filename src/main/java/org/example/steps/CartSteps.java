package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.CartPage;
import org.example.utils.Utils;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();
    Utils utils = new Utils();

    @Step("Remove pizza from cart")
    public void cleanCart() {
        while (!(isPriceStringEmpty(cartPage.getPriceOrder().getText()))) {
            cartPage.getRemoveOrderButton().click();
            utils.sleep(900);
        }
    }

    @Step
    public boolean isOrderPriceEmpty() {
        return isPriceStringEmpty(cartPage.getPriceOrder().getText());
    }

    private boolean isPriceStringEmpty(String text) {
        return (text
                .replace("р.", "")
                .replace("к.", ""))
                .isEmpty();
    }
}
