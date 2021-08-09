package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


    private WebDriver driver;

    protected final By POPUP_CLOSER_CATCHER = By.xpath("//*[@id=\"wps_popup\"]/div/div[1]");
    private final By COOKIE_ACCEPT_BUTTON_CATCHER = By.id("CybotCookiebotDialogBodyButtonAccept");
    private final By SIGN_IN_BUTTON_CATCHER = By.xpath("//*[@id=\"main-header\"]/div[2]/div/div[1]/div[2]/ul/li[4]/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public SignInPage navigateToSignIn() {
        // handlePopUp();
        driver.get("https://edigital.hu/belepes");
        return new SignInPage(driver);
    }


    public void handlePopUp() {
        try {
            Thread.sleep(3000);
            WebElement popUpCloser = driver.findElement(POPUP_CLOSER_CATCHER);
            if (popUpCloser.isDisplayed()) {
                popUpCloser.click();
            }

        } catch (InterruptedException e) {
            System.out.println("I have not found Pop Up Window.");
        }
    }


    public void acceptCookies() {
        WebElement cookieButton = driver.findElement(COOKIE_ACCEPT_BUTTON_CATCHER);
        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

}
