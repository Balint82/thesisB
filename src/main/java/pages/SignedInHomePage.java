package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignedInHomePage {


    private WebDriver driver;

    private final By SEARCHBAR_CATCHER = By.id("product_search");
    private final By CART_CATCHER = By.id("header-cart-icon");
    private final By ACCOUNT_LOGO_CATCHER = By.xpath("//*[@id=\"main-header\"]/div[2]/div/div[1]/div[2]/ul/li[6]/a");
    private final By LOG_OUT_CATCHER = By.xpath("//*[@id=\"main-header\"]/div[2]/div/div[1]/div[2]/ul/li[6]/ul/li[2]/a");
    private final By LOG_OUT_VALIDATOR = By.xpath("//*[@id=\"main-header\"]/div[2]/div/div[1]/div[2]/ul/li[4]/a");
    private final By MOBIL_MENU_ELEMENT_CATCHER = By.xpath("//*[@id=\"8481401\"]/div/div/p[1]/a");



    public SignedInHomePage(WebDriver driver) {
        this.driver = driver;
    }



    public ComputerListPage navigateToComputers() {
        HomePage homePage = new HomePage(driver);
        // homePage.handlePopUp();

        WebElement searchBar = driver.findElement(SEARCHBAR_CATCHER);
        searchBar.sendKeys("számítógép");
        searchBar.sendKeys(Keys.RETURN);
        return new ComputerListPage(driver);
    }


    public MobilPage navigateToMobilPage() {
        WebElement mobilMenuElement = driver.findElement(MOBIL_MENU_ELEMENT_CATCHER);
        mobilMenuElement.click();
        return new MobilPage(driver);
    }


    public Boolean validateIncoming() {
        WebElement cart = driver.findElement(CART_CATCHER);
        if (cart.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }


    public void logOut(){
        WebElement accountLogo = driver.findElement(ACCOUNT_LOGO_CATCHER);
        WebElement logOut = driver.findElement(LOG_OUT_CATCHER);

        accountLogo.click();
        logOut.click();
    }


    public Boolean validateLogout() {
        WebElement logOutValidator = driver.findElement(LOG_OUT_VALIDATOR);
        if (logOutValidator.getText().contains("Bejelentkezés")) {
            return true;
        } else {
            return false;
        }
    }


}
