package org.example;

import io.qameta.allure.Flaky;
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

public class OrderShoppingTest extends BaseTest {
    ShoppingSteps shoppingSteps = new ShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();
    Utils utils = new Utils();

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of good in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInBasketTopTest1(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getFirstProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of good in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInBasketTopTest2(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getSecondProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of good in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInBasketTopTest3(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getThirdProductName());
        shoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getThirdProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of two goods in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoGoodsInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterGoodButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();
        utils.sleep();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getFirstProductPrice() + orderData.getSecondProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @Flaky
    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of three goods in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTreeGoodsInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterGoodButton(orderData.getThirdProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterGoodButton(orderData.getFourthProductName());
        shoppingSteps.enterSubmitButton();
        utils.sleep();


        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getSecondProductPrice() + orderData.getThirdProductPrice()
                + orderData.getFourthProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of goods in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getFirstProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of goods in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoGoodsInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterGoodButton(orderData.getFirstProductName());
        shoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getFirstProductPrice() + orderData.getSecondProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @Flaky
    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of goods in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTreeGoodsInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.enterGoodButton(orderData.getSecondProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterGoodButton(orderData.getThirdProductName());
        shoppingSteps.enterSubmitButton();
        shoppingSteps.enterGoodButton(orderData.getFourthProductName());
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
        shoppingSteps.choosePizzaType(orderData.getPizzaType());
        shoppingSteps.enterResultButton();

        List<String> actual = shoppingSteps.getArrayPizzaNames();
        List<String> expected = orderData.getPizzaNames();
        Collections.sort(actual);
        Collections.sort(expected);

        Assert.assertEquals(actual, expected);
    }
}
