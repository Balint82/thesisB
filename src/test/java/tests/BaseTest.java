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

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);

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
