package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;
    private By profileBtn = By.xpath("//a[text()='Профиль']");
    private By nameField = By.xpath(".//label[text()='Имя']//following::input[1]");
    private By logoutBtn = By.xpath("//button[text()='Выход']");
    private By constructorBtn = By.xpath("//p[text()='Конструктор']");
    private By logo = By.xpath("//div[contains(@class,'AppHeader_header__logo')]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getProfileHeader(){
        return driver.findElement(profileBtn).getText();
    }
    public String getNameUserProfile(){
        return driver.findElement(nameField).getAttribute("value");
    }
    public ProfilePage clickConstructorBtn(){
        driver.findElement(constructorBtn).click();
        return this;
    }
    public ProfilePage clickLogo(){
        driver.findElement(logo).click();
        return this;
    }
    public ProfilePage clickLogoutBtn(){
        driver.findElement(logoutBtn).click();
        return this;
    }
}
