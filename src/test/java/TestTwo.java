import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//проверки на форму регистрации (форма 2)

public class TestTwo {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ekaterinaklimova/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    //проверка обязательности заполнения email
    @Test
    public void testEmail() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration email = new Registration(driver);
        email.SetEmail("");
        email.Click();
        boolean isError = driver.findElement(By.id("emailFormatError")).isDisplayed();
        Assert.assertTrue(isError);
    }

    //проверка формата заполнения email
    @Test
    public void testEmail2() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration email = new Registration(driver);
        email.SetEmail("mtest.ru");
        email.Click();
        boolean isError = driver.findElement(By.id("emailFormatError")).isDisplayed();
        Assert.assertTrue(isError);
    }

    //проверка обязательности заполнения поля Имя
    @Test
    public void testName() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("");
        name.Click();
        boolean isError = driver.findElement(By.xpath("//*[@id=\"blankNameError\"]")).isDisplayed();
        Assert.assertTrue(isError);
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Женский, Оба чек-бокса выбраны, Выбран радиобаттон Вариант 2.1
    @Test
    public void testForm1() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Женский");
        name.SetVar11();
        name.SetVar12();
        name.SetVar21();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Женский", "1.1, 1.2", "2.1");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Женский, Оба чек-бокса НЕ выбраны, Выбран радиобаттон Вариант 2.2
    @Test
    public void testForm2() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Женский");
        name.SetVar22();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Женский", "Нет", "2.2");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Женский, Оба чек-бокса выбраны, Выбран радиобаттон Вариант 2.3
    @Test
    public void testForm3() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Женский");
        name.SetVar11();
        name.SetVar12();
        name.SetVar23();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Женский", "1.1, 1.2", "2.3");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Женский, Оба чек-бокса выбраны, Выбран радиобаттон не заполнен
    @Test
    public void testForm4() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Женский");
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Женский", "Нет", "");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Мужской, Оба чек-бокса Не выбраны, Выбран радиобаттон Вариант 2.3
    @Test
    public void testForm5() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Мужской");
        name.SetVar23();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Мужской", "Нет", "2.3");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Мужской, Оба чек-бокса выбраны, Выбран радиобаттон Вариант 2.3
    @Test
    public void testForm6() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Мужской");
        name.SetVar11();
        name.SetVar12();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Мужской", "1.1, 1.2", "");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Мужской, Оба чек-бокса НЕ выбраны, Выбран радиобаттон Вариант 2.1
    @Test
    public void testForm7() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Мужской");
        name.SetVar21();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Мужской", "Нет", "2.1");
    }

    //Проверка всей формы, где: Email корректно заполнен, Имя - корректно заполнен, Пол = Мужской, Оба чек-бокса выбраны, Выбран радиобаттон Вариант 2.2
    @Test
    public void testForm8() {
        driver.get("file:///Users/ekaterinaklimova/Downloads/Telegram%20Desktop/qa-test.html");
        Auth test1 = new Auth(driver);
        test1.corAuth();
        Registration name = new Registration(driver);
        name.SetEmail("m@test.ru");
        name.SetName("Имя");
        name.SetGender("Мужской");
        name.SetVar21();
        name.Click();
        name.CloseModal();
        name.checkTable("m@test.ru", "Имя", "Мужской", "Нет", "2.1");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
