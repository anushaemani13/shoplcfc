package checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SearchandAddProduct2
{
    static WebDriver driver;

    @Test
    public void addproduct2() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.lcfc.com/.");
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        WebElement SearchButton = driver.findElement(By.xpath("//span[text()='Search']"));
        SearchButton.click();
        SearchButton.sendKeys("Adidas" + "\n");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("(//img[@class='product-image-photo-hover'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Increase']")).click();
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        WebElement ErrorMessage = driver.findElement(By.xpath("//div[text()='The requested qty is not available']"));
        ErrorMessage.getText();
        System.out.println(ErrorMessage);
        driver.findElement(By.xpath("//span[text()='Decrease']")).click();
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        //driver.findElement(By.className("showcart__content")).click();
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        WebElement Email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        Email.sendKeys("anu@gmail.com");
        driver.findElement(By.xpath("//label[@for='login-password-disabled']")).click();
        WebElement deliveryButton = driver.findElement(By.xpath("//span[text()='Continue to Delivery']"));
        deliveryButton.click();
        driver.findElement(By.xpath("//h3[text()='Click & Collect (up to 10 working days)']")).click();
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        driver.findElement(By.xpath("(//input[@name='firstname'])[2]")).sendKeys("Anusha");
        driver.findElement(By.xpath("(//input[@name='lastname'])[2]")).sendKeys("Emani");
        driver.findElement(By.xpath("(//input[@name='company'])[2]")).sendKeys("ABC");
        driver.findElement(By.xpath("(//input[@name='street[0]'])[2]")).sendKeys("HamiltonRoad");
        driver.findElement(By.xpath("(//input[@name='street[1]'])[2]")).sendKeys("Anfield");
        driver.findElement(By.xpath("(//input[@name='street[2]'])[2]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@name='region'])[2]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@name='postcode'])[2]")).sendKeys("L54RT");
        driver.findElement(By.xpath("(//input[@name='telephone'])[2]")).sendKeys("1234567890");
        driver.findElement(By.className("action action-update")).click();
        driver.findElement(By.xpath("(//span[text()='Continue'])[1]")).click();
        driver.close();

    }
    }

