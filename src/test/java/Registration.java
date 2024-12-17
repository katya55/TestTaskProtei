import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//Создание методов для проверки формы регистрации, в классе TestTwo

public class Registration {

    public WebDriver driver;
    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    public void SetEmail(String email) {
        driver.findElement(By.id("dataEmail")).clear();
        driver.findElement(By.id("dataEmail")).sendKeys(email);
    }

    public void Click() {
        driver.findElement(By.id("dataSend")).click();
    }

    public void SetName(String name) {
        driver.findElement(By.id("dataName")).clear();
        driver.findElement(By.id("dataName")).sendKeys(name);
    }

    public void SetGender(String gender) {
        WebElement selectElement = driver.findElement(By.id("dataGender"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(gender);
    }

    public void SetVar11() {
        driver.findElement(By.id("dataCheck11")).click();
    };
    public void SetVar12() {
        driver.findElement(By.id("dataCheck12")).click();
    };

    public void SetVar21() {
        driver.findElement(By.id("dataSelect21")).click();
    };
    public void SetVar22() {
        driver.findElement(By.id("dataSelect22")).click();
    };
    public void SetVar23() {
        driver.findElement(By.id("dataSelect23")).click();
    };
    public void CloseModal() {
        driver.findElement(By.className("uk-modal-close")).click();
    }
    public void checkTable(String email, String name, String gender, String var1, String var2) {
        WebElement row = driver.findElement(By.xpath("(//*[@id=\"dataTable\"]/tbody/tr)[last()]"));
        Assert.assertEquals(row.findElement(By.xpath("//td[1]")).getText(),email);
        Assert.assertEquals(row.findElement(By.xpath("//td[2]")).getText(),name);
        Assert.assertEquals(row.findElement(By.xpath("//td[3]")).getText(),gender);
        Assert.assertEquals(row.findElement(By.xpath("//td[4]")).getText(),var1);
        Assert.assertEquals(row.findElement(By.xpath("//td[5]")).getText(),var2);
    }
}

