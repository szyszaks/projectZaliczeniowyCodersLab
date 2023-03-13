package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
	@FindBy(id="addresses-link")
	private WebElement addresses;
    @FindBy(id="_desktop_logo")
    private WebElement logo;
    @FindBy(id="history-link")
    private WebElement orderHistory;
    public void enterAddresses(){
        addresses.click();
    }
    public void goMainPage(){
        logo.click();
    }
    public void goOrderHistory(){
        orderHistory.click();
    }

}
