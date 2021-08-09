package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerListPage {


    private WebDriver driver;

    private final By COMPUTER_LIST_CATCHER = By.xpath("//*[@id=\"prefixbox-search-engine\"]/div[2]/div");
    private final By STEP_BUTTON_CATCHER = By.xpath("//*[@id=\"paginator\"]/div/button");
    private final By BODY_COOKIE_ACCEPT_CATCHER = By.id("CybotCookiebotDialogBodyButtonAccept");



    public ComputerListPage(WebDriver driver) {
        this.driver = driver;
    }



    public List<String> listComputers() {
        List<WebElement> computerList = driver.findElements(COMPUTER_LIST_CATCHER);
        List<String> result = new ArrayList<>();

        for (WebElement computerItem : computerList) {
            computerItem.findElement(By.xpath("./li/div"));
            String computerData = computerItem.getText();
            result.add(computerData);
        }

        return result;
    }


    public String transferListComputersToString() {
        List<String> computerDataList = listComputers();
        String computerDaraString= computerDataList.stream().map(Object::toString).collect(Collectors.joining(""));

        return computerDaraString;
    }


    public String listStepButton() throws Exception {
        HomePage homePage = new HomePage(driver);
        String result = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> stepButtonList = driver.findElements(STEP_BUTTON_CATCHER);

        for (WebElement stepButtonElement : stepButtonList) {
            result = result + transferListComputersToString();
            handleBodyCookie();
            homePage.handlePopUp();
            js.executeScript("window.scrollBy(0,1800)");
            stepButtonElement.click();
            Thread.sleep(5000);
        }

        return result;
    }



    public void handleBodyCookie() {
        WebElement bodyCookieAcceptButton = driver.findElement(BODY_COOKIE_ACCEPT_CATCHER);

        if (bodyCookieAcceptButton.isDisplayed()) {
        bodyCookieAcceptButton.click();}
    }

}

