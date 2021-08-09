package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import tools.WriteDataFile;
import tools.WriteFile;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    public HomePage homePage;
    protected SignInPage signInPage;
    protected RegistrationPage registrationPage;
    protected WriteFile writeFile = new WriteFile();
    protected WriteDataFile writeDataFile = new WriteDataFile();

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        driver = new ChromeDriver(option);

        driver.get("http://edigital.hu");
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    /*@AfterEach
    public void closeTest() {
        driver.close();
    }*/

}
