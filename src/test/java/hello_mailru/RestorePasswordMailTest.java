package hello_mailru;

import hello_mailru.HomePage.LoginPage;
import hello_mailru.HomePage.MailPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestorePasswordMailTest extends WebdriverSetting{

    //private String userName;                           //Почтовый адрес для авторизации
    //private String userPassword;                                    //Пароль для авторизации
    private MailPage mailPage;
    private LoginPage loginPage;


    @Test(priority = 1)
    public void invalidCredentialsLogin(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mailPage = loginPage.login("dashenka.anisimova.2000", "Passw0rd");
        Assert.assertEquals( mailPage.getUserNAme(), "dashenka.anisimova.2000@mail.ru");
    }


    @Test(priority = 2)
    public void restorePassword() throws InterruptedException {
        String password = loginPage.restorePassword();
        Assert.assertTrue(password.contains("Вы ввели неправильный код с картинки"));
    }


}
