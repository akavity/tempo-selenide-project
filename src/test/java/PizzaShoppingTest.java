import io.qameta.allure.Flaky;
import org.example.models.PizzaTestData;
import org.example.models.PizzaTypeData;
import org.example.steps.MoveToSteps;
import org.example.steps.ShoppingSteps;
import org.example.utils.JsonReader;
import org.example.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PizzaShoppingTest extends BaseTest {
    ShoppingSteps pizzaShoppingSteps = new ShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();
    Waiters waiters = new Waiters();

    @Flaky
    @Test(description = "Check the price of 'Bavaria' pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfGoodInBasketTopTest1(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getBavariaPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = pizzaData.getBavariaPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Flaky
    @Test(description = "Check the price of 'Tempting' pizza in the basket top",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfGoodInBasketTopTest2(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = pizzaData.getTemptingPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Flaky
    @Test(description = "Check the price of 'Sicily' pizza in the basket top",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfGoodInBasketTopTest3(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = pizzaData.getSicilyPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of two pizzas in the basket top",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfTwoGoodsInBasketTop(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        waiters.sleep();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of three pizzas in the basket top",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfTreeGoodsInBasketTop(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getBavariaPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        waiters.sleep();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromBasketTop());
        double expected = pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice()
                + pizzaData.getBavariaPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of 'Sicily' pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfGoodInCart(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromCart());
        double expected = pizzaData.getSicilyPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of two pizzas in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfTwoGoodsInCart(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromCart());
        double expected = pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of three pizzas in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPriceOfTreeGoodsInCart(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterGoodButton(pizzaData.getBavariaPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        moveToSteps.moveToBasket();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPriceFromCart());
        double expected = pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice()
                + pizzaData.getBavariaPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check pizza sorting by type",
            dataProvider = "pizzaTypeData", dataProviderClass = JsonReader.class)
    public void checkSortingByType(PizzaTypeData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.choosePizzaType(pizzaData.getPizzaType());
        pizzaShoppingSteps.enterResultButton();

        List<String> actual = pizzaShoppingSteps.getArrayPizzaNames();
        List<String> expected = pizzaData.getPizzaNames();

        Assert.assertEquals(actual, expected);
    }
}
