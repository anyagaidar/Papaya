package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotLineLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HotLineLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 120);
    }
    @FindBy(xpath = "//*[@class=\"item-login\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@class=\"field m_b-sm\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@class=\"field\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class=\"item-error\"]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@class=\"btn-graphite btn-cell\"]")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"rc-imageselect\"]")
    private WebElement captcha;

    @FindBy(xpath = "//*[contains(text(), 'AnnaGd')]/..")
    private WebElement currentUser;

    public void pressLoginBtn() {
        loginBtn.click();
    }

    public void inputLogin(String login) {
        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys(login);
    }

    public void inputIncorrectLogin(String incorrectLogin) {
        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys(incorrectLogin);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void pressSubmitBtn() {
        submitBtn.click();
    }

    public boolean isErrorMsgIsShown() {
        wait.until(ExpectedConditions.visibilityOf(captcha));
        if (errorMessage.isDisplayed() || captcha.isDisplayed())
            return true;
        return false;
    }

    public boolean isUserGetLogined() {
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        if (currentUser.isDisplayed())
            return true;
        return false;
    }
}
