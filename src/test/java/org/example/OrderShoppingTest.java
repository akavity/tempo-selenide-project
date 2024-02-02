package org.example;

import org.example.annotatins.TestData;
import org.example.models.OrderTestData;
import org.example.models.PizzaTypeData;
import org.example.steps.MoveToSteps;
import org.example.steps.ShoppingSteps;
import org.example.utils.JsonReader;
import org.example.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class OrderShoppingTest extends MainTest {
    ShoppingSteps shoppingSteps = new ShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();
    Utils utils = new Utils();

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of item in basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfItemInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterProductButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getFirstProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of two items in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoItemsInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterProductButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterProductButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();
        utils.sleep();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getFirstProductPrice() + orderData.getSecondProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of three items in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfThreeItemsInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterProductButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterProductButton(orderData.getThirdProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterProductButton(orderData.getFourthProductName());
        shoppingSteps.enterSubmitButton();
        utils.sleep();


        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getSecondProductPrice() + orderData.getThirdProductPrice()
                + orderData.getFourthProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of item in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfItemInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterProductButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getFirstProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of two items the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoItemsInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterProductButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterProductButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getFirstProductPrice() + orderData.getSecondProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of three items in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfThreeItemsInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterProductButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterProductButton(orderData.getThirdProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterProductButton(orderData.getFourthProductName());
        shoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getSecondProductPrice() + orderData.getThirdProductPrice()
                + orderData.getFourthProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTypeData", model = "PizzaTypeData")
    @Test(description = "Check pizza sorting by type",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkSortingByType(PizzaTypeData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.selectPizzaType(orderData.getPizzaType());
        shoppingSteps.enterResultButton();

        List<String> actual = shoppingSteps.getArrayPizzaNames();
        List<String> expected = orderData.getPizzaNames();
        Collections.sort(actual);
        Collections.sort(expected);

        Assert.assertEquals(actual, expected);
    }
}
