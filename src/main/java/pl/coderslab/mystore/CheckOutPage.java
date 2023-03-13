package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@name=\"confirm-addresses\"]")
    private WebElement addressContinueButton;
    @FindBy(xpath = "//input[@id='delivery_option_1']/../span")
    private WebElement pickUpInStoreSelect;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement shippingContinueButton;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckSelect;
    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement tosCheckbox;
    @FindBy(xpath = "//div[@id=\"payment-confirmation\"]/div/button")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//section[@id='content']")
    private WebElement orderConfirmationSectionScr;
    @FindBy(xpath = "//*[@id=\"order-items\"]/div[2]/div/div[3]/div/div[3]")
    private WebElement orderCost;
    @FindBy(id = "order-reference-value")
    private WebElement orderNumber;
    public void address(){
        addressContinueButton.click();
    }
    public void shipmentPickUp(){
        pickUpInStoreSelect.click();
        shippingContinueButton.click();
    }
    public void paymentByCheck(){
        payByCheckSelect.click();
        tosCheckbox.click();
        placeOrderButton.click();
    }
    public void makeScreen() throws IOException {
        Screenshot screenshotOrder = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver,orderConfirmationSectionScr);
        ImageIO.write(screenshotOrder.getImage(),"png",new File("report/screens/PotwierdzenieZamówienia.jpeg"));
    }
    public String returnOrderPrice(){
        return orderCost.getText();
    }
    public String returnOrderNumber(){
        return orderNumber.getText().replace("Order reference: ","");
    }

}
