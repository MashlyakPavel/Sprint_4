iimport org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.PageOrder;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterTest {

    private WebDriver driver;
    private WebDriver driver;
    private MainPage mainPage;
    // Параметры теста
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public int metro;
    @Parameterized.Parameter(4)
    public String phoneNumber;
    @Parameterized.Parameter(5)
    public String color;
    @Parameterized.Parameter(6)
    public String date;
    @Parameterized.Parameter(7)
    public int rentalDays;
    @Parameterized.Parameter(8)
    public String comment;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }
    // Закрытие баннера с cookie, если он есть
        pageOrder.closeCookieBanner();
}

// Нажатие на верхнюю кнопку "Заказать"
@Test
public void testOrderScooterThroughHeaderButton() {
    pageOrder.clickOrderButtonHeader();
    pageOrder.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);
    pageOrder.enterDataSecondPageOrder(color, date, rentalDays, comment);
    assertTrue(pageOrder.successfullyText());
}

//для заказа по нижней кнопке:
@Test
public void testOrderScooterThroughDownButton() {
    pageOrder.scrollPageOrder(); // Скролим страницу
    pageOrder.clickOrderButtonDown(); // Нажатие на нижнюю кнопку "Заказать"
    pageOrder.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);
    pageOrder.enterDataSecondPageOrder(color, date, rentalDays, comment);
    assertTrue(pageOrder.successfullyText());
}

@After
public void teardown() {
    driver.quit();
}
}
@Parameterized.Parameters
public static Collection<Object[]> testData() {
    return Arrays.asList(new Object[][]{
            {"Анна", "Петрова", "ул.Гагарина, д. 2, кв.2" , "Павелецкая", "+79997654321"},
            {"Иван", "Иванов", "ул.Ленина, д. 1, кв.1" , "Чистые пруды", "+79991234567"}
    });
}
}