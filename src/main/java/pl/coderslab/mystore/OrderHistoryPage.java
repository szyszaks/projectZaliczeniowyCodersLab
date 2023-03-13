package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    private WebDriver driver;


    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private WebElement historyRecord;

    public void setHistoryRecord(String orderNumber){
        historyRecord = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr/th[text()[contains(.,"+ orderNumber +")]]"));
    }
    public String historyPrice(){
     return historyRecord.findElement(By.xpath("following-sibling::td[2]")).getText();
    }
    public String historyStatus(){
        return historyRecord.findElement(By.xpath("following-sibling::td[4]/span")).getText();
    }
}
