import io.qameta.allure.Issue;
import org.example.models.PizzaPrice;
import org.example.steps.MoveToSteps;
import org.example.steps.PizzaShoppingSteps;
import org.example.utils.JsonReaderPrices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaShoppingTest extends BaseTest {
    PizzaShoppingSteps pizzaShoppingSteps = new PizzaShoppingSteps();
    MoveToSteps moveToSteps = new MoveToSteps();

    @Test(description = "Check pizza price in cart: Bavaria",
            dataProvider = "pizzaPrice", dataProviderClass = JsonReaderPrices.class)
    public void checkPizzaShoppingTest1(PizzaPrice pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterBavariaPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getBavariaPizzaPrice()));
    }

    @Test(description = "Check pizza price in cart: Tempting",
            dataProvider = "pizzaPrice", dataProviderClass = JsonReaderPrices.class)
    public void checkPizzaShoppingTest3(PizzaPrice pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getTemptingPizzaPrice()));
    }

    @Test(description = "Check pizza price in cart: Sicily",
            dataProvider = "pizzaPrice", dataProviderClass = JsonReaderPrices.class)
    public void checkPizzaShoppingTest2(PizzaPrice pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getSicilyPizzaPrice()));
    }

    @Issue("Permanent error")
    @Test(description = "Check pizza price in cart: Sicily + Tempting",
            dataProvider = "pizzaPrice", dataProviderClass = JsonReaderPrices.class)
    public void checkPizzaShoppingTest4(PizzaPrice pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getSicilyTemptingPizzaPrices()));
    }

    @Issue("Permanent error")
    @Test(description = "Check pizza price in cart: Sicily + Tempting + Bavaria",
            dataProvider = "pizzaPrice", dataProviderClass = JsonReaderPrices.class)
    public void checkPizzaShoppingTest5(PizzaPrice pizzaPrice) {
        moveToSteps.moveToPizzaShopping();
        pizzaShoppingSteps.isBasketEmpty();
        pizzaShoppingSteps.enterSicilyPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterTemptingPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();
        pizzaShoppingSteps.enterBavariaPizzaButton();
        pizzaShoppingSteps.enterSubmitButton();

        Assert.assertTrue(pizzaShoppingSteps.getPrice().contains(pizzaPrice.getSicilyTemptingBavariaPizzaPrices()));
    }
}
