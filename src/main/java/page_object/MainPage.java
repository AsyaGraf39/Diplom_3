package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By profileBtn = By.xpath(".//p[text()='Личный Кабинет']");
    private By loginBtn = By.xpath(".//button[text()='Войти в аккаунт']");
    private By mainHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private By bunSection = By.xpath(".//span[text()='Булки']");
    private By bunSectionHeader = By.xpath(".//h2[text()='Булки']");
    private By souseSection = By.xpath(".//span[text()='Соусы']");
    private By souseSectionHeader = By.xpath(".//h2[text()='Соусы']");
    private By fillingSection = By.xpath(".//span[text()='Начинки']");
    private By fillingSectionHeader = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход по кнопке Личный кабинет")
    public MainPage clickProfileBtn(){
        driver.findElement(profileBtn).click();
        return this;
    }

    @Step("Кнопка входа")
    public MainPage clickOnLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Получение заголовка главной страницы")
    public String getMainHeader(){
        return driver.findElement(mainHeader).getText();
    }

    @Step("Раздел Булки")
    public MainPage clickBunSection(){
        driver.findElement(bunSection).click();
        return this;
    }

    @Step("Раздел Соусы")
    public MainPage clickSouseSection(){
        driver.findElement(souseSection).click();
        return this;
    }

    @Step("Раздел Начинки")
    public MainPage clickFillingSection(){
        driver.findElement(fillingSection).click();
        return this;
    }

    @Step("Заголовок раздела Булки")
    public String getBunHeader(){
        return driver.findElement(bunSectionHeader).getText();
    }

    @Step("Заголовок раздела Соусы")
    public String getSouseHeader(){
        return driver.findElement(souseSectionHeader).getText();
    }

    @Step("Заголовок раздела Начинки")
    public String getFillingHeader(){
        return driver.findElement(fillingSectionHeader).getText();
    }
}
