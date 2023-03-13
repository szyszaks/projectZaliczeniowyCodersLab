package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    private WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "field-email")
    private WebElement fieldEmail;
    @FindBy(id = "field-password")
    private  WebElement fieldPassword;
    @FindBy(id = "submit-login")
    private WebElement signInButton;
    public void signIn(String email, String password){
    fieldEmail.sendKeys(email);
    fieldPassword.sendKeys(password);
    signInButton.click();
    }

}
