import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Проверка формы авторизации (форма1)

public class TestOne {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ekaterinaklimova/Documents/chromedriver");
    }

    @Test
    public void loginTest() {
        User[] users = User.getUsers();

        for (User user : users) {
            driver = new ChromeDriver();
            driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
            Auth test1 = new Auth(driver);
            Boolean isAuth = test1.doAuth(user.login, user.password);
            Assert.assertEquals(isAuth, user.isCorrect);
            driver.quit();
        }

    }

}
