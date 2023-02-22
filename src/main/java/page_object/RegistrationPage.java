package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    private By nameField = By.xpath(".//label[text()='Имя']//following::input[1]");
    private By emailField = By.xpath(".//label[text()='Email']//following::input[1]");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By registrationBtn = By.xpath(".//button[text()='Зарегистрироваться']");
    private By registrationError = By.xpath(".//p[contains(@class, 'input__error')]");
    private By loginBtn = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод имени")
    public RegistrationPage setName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    @Step("Ввод почты")
    public RegistrationPage setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public RegistrationPage setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку зарегистрироваться")
    public RegistrationPage clickRegistrationBtn(){
        driver.findElement(registrationBtn).click();
        return this;
    }

    @Step("Ошибка невалидного пароля")
    public String getTextError(){
        return driver.findElement(registrationError).getText();
    }

    @Step("Нажатие на кнопку входа")
    public RegistrationPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }
}
