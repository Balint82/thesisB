package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

public class BillingDataPageTest extends BaseTest{

    @Test
    public void deleteBillingNameData() throws InterruptedException {
        writeFile.createSignUpDataFile();
        writeFile.writeToSignUpDataFile("seleniumtestera52@gmail.com","Richard Maven", "gemini");

        SignInPage signInPage = homePage.navigateToSignIn();
        SignedInHomePage signedInHomePage = signInPage.fillSignIn();
        MobilPage mobilPage = signedInHomePage.navigateToMobilPage();
        EbookPage ebookPage = mobilPage.navigateToEbookPage();
        OneEbookPage oneEbookPage = ebookPage.navigateToOneEbookPage();
        BillingPage billingPage = oneEbookPage.navigateToBillingPage();
        BillingDataPage billingDataPage = billingPage.navigateToBillingDataPage();

        billingDataPage.deleteBillingNameData();

        Assertions.assertTrue(billingDataPage.validateDeleteBillingNameData());
    }

    @Test
    public void rewriteBillingNameData() throws InterruptedException {
        SignInPage signInPage = homePage.navigateToSignIn();
        SignedInHomePage signedInHomePage = signInPage.fillSignIn();
        MobilPage mobilPage = signedInHomePage.navigateToMobilPage();
        EbookPage ebookPage = mobilPage.navigateToEbookPage();
        OneEbookPage oneEbookPage = ebookPage.navigateToOneEbookPage();
        BillingPage billingPage = oneEbookPage.navigateToBillingPage();
        BillingDataPage billingDataPage = billingPage.navigateToBillingDataPage();
        billingDataPage.deleteBillingNameData();
        String rewriteResult = billingDataPage.reWriteBillingNameData("Robert Selenium");

        Assertions.assertEquals("Robert Selenium",rewriteResult);
    }
}
