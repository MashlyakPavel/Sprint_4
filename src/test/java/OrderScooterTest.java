import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.MainPage;

public class OrderScooterTests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testOrderScooterFromTopButton() {
        mainPage.clickOrderButtonTop();
        mainPage.fillOrderForm("Иван", "Иванов", "ул. Ленина, д. 1, кв. 1", "Чистые пруды", "+79991234567");
        Assert.assertTrue(mainPage.isSuccessModalDisplayed());
    }

    @Test
    public void testOrderScooterFromBottomButton() {
        mainPage.clickOrderButtonBottom();
        mainPage.fillOrderForm("Анна", "Петрова", "ул. Гагарина, д. 2, кв. 2", "Павелецкая", "+79997654321");
        Assert.assertTrue(mainPage.isSuccessModalDisplayed());
    }

    @Test
    public void testFaqTextToggle() {
        mainPage.toggleFaqText();
        Assert.assertTrue(!mainPage.getFaqText().isEmpty());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}