import org.example.models.PizzaTestData;
import org.example.models.PizzaTypeData;
import org.example.steps.MoveToSteps;
import org.example.steps.PizzaShoppingSteps;
import org.example.utils.JsonReader;
import org.example.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PizzaShoppingTest extends BaseTest {
    PizzaShoppingSteps pizzaShoppingSteps = new PizzaShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();
    Waiters waiters = new Waiters();

    @Test(description = "Check the price of pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest1(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getBavariaPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPrice());
        double expected = pizzaData.getBavariaPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest3(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPrice());
        double expected = pizzaData.getTemptingPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest2(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPrice());
        double expected = pizzaData.getTemptingPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest4(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        waiters.sleep();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPrice());
        double expected = pizzaData.getTemptingPizzaPrice() + pizzaData.getSicilyPizzaPrice();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check the price of pizza in the cart",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest5(PizzaTestData pizzaData) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getSicilyPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getTemptingPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterPizzaButton(pizzaData.getBavariaPizzaName());
        pizzaShoppingSteps.enterSubmitButton();
        waiters.sleep();

        double actual = Double.parseDouble(pizzaShoppingSteps.getPrice());
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
