package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//h1[normalize-space()='Register'])[1]")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

   @CacheLookup
   @FindBy(id = "Password")
   WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
      @CacheLookup
      @FindBy(id = "register-button")
      WebElement registerButton;

      @CacheLookup
      @FindBy(id = "FirstName-error")
      WebElement firstNameRequired;

      @CacheLookup
      @FindBy(id = "LastName-error")
      WebElement lastNameRequired;

      @CacheLookup
      @FindBy(id = "Email-error")
      WebElement emailRequired;

      @CacheLookup
      @FindBy(id = "Password-error")
      WebElement passwordRequired;

      @CacheLookup
      @FindBy(id = "ConfirmPassword-error")
      WebElement confirmPasswordRequired;

      @CacheLookup
      @FindBy(id = "gender-female")
      WebElement femaleRadioButton;

      @CacheLookup
      @FindBy(name = "DateOfBirthDay")
      WebElement Day;

      @CacheLookup
      @FindBy(name = "DateOfBirthMonth")
      WebElement month;

      @CacheLookup
      @FindBy(name = "DateOfBirthYear")
      WebElement year;

      @CacheLookup
      @FindBy(xpath = "(//div[@class='result'])[1]")
      WebElement registrationCompletedText;

     public String getRegisterText(){
         String message = getTextFromElement(registerText);
         CustomListeners.test.log(Status.PASS,"Get register Text");
         return message;
     }
     public void clickOnRegisterButton(){
         clickOnElement(registerButton);
         CustomListeners.test.log(Status.PASS, "click on button");
     }

     public String getFirstNameRequiredText(){
         String message = getTextFromElement(firstNameRequired);
         CustomListeners.test.log(Status.PASS,"first name required");
         return message;
     }
     public String getLastNameRequiredText(){
         String message = getTextFromElement(lastNameRequired);
         CustomListeners.test.log(Status.PASS,"Last name required");
         return message;
     }
    public String getEmailRequiredText(){
        String message = getTextFromElement(emailRequired);
        CustomListeners.test.log(Status.PASS,"Email Id required");
        return message;
    }
    public String getPasswordRequiredText() {
        String message = getTextFromElement(passwordRequired);
        CustomListeners.test.log(Status.PASS, "Password required");
        return message;
    }
    public String getConfirmPasswordRequiredText() {
        String message = getTextFromElement(confirmPasswordRequired);
        CustomListeners.test.log(Status.PASS, "Confirm Password required");
        return message;
    }
    public void clickOnRadioButton(){
         clickOnElement(femaleRadioButton);
         CustomListeners.test.log(Status.PASS,"Radio button");
    }
    public void enterFirstName(String value){
        sendTextToElement(firstName, value);
        CustomListeners.test.log(Status.PASS,"Enter First name");
    }

    public void enterLastName(String value){
         sendTextToElement(lastName, value);
        CustomListeners.test.log(Status.PASS,"Enter Last name");
    }
    public void enterDate(String enterDate){
         selectByValueFromDropDown(Day, enterDate);
        CustomListeners.test.log(Status.PASS,"Enter date");
    }

    public void enterMonth(String enterMonth){
         selectByVisibleTextFromDropDown(month, enterMonth );
        CustomListeners.test.log(Status.PASS,"Enter month");
    }

    public void enterYear(String enterYear){
         selectByVisibleTextFromDropDown(year, enterYear);
        CustomListeners.test.log(Status.PASS,"Enter year");
    }
    public void enterEmail(String value){
         sendTextToElement(email, value);
        CustomListeners.test.log(Status.PASS,"Enter email");
    }

    public void enterPassword(String value){
         sendTextToElement(password, value);
        CustomListeners.test.log(Status.PASS,"Enter password");
    }

    public void enterConfirmPassword(String value){
        sendTextToElement(confirmPassword, value );
        CustomListeners.test.log(Status.PASS,"Enter confirmPassword");
    }
    public String getRegistrationSuccessfulText(){
         String message = getTextFromElement(registrationCompletedText);
         return message;
    }




}
