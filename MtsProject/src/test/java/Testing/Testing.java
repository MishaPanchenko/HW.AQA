package Testing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;

public class Testing {
    public ChromeDriver driver;
    public WebDriverWait wait;
    public static final String ONLINE_REFILL_PATH = "//div[@class='pay__wrapper']//*[contains(text(), 'Онлайн пополнение ')]";
    public static final String DETAIL_SERVICE = "Подробнее о сервисе";
    public static final String PAY_BANK_CARD = "Оплата банковской картой";
    public static final String DETAIL_SERVICE_PATH = "//a[@href ='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']";
    public static final String PAY_BANK_CARD_PATH = "//div[@class = 'container-fluid']//*[contains(text(), 'Оплата банковской картой')]";
    public static final String CHECK_ONLINE_REFILL_TEXT = "Онлайн пополнение\n" +
            "без комиссии";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\37544\\IdeaProjects\\MtsProject\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

        WebElement continueButton = driver.findElement(By.xpath("//button[text() = 'Продолжить']"));
        continueButton.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class ='bepaid-iframe']")));

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class ='bepaid-iframe']"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = '200.00 BYN']")));

        WebElement countSum = driver.findElement(By.xpath("//span[text() = '200.00 BYN']"));
        assertTextForTest("200.00 BYN", countSum.getText());

        WebElement numTel = driver.findElement(By.xpath("//span[contains (text(), '375" + tel + "')]"));
        assertTextForTest("Оплата: Услуги связи Номер:375" + tel, numTel.getText());


    }

    public void assertTextForTest(String expected, String actual) {
        Assert.assertEquals("Результат найденного текста не соответствует ожидаемому" +
                        "\nОжидаемый результат = " + expected +
                        "\nФактичскй результат = " + actual,
                expected, actual);
    }

//    @After
//    public void quit() {
//        driver.quit();
//    }
}





