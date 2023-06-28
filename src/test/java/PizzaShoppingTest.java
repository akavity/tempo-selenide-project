import io.qameta.allure.Issue;
import org.example.models.PizzaTestData;
import org.example.steps.MoveToSteps;
import org.example.steps.PizzaShoppingSteps;
import org.example.utils.JsonReader;
import org.example.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaShoppingTest extends BaseTest {
    PizzaShoppingSteps pizzaShoppingSteps = new PizzaShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();
    Waiters waiters = new Waiters();

    @Test(description = "Check pizza price in cart: Bavaria",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest1(PizzaTestData pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterBavariaPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getBavariaPizzaPrice()));
    }

    @Test(description = "Check pizza price in cart: Tempting",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest3(PizzaTestData pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getTemptingPizzaPrice()));
    }

    @Test(description = "Check pizza price in cart: Sicily",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest2(PizzaTestData pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getSicilyPizzaPrice()));
    }

    @Issue("Permanent error")
    @Test(description = "Check pizza price in cart: Sicily + Tempting",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest4(PizzaTestData pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        waiters.sleep();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getSicilyTemptingPizzaPrices()));
    }

    @Issue("Permanent error")
    @Test(description = "Check pizza price in cart: Sicily + Tempting + Bavaria",
            dataProvider = "pizzaTestData", dataProviderClass = JsonReader.class)
    public void checkPizzaShoppingTest5(PizzaTestData pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterBavariaPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        waiters.sleep();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getSicilyTemptingBavariaPizzaPrices()));
    }
}
