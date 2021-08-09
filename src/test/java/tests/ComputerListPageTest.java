package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ComputerListPage;
import pages.SignInPage;
import pages.SignedInHomePage;

public class ComputerListPageTest extends BaseTest{

    @Test
    public void listComputers() {
        SignInPage signInPage = homePage.navigateToSignIn();
        SignedInHomePage signedInHomePage = signInPage.fillSignIn();

        ComputerListPage computerListPage = signedInHomePage.navigateToComputers();
        String computerResult = computerListPage.transferListComputersToString();
        Assertions.assertTrue(computerResult.contains("Intel"));
    }


    @Test
    public void listStepButtons() throws Exception {
        writeFile.createSignUpDataFile();
        writeFile.writeToSignUpDataFile("seleniumtestera52@gmail.com","Richard Maven", "gemini");

        // homepage.handlePopUp()

        SignInPage signInPage = homePage.navigateToSignIn();
        SignedInHomePage signedInHomePage = signInPage.fillSignIn();

        ComputerListPage computerListPage = signedInHomePage.navigateToComputers();
        String listRoaming = computerListPage.listStepButton();
        Assertions.assertTrue(listRoaming.contains("Cikkszám 337329"));
    }
}
