package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//article[@data-id-product=2]")
    private WebElement hummingBirdPrintedSweater;
    @FindBy(xpath = "//div[@class=\"user-info\"]/a/span")
    private WebElement signInButton;
    public void logIn(){
    signInButton.click();
    }

    public void hummingBirdPrintedSweater(){
    hummingBirdPrintedSweater.click();
    }
}
