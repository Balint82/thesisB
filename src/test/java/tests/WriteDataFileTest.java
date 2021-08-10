package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ComputerListPage;
import pages.SignInPage;
import pages.SignedInHomePage;
import tools.ReadSavedDataFile;

public class WriteDataFileTest extends BaseTest {


    @Test
    public void saveData() {
        writeFile.createSignUpDataFile();
        writeFile.writeToSignUpDataFile("seleniumtestera52@gmail.com","Richard Maven", "gemini");

        SignInPage signInPage = homePage.navigateToSignIn();
        SignedInHomePage signedInHomePage = signInPage.fillSignIn();

        ComputerListPage computerListPage = signedInHomePage.navigateToComputers();
        String computerResult = computerListPage.transferListComputersToString();
        System.out.println(computerResult);

        writeDataFile.createSavedDataFile();
        writeDataFile.writeToSavedDataFile(computerResult);

        ReadSavedDataFile readSavedDataFile = new ReadSavedDataFile();
        String saved = readSavedDataFile.readSavedData();
        System.out.println(saved);
        Assertions.assertTrue(saved.contains("Intel"));
    }
}
