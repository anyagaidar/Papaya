package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    private WebDriver driver;
    private WebDriverWait wait;

     public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy(name = "q")
    WebElement searchfield;

    @FindBy(name = "btnK")
    WebElement searchBnt;

    @FindBy(id = "res")
    WebElement searchResult;

    public void searchFor(String input) {
        wait.until(ExpectedConditions.elementToBeClickable(searchfield));
        searchfield.sendKeys(input);
        wait.until(ExpectedConditions.elementToBeClickable(searchBnt));
        searchBnt.click();
    }

    public boolean isOnResultPage() {
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        if (searchResult.isDisplayed()) {
            return true;
        } else
            return false;
    }
}
