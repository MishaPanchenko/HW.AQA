package Testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {
    public ChromeDriver driver;
    public static final String ONLINE_REFILL_PATH = "//div[@class='pay__wrapper']//*[contains(text(), 'Онлайн пополнение ')]";
    public static final String DETAIL_SERVICE = "Подробнее о сервисе";
    public static final String PAY_BANK_CARD = "Оплата банковской картой";
    public static final String DETAIL_SERVICE_PATH = "//a[@href ='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']";
    public static final String PAY_BANK_CARD_PATH = "//div[@class = 'container-fluid']//*[contains(text(), 'Оплата банковской картой')]";
    public static final String CHECK_ONLINE_REFILL_TEXT = "Онлайн пополнение\n" +
            "без комиссии";


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\37544\\IdeaProjects\\MtsProject\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        WebElement button = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        button.click();
    }

    @Test
    public void testCommission() {
        WebElement element = driver.findElement(By.xpath(ONLINE_REFILL_PATH));
        String text = element.getText();
        assertTextForTest(CHECK_ONLINE_REFILL_TEXT, text);

    }

    @Test
    public void testContainsLogo() {
        WebElement text = driver.findElement(By.className("pay__partners"));

    }

    @Test
    public void linkDetailServiceTest() {
        WebElement link = driver.findElement(By.linkText(DETAIL_SERVICE));
        String textLink = link.getText();
        assertTextForTest(DETAIL_SERVICE, textLink);
        WebElement linkButton = driver.findElement(By.xpath(DETAIL_SERVICE_PATH));
        linkButton.click();
        WebElement elementPayBankCard = driver.findElement(By.xpath(PAY_BANK_CARD_PATH));
        assertTextForTest(PAY_BANK_CARD, elementPayBankCard.getText());

    }

    @Test
    public void checkFieldsAndContinue() {
        String tel = "297777777";
        WebElement fieldTel = driver.findElement(By.xpath("//input[@placeholder = 'Номер телефона']"));
        fieldTel.sendKeys(tel);

        WebElement fieldSum = driver.findElement(By.xpath("//input[@placeholder = 'Сумма']"));
        fieldSum.sendKeys("200");

        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id='connection-email']"));
        assertTextForTest("E-mail для отправки чека", fieldEmail.getAttribute("placeholder"));


        WebElement continueButton = driver.findElement(By.xpath("//button[text() = 'Продолжить']"));
        continueButton.click();

        waitUntilVisibilityOfElementLocated("//iframe[@class ='bepaid-iframe']", 10);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class ='bepaid-iframe']"));
        driver.switchTo().frame(iframe);

        waitUntilVisibilityOfElementLocated("//span[text() = '200.00 BYN']", 10);

        WebElement countSum = driver.findElement(By.xpath("//span[text() = '200.00 BYN']"));
        assertTextForTest("200.00 BYN", countSum.getText());

        WebElement numTel = driver.findElement(By.xpath("//span[contains (text(), '375" + tel + "')]"));
        assertTextForTest("Оплата: Услуги связи Номер:375" + tel, numTel.getText());

        WebElement cardNumber = driver.findElement(By.xpath("//*[@class='ng-tns-c45-1 ng-star-inserted']"));
        assertTextForTest("Номер карты", cardNumber.getText());

        WebElement validity = driver.findElement(By.xpath("//*[@class='ng-tns-c45-4 ng-star-inserted']"));
        assertTextForTest("Срок действия", validity.getText());

        WebElement cvcCode = driver.findElement(By.xpath("//*[@class='ng-tns-c45-5 ng-star-inserted']"));
        assertTextForTest("CVC", cvcCode.getText());

        WebElement name = driver.findElement(By.xpath("//*[@class='ng-tns-c45-3 ng-star-inserted']"));
        assertTextForTest("Имя держателя (как на карте)", name.getText());

        WebElement icons = driver.findElement(By.xpath("//*[@class='cards-brands cards-brands__container ng-tns-c60-0 ng-trigger ng-trigger-brandsState ng-star-inserted']"));

        WebElement buttonSum = driver.findElement(By.xpath("//button[contains(text(),' Оплатить  200.00 BYN ')]"));
        assertTextForTest("Оплатить 200.00 BYN", buttonSum.getText());
    }

    @Test
    public void checkFieldsHomeInternet() {
        WebElement button = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        button.click();
        WebElement button1 = driver.findElement(By.xpath("//p[contains(text(), 'Домашний интернет')]"));
        button1.click();
        waitUntilVisibilityOfElementLocated("//*[@id='internet-email']", 10);

        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id='internet-email']"));
        assertTextForTest("E-mail для отправки чека", fieldEmail.getAttribute("placeholder"));

        WebElement fieldTel = driver.findElement(By.xpath("//*[@id='internet-phone']"));
        assertTextForTest("Номер абонента", fieldTel.getAttribute("placeholder"));

        WebElement fieldSum = driver.findElement(By.xpath("//*[@id='internet-sum']"));
        assertTextForTest("Сумма", fieldSum.getAttribute("placeholder"));


    }

    @Test
    public void checkFieldInstallment() {
        WebElement button = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        button.click();
        WebElement button1 = driver.findElement(By.xpath("//p[contains(text(), 'Рассрочка')]"));
        button1.click();
        waitUntilVisibilityOfElementLocated("//*[@id='score-instalment']", 10);

        WebElement fieldAccNumber = driver.findElement(By.xpath("//*[@id='score-instalment']"));
        assertTextForTest("Номер счета на 44", fieldAccNumber.getAttribute("placeholder"));

        WebElement fieldSum = driver.findElement(By.xpath("//*[@id='instalment-sum']"));
        assertTextForTest("Сумма", fieldSum.getAttribute("placeholder"));

        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id='instalment-email']"));
        assertTextForTest("E-mail для отправки чека", fieldEmail.getAttribute("placeholder"));
    }


    @Test
    public void checkFieldDebt() {
        WebElement button = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        button.click();
        WebElement button1 = driver.findElement(By.xpath("//p[contains(text(), 'Задолженность')]"));
        button1.click();
        waitUntilVisibilityOfElementLocated("//*[@id='score-arrears']", 10);

        WebElement fieldAccNumber = driver.findElement(By.xpath("//*[@id='score-arrears']"));
        assertTextForTest("Номер счета на 2073", fieldAccNumber.getAttribute("placeholder"));

        WebElement fieldSum = driver.findElement(By.xpath("//*[@id='arrears-sum']"));
        assertTextForTest("Сумма", fieldSum.getAttribute("placeholder"));

        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id='arrears-email']"));
        assertTextForTest("E-mail для отправки чека", fieldEmail.getAttribute("placeholder"));
    }


    public void assertTextForTest(String expected, String actual) {
        assertEquals(expected, actual, "Результат найденного текста не соответствует ожидаемому" +
                "\nОжидаемый результат = " + expected +
                "\nФактичскй результат = " + actual);
    }

    public void waitUntilVisibilityOfElementLocated(String xpath, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

//    @After
//    public void quit() {
//        driver.quit();
//    }
}





