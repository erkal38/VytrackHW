package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }
        @FindBy(id="prependedInput")
        public WebElement usernameInput;
        @FindBy(id="prependedInput2")
        public WebElement passwordInput;
        @FindBy(id = "_submit")
        public WebElement loginBtn;


        public void login(String usernameStr,String passwordStr){
            usernameInput.sendKeys(usernameStr);
            passwordInput.sendKeys(passwordStr);
            loginBtn.click();
    }
        public void loginAsDriver() {
            String username = ConfigurationReader.get("storemanager_username");
            String password = ConfigurationReader.get("storemanager_password");
            usernameInput.sendKeys(username);
            passwordInput.sendKeys(password);
            loginBtn.click();
        }
}
