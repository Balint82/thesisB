package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


    private WebDriver driver;

    protected final By POPUP_CLOSER_CATCHER = By.xpath("//*[@id=\"wps_popup\"]/div/div[1]");
    private final By COOKIE_ACCEPT_BUTTON_CATCHER = By.id("CybotCookiebotDialogBodyButtonAccept");
    private final By SIGN_IN_BUTTON_CATCHER = By.xpath("//*[@id=\"main-header\"]/div[2]/div/div[1]/div[2]/ul/li[4]/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public SignInPage navigateToSignIn() {
        handlePopUp();
        WebElement signInButton = driver.findElement(SIGN_IN_BUTTON_CATCHER);
        signInButton.click();
        return new SignInPage(driver);
    }


    public void handlePopUp() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(POPUP_CLOSER_CATCHER)).click();
        } catch (TimeoutException e) {
            System.out.println("No PopUp");
        }
    }


    public void acceptCookies() {
        WebElement cookieButton = driver.findElement(COOKIE_ACCEPT_BUTTON_CATCHER);
        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

}
