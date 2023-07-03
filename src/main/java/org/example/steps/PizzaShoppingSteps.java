package org.example.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.PizzaShoppingPage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class PizzaShoppingSteps {
    PizzaShoppingPage pizzaShoppingPage = new PizzaShoppingPage();

    @Step("Enter pizza button")
    public void enterPizzaButton(String pizzaName) {
        log.info("Enter " + pizzaName + " pizza");
        pizzaShoppingPage.getPizzaButton(pizzaName).click();
    }

    @Step("Choose pizza type")
    public void choosePizzaType(String pizzaType) {
        log.info("Choose " + pizzaType + " pizza");
        pizzaShoppingPage.getPizzaTypeButton(pizzaType).click();
    }

    @Step("Enter result button")
    public void enterResultButton() {
        log.info("Enter result button");
        pizzaShoppingPage.getResultButton().click();
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

    @Step("Get array pizza names by type")
    public List<String> getArrayPizzaNames() {
        log.info("Create array pizza names");
        List<String> arrayPizzaNames = new ArrayList<>();

        for (SelenideElement pizzaText : pizzaShoppingPage.getPizzaNames()) {
            log.info("fine pizza: " + pizzaText.getText());
            Pattern pattern = Pattern.compile("\"(.*)\"");
            Matcher matcher = pattern.matcher(pizzaText.getText());

            while (matcher.find()) {
                log.info("add pizza: " + matcher.group());
                arrayPizzaNames.add(matcher.group().replace("\"", ""));
            }
        }

        return arrayPizzaNames;
    }
}
