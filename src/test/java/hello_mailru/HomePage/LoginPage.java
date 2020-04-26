package hello_mailru.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginPage {
    private final WebDriver driver;
    WebDriverWait wait;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);

    }

    @FindBy(id = "mailbox:login")
    WebElement loginField;

    @FindBy(id = "mailbox:password")
    WebElement passwordField;

    @FindBy(id = "mailbox:submit")
    WebElement submitButton;

    public MailPage login(String user, String password) {
        loginField.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        passwordField.sendKeys(password);
        submitButton.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.urlContains("e.mail.ru"));
        return new MailPage(driver);

    }

    public String restorePassword () throws InterruptedException {
        driver.findElement(By.id("restore")).click();
        Thread.sleep(2000);
        //driver.switchTo().defaultContent();
        //driver.switchTo().frame(driver.findElement(By.xpath("//*[@href='https://account.mail.ru/recovery/support?email=dashenka.anisimova.2000%40mail.ru']")));
        //wait.until(ExpectedConditions.urlContains("account.mail.ru/recovery"));
        driver.findElement(By.xpath("//*[@class='b-input b-input_responsive b-input_wide'][@tabindex='1']")).sendKeys("Дарья");
        driver.findElement(By.xpath("//*[@class='b-input b-input_responsive b-input_wide'][@tabindex='2']")).sendKeys("Анисимова");
        driver.findElement(By.xpath("//*[@id='birthdate_51']/div[2]/div[1]")).sendKeys("9");
        driver.findElement(By.xpath("//*[@id='birthdate_51']/div[2]/div[2]")).sendKeys("Февраль");
        driver.findElement(By.xpath("//*[@id='birthdate_51']/div[2]/div[3]")).sendKeys("1993");
        driver.findElement(By.xpath("//div[@class='b-password b-password_responsive b-password_compact b-password_popup b-password_responsive b-password_service b-password_control-width-50 b-password_popup b-password_compact ']")).sendKeys("19Mart2020");
        driver.findElement(By.xpath("//div[@class='b-dropdown b-dropdown_responsive b-dropdown_compact b-dropdown_auto-size-list b-dropdown_service b-dropdown_control-width-50 b-dropdown_popup'][@tabindex='5']")).click();
        driver.findElement(By.xpath("//span[text()='Менее 3 месяцев назад']")).click();
        driver.findElement(By.xpath("//div[@class='b-dropdown b-dropdown_responsive b-dropdown_compact b-dropdown_auto-size-list b-dropdown_service b-dropdown_control-width-50 b-dropdown_popup'][@tabindex='6']")).click();
        driver.findElement(By.xpath("//span[text()='Девичья фамилия матери']")).click();
        driver.findElement(By.xpath("//input[@class='b-input b-input_responsive b-input_wide'][@tabindex='7']")).sendKeys("Кравец");
        driver.findElement(By.xpath("//input[@class='b-input b-input_responsive b-input_wide'][@tabindex='8']")).sendKeys("adel2425@tut.by");
        driver.findElement(By.xpath("//input[@class='b-input b-input_captcha b-input_responsive'][@tabindex='9']")).sendKeys("TGf796HR");
        driver.findElement(By.xpath("//button[@class='btn btn_main btn_stylish btn_responsive ']"));
        return driver.findElement(By.xpath("//*[@class=b-captcha__error-msg']")).getText();
    }
}


