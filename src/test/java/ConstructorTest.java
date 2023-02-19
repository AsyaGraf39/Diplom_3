import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.MainPage;

import java.time.Duration;

import static data.Constants.*;
import static org.junit.Assert.assertEquals;

@DisplayName("Конструктор")
public class ConstructorTest {
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

    @DisplayName("Проверка перехода к разделу Булки")
    @Test
    public void checkGoToBunSection(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingSection();
        objMainPage.clickBunSection();
        String actualText = objMainPage.getBunHeader();

        assertEquals(HEADER_SECTION_BUN,actualText);

    }

    @DisplayName("Проверка перехода к разделу Соусы")
    @Test
    public void checkGoToSouseSection(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSouseSection();
        String actualText = objMainPage.getSouseHeader();

        assertEquals(HEADER_SECTION_SOUSE,actualText);
    }

    @DisplayName("Проверка перехода к разделу Начинки")
    @Test
    public void checkGoToFillingSection(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingSection();
        String actualText = objMainPage.getFillingHeader();

        assertEquals(HEADER_SECTION_FILLING,actualText);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
