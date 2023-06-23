import io.qameta.allure.Issue;
import org.example.steps.MoveToSteps;
import org.example.steps.PizzaShoppingSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaShoppingTest extends BaseTest {
    PizzaShoppingSteps pizzaShoppingSteps = new PizzaShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();

    @Test(description = "Check pizza price in cart: Bavaria")
    public void checkPizzaShoppingTest1() {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterBavariaPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains("12.7"));
    }

    @Test(description = "Check pizza price in cart: Tempting")
    public void checkPizzaShoppingTest3() {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains("12.5"));
    }

    @Test(description = "Check pizza price in cart: Sicily")
    public void checkPizzaShoppingTest2() {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains("10.7"));
    }

    @Issue("Permanent error")
    @Test(description = "Check pizza price in cart: Sicily + Tempting")
    public void checkPizzaShoppingTest4() {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains("23.2"));
    }

    @Issue("Permanent error")
    @Test(description = "Check pizza price in cart: Sicily + Tempting + Bavaria")
    public void checkPizzaShoppingTest5() {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterBavariaPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains("35.9"));
    }
}
