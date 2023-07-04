package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private final SelenideElement accountEmailField =
            $(By.xpath("//input[@name='astroauth_login']"));
    private final SelenideElement accountPasswordField =
            $(By.xpath("//input[@name='astroauth_pass']"));
    private final SelenideElement submitAccountButton =
            $(By.xpath("//input[@name='astroauth_submit']"));
    private final SelenideElement accountNotificationError =
            $(By.xpath("//div[@class='popupContent']"));
    private final SelenideElement emailField =
            $(By.xpath("//input[@name='email']"));
    private final SelenideElement passwordField =
            $(By.xpath("//input[@name='pass']"));
    private final SelenideElement passwordRepeatField =
            $(By.xpath("//input[@name='repass']"));
    private final SelenideElement userField =
            $(By.xpath("//input[@name='fio']"));
    private final SelenideElement phoneField =
            $(By.xpath("//input[@name='phone']"));
    private final SelenideElement genderMaleButton =
            $(By.xpath("//input[@ value='мужской']"));
    private final SelenideElement genderFemaleButton =
            $(By.xpath("//input[@ value='женский']"));
    private final SelenideElement subscribeButton =
            $(By.xpath("//input[@name='subscribe']"));
    private final SelenideElement ageDropDown =
            $(By.xpath("//select[@ name='age']"));
    private final SelenideElement occupationDropDown =
            $(By.xpath("//select[@name='occupation']"));
    private final SelenideElement streetField =
            $(By.xpath("//input[@name='street']"));
    private final SelenideElement houseField =
            $(By.xpath("//input[@name='house']"));
    private final SelenideElement apartmentField =
            $(By.xpath("//input[@name='room']"));
    private final SelenideElement porchField =
            $(By.xpath("//input[@name='porch']"));
    private final SelenideElement floorField =
            $(By.xpath("//input[@name='floor']"));
    private final SelenideElement submitButton =
            $(By.xpath("//button[contains (@class,'btn button')]"));
    private final SelenideElement errorPhone =
            $(By.xpath("//div[contains (text(),'Контактный телефон')]"));

    public SelenideElement getUserAccountEmail() {
        return accountEmailField;
    }

    public SelenideElement getUserAccountPassword() {
        return accountPasswordField;
    }

    public SelenideElement getSubmitAccountButton() {
        return submitAccountButton;
    }

    public SelenideElement getUserAccountError() {
        return accountNotificationError;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getPasswordRepeatField() {
        return passwordRepeatField;
    }

    public SelenideElement getUserField() {
        return userField;
    }

    public SelenideElement getPhoneField() {
        return phoneField;
    }

    public SelenideElement getGenderMaleButton() {
        return genderMaleButton;
    }

    public SelenideElement getGenderFemaleButton() {
        return genderFemaleButton;
    }

    public SelenideElement getSubscribeButton() {
        return subscribeButton;
    }

    public SelenideElement getAgeDropDown() {
        return ageDropDown;
    }

    public SelenideElement getOccupationDropDown() {
        return occupationDropDown;
    }

    public SelenideElement getStreetField() {
        return streetField;
    }

    public SelenideElement getHouseField() {
        return houseField;
    }

    public SelenideElement getApartmentField() {
        return apartmentField;
    }

    public SelenideElement getPorchField() {
        return porchField;
    }

    public SelenideElement getFloorField() {
        return floorField;
    }

    public SelenideElement getErrorPhone() {
        return errorPhone;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }
}
