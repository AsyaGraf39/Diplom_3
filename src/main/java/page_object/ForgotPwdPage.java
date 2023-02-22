package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPwdPage {
    private WebDriver driver;

    private By loginBtn = By.xpath("//a[text()='Войти']");

    public ForgotPwdPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Войти")
    public ForgotPwdPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }
}
