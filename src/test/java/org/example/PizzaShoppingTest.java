package org.example;

import io.qameta.allure.Flaky;
import org.example.annotatins.TestData;
import org.example.models.PizzaTestData;
import org.example.models.PizzaTypeData;
import org.example.steps.MoveToSteps;
import org.example.steps.ShoppingSteps;
import org.example.utils.JsonReader;
import org.example.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class PizzaShoppingTest extends BaseTest {
    ShoppingSteps pizzaShoppingSteps = new ShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();
    Utils utils = new Utils();

    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of 'Bavaria' pizza in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInBasketTopTest1(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getBavariaPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(pizzaData.getBavariaPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of 'Tempting' pizza in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInBasketTopTest2(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(pizzaData.getTemptingPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of 'Sicily' pizza in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInBasketTopTest3(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(pizzaData.getSicilyPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of two pizzas in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoGoodsInBasketTop(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        utils.sleep();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @Flaky
    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of three pizzas in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTreeGoodsInBasketTop(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getVesuviusPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        utils.sleep();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(pizzaData.getSicilyPizzaPrice() + pizzaData.getTemptingPizzaPrice()
                + pizzaData.getVesuviusPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of 'Sicily' pizza in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfGoodInCart(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(pizzaData.getSicilyPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of two pizzas in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoGoodsInCart(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @Flaky
    @TestData(jsonFile = "pizzaTestData", model = "PizzaTestData")
    @Test(description = "Check the price of three pizzas in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTreeGoodsInCart(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getVesuviusPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice()
                + pizzaData.getVesuviusPizzaPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "pizzaTypeData", model = "PizzaTypeData")
    @Test(description = "Check pizza sorting by type",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkSortingByType(PizzaTypeData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.choosePizzaType(pizzaData.getPizzaType());
        pizzaShoppingSteps.enterResultButton();

        List<String> actual = pizzaShoppingSteps.getArrayPizzaNames();
        List<String> expected = pizzaData.getPizzaNames();
        Collections.sort(actual);
        Collections.sort(expected);

        Assert.assertEquals(actual, expected);
    }
}
