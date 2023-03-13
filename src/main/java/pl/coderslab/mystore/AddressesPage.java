package pl.coderslab.mystore;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressesPage {
    private WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class=\"addresses-footer\"]/a")
    private WebElement addNewAddress;
    @FindBy(id = "field-alias")
    private WebElement aliasInput;
    @FindBy(id = "field-address1")
    private WebElement addressInput;
    @FindBy(id = "field-city")
    private WebElement cityInput;
    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;
    @FindBy(id = "field-phone")
    private WebElement phoneInput;
    @FindBy(id = "field-id_country")
    private WebElement countryChose;

    public void addNewAddress(String alias, String address, String city, String zipPostalCode, String country, String phone){
        addNewAddress.click();
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        postalCodeInput.sendKeys(zipPostalCode);
        Select select = new Select(countryChose);
        select.selectByVisibleText(country);
        phoneInput.sendKeys(phone);
        phoneInput.submit();
    }


    public String notificationCheck(){
        return driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText();
    }
    public void removeAddress(String alias) {
            driver.findElement(By.xpath("//div/h4[text()[contains(.,'" + alias + "')]]/../../div[2]/a[2]")).click();
    }
    public boolean addressCheck(String alias){
        List<WebElement> aliasExist = driver.findElements(By.xpath("//section[@id='content']/div/article/div/h4"));
        for (WebElement aliases : aliasExist){
            if(aliases.getText().trim().equals(alias)){
                return true;
            }
        }
        return false;
    }
}

