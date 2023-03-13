package pl.coderslab.mystore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;


public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "qty")
    private WebElement ilosc;
    @FindBy(id = "group_1")
    private WebElement rozmiar;
    @FindBy(xpath = "//button[contains(@class,\"add-to-cart\")]")
    private WebElement addToCart;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closePopUp;
    @FindBy(xpath = "//div[@id=\"_desktop_cart\"]/div/div/a")
    private WebElement enterCart;
    @FindBy(className = "current-price-value")
    private WebElement discountedPriceElement;
    @FindBy(className = "regular-price")
    private WebElement regularPriceElement;
    public void addProduct(String size,String amount){
        Select select = new Select(rozmiar);
        select.selectByVisibleText(size);
        ilosc.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
        addToCart.click();
        closePopUp.click();
    }
    public void goToCart(){
        enterCart.click();
    };

}
