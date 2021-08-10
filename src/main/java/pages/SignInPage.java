package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {


    private WebDriver driver;

    private RegistrationPage registrationPage = new RegistrationPage(driver);
    private final By REGIST_BUTTON_CATCHER = By.xpath("//*[@id=\"main-content\"]/div/div[1]/a"); //*[@id="login"]

    private final By EMAIL_FIELD_CATCHER = By.id("username");
    private final By PASSWORD_FIELD_CATCHER = By.id("password");
    private final By SIGN_IN_BUTTON_CATCHER = By.xpath("//*[@id=\"login\"]"); //*[@id="login"]



    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }



    public RegistrationPage navigateToRegistration() {
        WebElement registButton = driver.findElement(REGIST_BUTTON_CATCHER);
        registButton.click();
        return new RegistrationPage(driver);
    }


    public SignedInHomePage fillSignIn() {
        WebElement emailField = driver.findElement(EMAIL_FIELD_CATCHER);
        emailField.sendKeys(registrationPage.emailData);
        WebElement passwordField = driver.findElement(PASSWORD_FIELD_CATCHER);
        passwordField.sendKeys(registrationPage.passwordData);
        WebElement signInButton = driver.findElement(SIGN_IN_BUTTON_CATCHER);
        signInButton.click();
        return new SignedInHomePage(driver);
    }


}
