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
import page_object.ProfilePage;

import java.time.Duration;

import static data.Constants.*;
import static org.junit.Assert.assertEquals;

@DisplayName("Личный кабинет")
public class ProfileTest {
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

        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        objMainPage.clickOnLoginBtn();
        objLoginPage.setEmail(objUserGenerator.getDefaultEmail())
                .setPassword(objUserGenerator.getPassword())
                .clickLoginBtn();
        objMainPage.clickProfileBtn();
    }

    @DisplayName("Проверка перехода в личный кабинет")
    @Test
    public void goToProfile(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        UserGenerator objUserGenerator = new UserGenerator();

        String actualText = objProfilePage.getProfileHeader();
        String actualName = objProfilePage.getNameUserProfile();

        assertEquals(HEADER_PROFILE_PAGE,actualText);
        assertEquals(objUserGenerator.getName(),actualName);
    }

    @DisplayName("Проверка перехода в конструктор по клику на «Конструктор»")
    @Test
    public void goToConstructorByClickConstructorBtn(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        MainPage objMainPage = new MainPage(driver);

        objProfilePage.clickConstructorBtn();
        String actualText = objMainPage.getMainHeader();

        assertEquals(HEADER_MAIN_PAGE,actualText);
    }

    @DisplayName("Проверка перехода в конструктор по клику на логотип Stellar Burgers")
    @Test
    public void goToConstructorByClickLogo(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        MainPage objMainPage = new MainPage(driver);

        objProfilePage.clickLogo();
        String actualText = objMainPage.getMainHeader();

        assertEquals(HEADER_MAIN_PAGE,actualText);
    }

    @DisplayName("Проверка успешного выхода из личного кабинета")
    @Test
    public void checkLogout(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        objProfilePage.clickLogoutBtn();
        String expectedText = "Войти";
        String actualText = objLoginPage.getTextLoginBtn();

        assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
