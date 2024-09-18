import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

private WebDriver driver;

public MainPage(WebDriver driver) {
    this.driver = driver;
}
private By pageTitle = By.className("Header_Logo__2xJNY"); // Заголовок страницы
private By orderButtonTop = By.className("Button_Button__ra12g"); // Кнопка "Заказать" вверху страницы
private By orderButtonBottom = By.className("Button_UltraBig__UU3Lp"); // Кнопка "Заказать" внизу страницы
private By orderForm = By.className("Order_Content__bmtHS"); // Форма заказа
private By nameField = By.xpath("//input[@placeholder='* Имя']"); // Поле "Имя"
private By surnameField = By.xpath("//input[@placeholder='* Фамилия']"); // Поле "Фамилия"
private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле "Адрес: куда привезти заказ"
private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']"); // Поле "Станция метро"
private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Поле "Телефон"
private By nextButton = By.className("Button_Middle__1CSJM"); // Кнопка "Далее"
private By successModal = By.className("Order_ModalHeader__3FDaL"); // Всплывающее окно с сообщением об успешном создании заказа
private By faqText = By.className("accordion__panel"); // Текст в разделе "Вопросы о важном"
private By faqToggle = By.className("accordion__button"); // Стрелка для раскрытия/скрытия текста в разделе "Вопросы о важном"
public void clickOrderButtonTop() { // Методы для взаимодействия с элементами
    driver.findElement(orderButtonTop).click();
}

public void clickOrderButtonBottom() {
    driver.findElement(orderButtonBottom).click();
}

public void fillOrderForm(String name, String surname, String address, String metroStation, String phone) {
    driver.findElement(nameField).sendKeys(name);
    driver.findElement(surnameField).sendKeys(surname);
    driver.findElement(addressField).sendKeys(address);
    driver.findElement(metroStationField).sendKeys(metroStation);
    driver.findElement(phoneField).sendKeys(phone);
    driver.findElement(nextButton).click();
}

public boolean isSuccessModalDisplayed() {
    return driver.findElement(successModal).isDisplayed();
}

public void toggleFaqText() {
    driver.findElement(faqToggle).click();
}

public String getFaqText() {
    return driver.findElement(faqText).getText();
}
}
