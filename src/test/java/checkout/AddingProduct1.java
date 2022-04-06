package checkout;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddingProduct1
{
   static WebDriver driver;

   @Test
   public void AddingProduct1tothecart()

    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.lcfc.com/.");
        try {
            WebElement cookies = driver.findElement(By.cssSelector("#btn-cookie-allow"));
            cookies.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1800)", "");
        driver.findElement(By.xpath("(//img[@class='product-image-photo-hover'])[10]")).click();
        Select S = new Select(driver.findElement(By.className("super-attribute-select")));
        S.selectByVisibleText("M");
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        WebElement Email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        Email.sendKeys("anu@gmail.com");
        driver.findElement(By.xpath("//label[@for='login-password-disabled']")).click();
        WebElement deliveryButton = driver.findElement(By.xpath("//span[text()='Continue to Delivery']"));
        deliveryButton.click();
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Anusha");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Emani");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("ABC");
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("HamiltonRoad");
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("Anfield");
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("Merseyside");
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("L64DS");
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("1234567890");
        driver.findElement(By.xpath("//label[@for='s_method_matrixrate_matrixrate_230']")).click();
        driver.findElement(By.xpath("(//button[@class='button action continue primary'])[2]")).click();
        driver.findElement(By.xpath("(//span[text()='Continue'])[1]")).click();
        driver.close();
    }

    }


