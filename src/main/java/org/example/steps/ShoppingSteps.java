package org.example.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ShoppingPage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class ShoppingSteps {
    ShoppingPage shoppingPage = new ShoppingPage();

    @Step("Enter good button")
    public void enterGoodButton(String goodName) {
        log.info("Enter " + goodName + " pizza");
        shoppingPage.getGoodButton(goodName).click();
    }

    @Step("Choose pizza type")
    public void choosePizzaType(String pizzaType) {
        log.info("Choose " + pizzaType + " pizza");
        shoppingPage.getPizzaTypeButton(pizzaType).click();
    }

    @Step("Enter result button")
    public void enterResultButton() {
        log.info("Enter result button");
        shoppingPage.getResultButton().click();
    }

    @Step("Remove good from cart")
    public void isBasketEmpty() {
        int flag = 0;
        while (!shoppingPage.getEmptyBasketField().isDisplayed()) {
            if (flag == 0) {
                shoppingPage.getOpenCloseButton().click();
            }
            shoppingPage.getRemoveOrderButton().click();
            flag++;
        }
        flag = 0;
    }

    @Step("Enter submit button")
    public void enterSubmitButton() {
        log.info("Enter submit button");
        shoppingPage.getSubmitButton().click();
    }

    @Step("Get price from basket top")
    public String getPriceFromBasketTop() {
        log.info("Get price basket top");
        return shoppingPage.getPriceBasketTopField().getAttribute("data-price");
    }

    @Step("Get price from cart")
    public String getPriceFromCart() {
        log.info("Get price from cart");
        return shoppingPage.getPriceCartField().getText()
                .replace("р", "").replace("к.", "");
    }

    @Step("Get array pizza names by type")
    public List<String> getArrayPizzaNames() {
        log.info("Create array pizza names");
        List<String> arrayPizzaNames = new ArrayList<>();

        for (SelenideElement pizzaText : shoppingPage.getGoodsNames()) {
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
