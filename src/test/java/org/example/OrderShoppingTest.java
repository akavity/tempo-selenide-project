package org.example;

import org.example.annotatins.TestData;
import org.example.models.ComponentData;
import org.example.models.OrderTestData;
import org.example.models.PizzaTypeData;
import org.example.steps.CartSteps;
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
    CartSteps cartSteps = new CartSteps();
    Utils utils = new Utils();

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of item in basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfItemInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.clickProductButton(orderData.getFirstProductName());
        shoppingSteps.clickSubmitButton();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromBasketTop());
        double expected = utils.roundOf(orderData.getFirstProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of two items in the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoItemsInBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.clickProductButton(orderData.getSecondProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getFirstProductName());
        shoppingSteps.clickSubmitButton();
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
        shoppingSteps.clickProductButton(orderData.getSecondProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getThirdProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getFourthProductName());
        shoppingSteps.clickSubmitButton();
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
        shoppingSteps.clickProductButton(orderData.getFirstProductName());
        shoppingSteps.clickSubmitButton();
        moveToSteps.moveToCart();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getFirstProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of two items the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfTwoItemsInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.clickProductButton(orderData.getSecondProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getFirstProductName());
        shoppingSteps.clickSubmitButton();
        moveToSteps.moveToCart();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(orderData.getFirstProductPrice() + orderData.getSecondProductPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Check the price of three items in the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkPriceOfThreeItemsInCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.clickProductButton(orderData.getSecondProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getThirdProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getFourthProductName());
        shoppingSteps.clickSubmitButton();
        moveToSteps.moveToCart();

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
        shoppingSteps.clickResultButton();

        List<String> actual = shoppingSteps.getArrayPizzaNames();
        List<String> expected = orderData.getPizzaNames();
        Collections.sort(actual);
        Collections.sort(expected);

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Clean the basket top",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void removeItemsFromBasketTop(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.clickProductButton(orderData.getSecondProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getThirdProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getFourthProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.cleanBasketTop();

        Assert.assertTrue(shoppingSteps.isBasketTopClean());
    }

    @TestData(jsonFile = "orderTestData", model = "OrderTestData")
    @Test(description = "Clean the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void removeItemsFromCart(OrderTestData orderData) {
        moveToSteps.moveToOrderType(orderData.getOrderType());
        shoppingSteps.clickProductButton(orderData.getSecondProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getThirdProductName());
        shoppingSteps.clickSubmitButton();
        shoppingSteps.clickProductButton(orderData.getFourthProductName());
        shoppingSteps.clickSubmitButton();
        moveToSteps.moveToCart();
        cartSteps.cleanCart();

        Assert.assertEquals(cartSteps.getTotalPrice(), 0.0);
    }

    @TestData(jsonFile = "componentData", model = "ComponentData")
    @Test(description = "Add components to the order",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    private void addComponentsToOrder(ComponentData componentData) {
        moveToSteps.moveToOrderType(componentData.getOrderType());
        shoppingSteps.clickProductButton(componentData.getProductName());
        shoppingSteps.addComponent(componentData.getFirstComponent());
        shoppingSteps.addComponent(componentData.getSecondComponent());
        shoppingSteps.addComponent(componentData.getThirdComponent());
        shoppingSteps.clickSubmitButton();
        moveToSteps.moveToCart();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(componentData.getProductPrice() + componentData.getFirstComponentPrice()
                + componentData.getSecondComponentPrice() + componentData.getThirdComponentPrice());

        Assert.assertEquals(actual, expected);
    }

    @TestData(jsonFile = "componentData", model = "ComponentData")
    @Test(description = "Remove components from the order",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    private void removeComponentsFromOrder(ComponentData componentData) {
        moveToSteps.moveToOrderType(componentData.getOrderType());
        shoppingSteps.clickProductButton(componentData.getProductName());
        shoppingSteps.addComponent(componentData.getFirstComponent());
        shoppingSteps.addComponent(componentData.getSecondComponent());
        shoppingSteps.addComponent(componentData.getThirdComponent());
        shoppingSteps.clickSubmitButton();
        moveToSteps.moveToCart();
        cartSteps.clickProductInCart(componentData.getProductName());
        shoppingSteps.removeComponent(componentData.getFirstComponent());
        shoppingSteps.removeComponent(componentData.getSecondComponent());
        shoppingSteps.removeComponent(componentData.getThirdComponent());
        shoppingSteps.clickModifySubmitButton();

        double actual = Double.parseDouble(shoppingSteps.getPriceFromCart());
        double expected = utils.roundOf(componentData.getProductPrice());

        Assert.assertEquals(actual, expected);
    }
}
