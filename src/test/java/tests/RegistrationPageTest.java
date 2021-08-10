package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.WriteFile;


public class RegistrationPageTest extends BaseTest {


    @Test
    public void fillRegister() {
        writeFile.createSignUpDataFile();
        writeFile.writeToSignUpDataFile("seleniumtestera52@gmail.com","Richard Maven", "gemini");

        homePage.handlePopUp();
        homePage.acceptCookies();

        signInPage = homePage.navigateToSignIn();
        registrationPage = signInPage.navigateToRegistration();


        registrationPage.fillEmail();
        registrationPage.fillName();
        registrationPage.fillPassword();

        registrationPage.markCheckBox();
        registrationPage.clickRegButton();

        String result = registrationPage.validateRegistration();
        Assertions.assertEquals("Ez az email cím már használatban van!", result);
    }

}
