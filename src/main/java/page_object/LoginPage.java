package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By registrationBtn = By.xpath("//a[text()='Зарегистрироваться']");
    private By loginBtn = By.xpath("//button[text()='Войти']");
    private By emailField = By.xpath("//label[text()='Email']//following::input[1]");
    private By passwordField = By.xpath("//input[@type='password']");
    private By forgotPasswordBtn = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на страницу регистрации")
    public LoginPage clickRegistrationBtn(){
        driver.findElement(registrationBtn).click();
        return this;
    }
    public String getTextLoginBtn(){
        return driver.findElement(loginBtn).getText();
    }

    @Step("Ввод почты")
    public LoginPage setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку Войти")
    public LoginPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Нажатие на кнопку Восстановить пароль")
    public LoginPage clickForgotPasswordBtn(){
        driver.findElement(forgotPasswordBtn).click();
        return this;
    }
}
