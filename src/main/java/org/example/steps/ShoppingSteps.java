package org.example.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ShoppingPage;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class ShoppingSteps {
    ShoppingPage shoppingPage = new ShoppingPage();
    Utils utils = new Utils();

    @Step("Click product button")
    public void clickProductButton(String productName) {
        log.info("Click product button:  " + productName);
        shoppingPage.getProductButton(productName).click();
    }

    @Step("Select pizza type")
    public void selectPizzaType(String pizzaType) {
        log.info("Select " + pizzaType + " pizza");
        shoppingPage.getPizzaTypeButton(pizzaType).click();
    }

    @Step("Click result button")
    public void clickResultButton() {
        log.info("Click result button");
        shoppingPage.getResultButton().click();
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        log.info("Click submit button");
        shoppingPage.getSubmitButton().click();
    }

    @Step("Click modify submit button")
    public void clickModifySubmitButton() {
        log.info("Click modify submit button");
        shoppingPage.getModifySubmitButton().click();
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

    @Step("Remove products from cart")
    public void cleanBasketTop() {
        int flag = 0;
        while (!shoppingPage.getEmptyBasketField().isDisplayed()) {
            if (flag == 0) {
                shoppingPage.getOpenCloseButton().click();
            }
            shoppingPage.getRemoveOrderButton().click();
            utils.sleep(900);
            flag++;
        }
    }

    @Step("Add component to the order")
    public void addComponent(String component) {
        log.info("Add component: " + component);
        shoppingPage.addComponentButton(component).click();
    }

    @Step("Remove component from the order")
    public void removeComponent(String component) {
        log.info("Remove component: " + component);
        shoppingPage.removeComponentButton(component).click();
    }

    @Step("The basket top is clean")
    public boolean isBasketTopClean() {
        return shoppingPage.getEmptyBasketField().isDisplayed();
    }

    @Step("Get array pizza names by type")
    public List<String> getArrayPizzaNames() {
        log.info("Create array pizza names");
        List<String> arrayPizzaNames = new ArrayList<>();

        for (SelenideElement pizzaText : shoppingPage.getProductNames()) {
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
