import data.UserGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.ForgotPwdPage;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegistrationPage;

import java.time.Duration;

import static data.Constants.HEADER_MAIN_PAGE;
import static org.junit.Assert.assertEquals;

@DisplayName("Авторизация")
public class LoginTest {
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

    @DisplayName("Проверка успешной авторизации по кнопке \"Войти в аккаунт\" на главной")
    @Test
    public void checkLoginBtnMainPage(){
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickOnLoginBtn();
        objLoginPage.setEmail(objUserGenerator.getDefaultEmail())
                .setPassword(objUserGenerator.getPassword())
                .clickLoginBtn();

        String actualText = objMainPage.getMainHeader();

        assertEquals(HEADER_MAIN_PAGE,actualText);

    }

    @DisplayName("Проверка успешной авторизации через кнопку \"Личный кабинет\"")
    @Test
    public void checkLoginProfileBtn(){
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickProfileBtn();
        objLoginPage.setEmail(objUserGenerator.getDefaultEmail())
                .setPassword(objUserGenerator.getPassword())
                .clickLoginBtn();

        String actualText = objMainPage.getMainHeader();

        assertEquals(HEADER_MAIN_PAGE,actualText);
    }

    @DisplayName("Проверка успешной авторизации через кнопку в форме регистрации")
    @Test
    public void checkLoginRegistrationPage(){
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickProfileBtn();
        objLoginPage.clickRegistrationBtn();
        objRegistrationPage.clickLoginBtn();
        objLoginPage.setEmail(objUserGenerator.getDefaultEmail())
                .setPassword(objUserGenerator.getPassword())
                .clickLoginBtn();

        String actualText = objMainPage.getMainHeader();

        assertEquals(HEADER_MAIN_PAGE,actualText);
    }

    @DisplayName("Проверка успешной авторизации через кнопку в форме восстановления пароля")
    @Test
    public void checkLoginUsingLnkOnTheForgotPasswordPage(){
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ForgotPwdPage objForgotPwdPage = new ForgotPwdPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickOnLoginBtn();
        objLoginPage.clickForgotPasswordBtn();
        objForgotPwdPage.clickLoginBtn();
        objLoginPage.setEmail(objUserGenerator.getDefaultEmail())
                .setPassword(objUserGenerator.getPassword())
                .clickLoginBtn();

        String actualText = objMainPage.getMainHeader();

        assertEquals(HEADER_MAIN_PAGE,actualText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
