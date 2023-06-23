package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.withText;

@Log4j2
public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Enter email")
    public void enterEmail(String email) {
        log.info("Enter email");
        registrationPage.getEmailField().setValue(email);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        log.info("Enter password");
        registrationPage.getPasswordField().setValue(password);
    }

    @Step("Repeat password")
    public void repeatPassword(String password) {
        log.info("Repeat password");
        registrationPage.getPasswordRepeatField().setValue(password);
    }

    @Step("Get User Account Error")
    public boolean isThereAccountError() {
        log.info("Get User Account Error");
        return registrationPage.getUserAccountError().isDisplayed();
    }

    @Step("Enter first name, last name")
    public void enterUser(String firstAndSecondNames) {
        log.info("Enter first name, last name");
        registrationPage.getUserField().setValue(firstAndSecondNames);
    }

    @Step("Enter mobile phone")
    public void enterPhone(String phone) {
        log.info("Enter mobile phone");
        registrationPage.getPhoneField().setValue(phone);
    }

    @Step("Click gender button")
    public void clickGenderButton() {
        log.info("Click gender button");
        registrationPage.getGenderMaleButton().click();
    }

    @Step("Choose age")
    public void chooseAge(String age) {
        log.info("Choose age");
        registrationPage.getAgeDropDown().click();
        registrationPage.getAgeDropDown().find(withText(age)).click();
    }

    @Step("Choose occupation")
    public void chooseOccupation(String occupation) {
        log.info("Choose occupation");
        registrationPage.getOccupationDropDown().click();
        registrationPage.getOccupationDropDown().find(withText(occupation)).click();
    }

    @Step("Enter street")
    public void enterStreet(String street) {
        log.info("Enter street");
        registrationPage.getStreetField().setValue(street);
    }

    @Step("Enter hose")
    public void enterHouse(String house) {
        log.info("Enter hose");
        registrationPage.getHouseField().setValue(house);
    }

    @Step("Enter apartment")
    public void enterApartment(String apartment) {
        log.info("Enter apartment");
        registrationPage.getApartmentField().setValue(apartment);
    }

    @Step("Enter porch")
    public void enterPorch(String porch) {
        log.info("Enter porch");
        registrationPage.getPorchField().setValue(porch);
    }

    @Step("Enter floor")
    public void enterFloor(String floor) {
        log.info("Enter floor");
        registrationPage.getFloorField().setValue(floor);
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        log.info("Click submit button");
        registrationPage.getSubmitButton().click();
    }

    @Step("Get Error Phone")
    public boolean isThereErrorPhone() {
        log.info("Get Error Phone");
        return registrationPage.getErrorPhone().isDisplayed();
    }

    @Step("Enter user account email")
    public void enterUserAccountEmail(String email) {
        log.info("Enter user account email");
        registrationPage.getUserAccountEmail().setValue(email);
    }

    @Step("Enter user account password")
    public void enterUserAccountPassword(String password) {
        log.info("Enter user account password");
        registrationPage.getUserAccountPassword().setValue(password);
    }

    @Step("Click user account submit button")
    public void clickAccountSubmitButton() {
        log.info("Click user account submit button");
        registrationPage.getSubmitAccountButton().click();
    }
}
