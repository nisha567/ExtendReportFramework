package org.example.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashbordPage extends BasePage{

    @FindBy(xpath ="//a[normalize-space()='My Info']")
    private WebElement myInfoLink;

    public DashbordPage(WebDriver driver) {
        super(driver);
    }

    public  MyInfoPage clickMyInfoLink(){
        this.myInfoLink.click();
        return PageFactory.initElements(driver, MyInfoPage.class);
    }


}
