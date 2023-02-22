import data.UserGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegistrationPage;

import java.time.Duration;

import static data.Constants.REGISTER_INVALID_PWD;
import static org.junit.Assert.assertEquals;

@DisplayName("Регистрация")
public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//      YandexBrowser
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\agraf\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @DisplayName("Проверка успешной регистрации")
    @Test
    public void checkSuccessfulRegistration(){
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickProfileBtn();
        objLoginPage.clickRegistrationBtn();
        objRegistrationPage.setName(objUserGenerator.getName())
                .setEmail(objUserGenerator.getRandomEmail())
                .setPassword(objUserGenerator.getPassword())
                .clickRegistrationBtn();

        String expectedText = "Войти";
        String actualText = objLoginPage.getTextLoginBtn();

        assertEquals("Переход на страницу входа не произошел", expectedText,actualText);
    }

    @DisplayName("Проверка регистрации с некорректным паролем")
    @Test
    public void checkRegistrationWithInvalidPwd(){
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickProfileBtn();
        objLoginPage.clickRegistrationBtn();
        objRegistrationPage.setName(objUserGenerator.getName())
                .setEmail(objUserGenerator.getRandomEmail())
                .setPassword(objUserGenerator.getWrongPassword())
                .clickRegistrationBtn();

        String actualText = objRegistrationPage.getTextError();

        assertEquals(REGISTER_INVALID_PWD,actualText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
