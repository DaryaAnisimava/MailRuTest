package hello_mailru;

import hello_mailru.HomePage.LoginPage;
import hello_mailru.HomePage.MailPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketCleaning extends WebdriverSetting {
    private String userName = "dashenka.anisimova.2000";                            //Почтовый адрес для авторизации
    private String userPassword = "19Mart2020";
    private String toUserName = "adel2425@tut.by";                                  //Почтовый адрес получателя
    private String themeOfMail = "Test";                                            //Тема письма
    private String bodyOfMail = "I sent you the test mail";
    private MailPage mailPage;
    private LoginPage loginPage;


    @Test(priority = 1)
    public void loginTest(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mailPage = loginPage.login(userName, userPassword);
        Assert.assertEquals("dashenka.anisimova.2000@mail.ru", mailPage.getUserNAme());

    }

    @Test(priority = 2)
    public void sentMail(){
        String result = mailPage.sentMail(toUserName, themeOfMail, bodyOfMail);
        Assert.assertTrue(result.contains("Письмо отправлено"));
    }

    @Test(priority = 3)
    public void removeMail(){
        String result = mailPage.removeMail();
        Assert.assertTrue(result.contains("В папке нет писем."));
    }

    @Test(priority = 4)
    public void cleanBasket(){
        String result = mailPage.cleanBasket();
        Assert.assertTrue(result.contains("В корзине пусто"));
    }



}
