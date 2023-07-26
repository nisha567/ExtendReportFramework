package org.example.selenium.pageobjects;

import org.example.selenium.util.ObjectRepoHandler;
import org.example.selenium.util.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(name="username")
    private WebElement usernameTextBox;
    @FindBy(name = "password")
    private WebElement passwordTextBox;
    By usernameLocator = By.name("username");
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement login_clickButton;
    public String getUserNameText(){
        //Reading from Properties file objectrepo for particular element
        String locator_type_value = PropertiesFileReader.getPropValue("objectrepo","orangehrm.loginpage.username.textvalue");
        //from the above value write function to take value before & after '_'
        String locator = locator_type_value.substring(0,locator_type_value.indexOf("_"));
        String locator_value = locator_type_value.substring(locator_type_value.indexOf("_")+1);
        WebElement userNameText = ObjectRepoHandler.getElement(driver , locator , locator_value);
        return userNameText.getText();
    }
    public String getUPasswordText(){
        //Reading from Properties file objectrepo for particular element
        String locator_type_value = PropertiesFileReader.getPropValue("objectrepo","orangehrm.loginpage.password.textvalue");
        //from the above value write function to take value before & after '_'
        String locator = locator_type_value.substring(0,locator_type_value.indexOf("_"));
        String locator_value = locator_type_value.substring(locator_type_value.indexOf("_")+1);
        WebElement passwordText = ObjectRepoHandler.getElement(driver , locator , locator_value);
        return passwordText.getText();
    }

    public LoginPage enterUserName(String inputValue){
        // WebElement user_name_element = driver.findElement(usernameLocator);
        // user_name_element.sendKeys(inputValue);

        this.usernameTextBox.sendKeys(inputValue);
        return this; //Facade design pattern
    }

    public LoginPage enterPassword(String pwdValue){
        this.passwordTextBox.sendKeys(pwdValue);
        return this;
    }
    public DashbordPage clickSubmit() {
        login_clickButton.click();
        return new DashbordPage(super.driver);
    }
}
