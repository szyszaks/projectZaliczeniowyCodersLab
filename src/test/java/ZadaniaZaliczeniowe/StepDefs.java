package ZadaniaZaliczeniowe;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;

public class StepDefs {
    private WebDriver driver;
    @After
    public void cleanup(){driver.quit();}
    public String orderNumber;
    public String orderPrice;


    @Given("browser with my store site open up")
    public void setup() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }
    @And("logged user {} with password {}")
    public void logIn(String email,String password){
        MainPage mainPage = new MainPage(driver);
        mainPage.logIn();
        LogInPage loginPage = new LogInPage(driver);
        loginPage.signIn(email, password);
        AccountPage accountPage = new AccountPage(driver);
        accountPage.enterAddresses();
    }
    @When("user adds new address {}, {}, {}, {}, {}, {}")
    public void addAddress(String alias, String address, String city, String postalCode,String country, String phone){

        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.addNewAddress(alias,address,city,postalCode,country,phone);
    }
    @Then("address {} is added")

    public void addedAddressCheck(String alias){
        AddressesPage addressesPage= new AddressesPage(driver);
        Assert.assertTrue(addressesPage.addressCheck(alias));
//    Assert.assertEquals("Address successfully added!",addressesPage.notificationCheck());
    }

    @And("logged user with added addresses email {}  password {}")
    public void userIsLoggedInAndAddressAdded(String email,String password){
        MainPage mainPage = new MainPage(driver);
        mainPage.logIn();
        LogInPage loginPage = new LogInPage(driver);
        loginPage.signIn(email, password);

    }


    @When("user remove address {}")
    public void removeAddress(String alias) {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.enterAddresses();
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.removeAddress(alias);
    }

    @Then("address {} is removed")
    public void addressIsRemoved(String alias) {
        AddressesPage addressesPage= new AddressesPage(driver);
//        Assert.assertEquals("Address successfully deleted!",addressesPage.notificationCheck());
        Assert.assertFalse(addressesPage.addressCheck(alias));
    }

    @When("user enter product page")
    public void userAddsHummingbirdPrintedSweaterToCart() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goMainPage();
        MainPage mainPage = new MainPage(driver);
        mainPage.hummingBirdPrintedSweater();

    }

    @And("chooses size {}, pick amount of {} and add them to cart")
    public void choosesSizeMPickAmountOfAndAddThemToCart(String size, String amount) throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.addProduct(size,amount);
    }

    @And("proceed thought checkout process")
    public void proceedThoughtCheckoutProcess() {
        ProductPage productPage = new ProductPage(driver);
        productPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.address();
        checkOutPage.shipmentPickUp();
        checkOutPage.paymentByCheck();
        orderNumber = checkOutPage.returnOrderNumber();
        orderPrice = checkOutPage.returnOrderPrice();
    }

    @Then("make screenshot of order")
    public void makeScreenshotOfOrder() throws IOException {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.makeScreen();
    }


    @And("confirms order have correct values on acc order history")
    public void verificationOfData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.logIn();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goOrderHistory();
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.setHistoryRecord(orderNumber);
        Assert.assertEquals(orderPrice,orderHistoryPage.historyPrice());
        Assert.assertEquals("Awaiting check payment",orderHistoryPage.historyStatus());
    }
}
