package org.example;

import org.example.models.UserData;
import org.example.steps.MoveToSteps;
import org.example.steps.RegistrationSteps;
import org.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    RegistrationSteps registrationSteps = new RegistrationSteps();
    MoveToSteps moveToSteps = new MoveToSteps();

    @Test(description = "Make a mistake during registration",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void makeMistakeDuringRegistration(UserData userData) {
        moveToSteps.moveToRegistrationForm();
        registrationSteps.enterEmail(userData.getEmail());
        registrationSteps.enterPassword(userData.getPassword());
        registrationSteps.repeatPassword(userData.getPassword());
        registrationSteps.enterUser(userData.getUserData());
        registrationSteps.enterPhone(userData.getPhone());
        registrationSteps.clickGenderButton();
        registrationSteps.chooseAge(userData.getAge());
        registrationSteps.chooseOccupation(userData.getOccupation());
        registrationSteps.enterStreet(userData.getStreet());
        registrationSteps.enterHouse(userData.getHouse());
        registrationSteps.enterApartment(userData.getApartment());
        registrationSteps.enterPorch(userData.getPorch());
        registrationSteps.enterFloor(userData.getFloor());
        registrationSteps.clickSubmitButton();

        Assert.assertTrue(registrationSteps.isThereErrorPhone(userData.getError()));
    }

    @Test(description = "Log in as an unregistered user",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void logInAsUnregisteredUser(UserData userData) {
        registrationSteps.enterUserAccountEmail(userData.getEmail());
        registrationSteps.enterUserAccountPassword(userData.getPassword());
        registrationSteps.clickAccountSubmitButton();

        Assert.assertTrue(registrationSteps.isThereAccountError());
    }
}
