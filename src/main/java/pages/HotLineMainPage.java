package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotLineMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HotLineMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//*[@class=\"item-login\"]")
    private WebElement loginBtn;

    @FindBy(css = "#searchbox") //xpath = "//*[@id=\"searchbox\"]", //id = "searchbox"
    private WebElement searchBox;

    @FindBy(xpath = "//*[contains(text(), 'Каталог товарів')]/..")
    private WebElement booksFolder;

    @FindBy(css = "#page-index")
    private WebElement wholePage;

    public boolean isLoginFieldIsPresent() {
        return isWebElementIsDisplayed(loginBtn);
    }

    public boolean isWholePageOpened() {
        return isWebElementIsDisplayed(wholePage);
    }

    public boolean isBooksFolderPresents() {
        return isWebElementIsDisplayed(booksFolder);
    }

    public boolean isSearchBoxPresents() {
        return isWebElementIsDisplayed(searchBox);
    }
    private boolean isWebElementIsDisplayed(WebElement element) {
        if (element.isDisplayed())
            return true;
        return false;
    }
}
