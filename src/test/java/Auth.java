import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auth {

    public WebDriver driver;
    String login = "test@protei.ru";
    String password = "test";

    //методы для взаимодействия с полями в форме авторизации, в классе TestOne
    public Auth(WebDriver driver) {
        this.driver = driver;
    }

    public void setLogin(String login) {
        driver.findElement(By.id("loginEmail")).sendKeys(login);
    }

    public void setPassword(String password) {
        driver.findElement(By.id("loginPassword")).sendKeys(password);
    }

    public void Click() {
        driver.findElement(By.id("authButton")).click();
    }

    //метод для корректной авторизации
    public void corAuth() {
        setLogin(login);
        setPassword(password);
        Click();
    }

    //метод для проверки разных комбинаций логина и пароля
    public Boolean doAuth(String login, String password) {
        setLogin(login);
        setPassword(password);
        Click();
        return driver.findElement(By.id("inputsPage")).isDisplayed();
    }

}


