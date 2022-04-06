package checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecomtests {
    static WebDriver driver;
    static WebDriverWait wait;


    @After
    public void stopBrowser() {
        driver.quit();
    }
    @Before
    public void gotoHomePage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("https://shop.lcfc.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-cookie-allow")));
        WebElement cookies = driver.findElement(By.cssSelector("#btn-cookie-allow"));
        cookies.click();
    }
    @Test
    public void additemtobaseketfromhome() {
        driver.findElement(By.xpath("//a[@tabindex='0']")).click();
        additemtobasket();
        gotocheckout();
        fillcheckoutdetailsandgotopayment();
        Assert.assertTrue(driver.findElement(By.tagName("iframe")).isDisplayed());
    }

    @Test
    public void additemtobaseketdirectfromproductpage() {
        driver.get("https://shop.lcfc.com/2021-22-white-walkout-jacket");
        additemtobasket();
        gotocheckout();
        fillcheckoutdetailsandgotopayment();
        Assert.assertTrue(driver.findElement(By.tagName("iframe")).isDisplayed());
    }
    @Test
    public void additemtobaseketdirectfromalltrainingware() {
        driver.get("https://shop.lcfc.com/trainingwear/all-trainingwear");
        driver.findElement(By.xpath("//div[@data-container=\"product-grid\"]//a[@tabindex='-1']")).click();
        additemtobasket();
        gotocheckout();
        fillcheckoutdetailsandgotopayment();
        Assert.assertTrue(driver.findElement(By.tagName("iframe")).isDisplayed());
    }

    private void fillcheckoutdetailsandgotopayment() {
        WebElement Email = driver.findElement(By.id("customer-email"));
        /// Email.click();
        Email.sendKeys("anu@gmail.com");
        WebElement deliveryButton = driver.findElement(By.xpath("//span[text()='Continue to Delivery']"));
        deliveryButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[1]")));
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Anusha");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Emani");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("ABC");
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("HamiltonRoad");
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("Anfield");
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("Merseyside");
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Liverpool");
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("L64DS");

        driver.findElement(By.name("telephone")).sendKeys("1234567890");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='s_method_matrixrate_matrixrate_230']")));
        driver.findElement(By.xpath("//label[@for='s_method_matrixrate_matrixrate_230']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='s_method_matrixrate_matrixrate_230']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='s_method_matrixrate_matrixrate_230']")));
        driver.findElement(By.xpath("(//button[@class='button action continue primary'])[2]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Continue'])[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Continue'])[1]")));
        driver.findElement(By.xpath("(//span[text()='Continue'])[1]")).click();
    }

    private void gotocheckout() {
        driver.get("https://shop.lcfc.com/checkout/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='login-password-disabled']")));
        driver.findElement(By.xpath("//label[@for='login-password-disabled']")).click();
    }

    private void additemtobasket() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("super-attribute-select")));
        Select S = new Select(driver.findElement(By.className("super-attribute-select")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("super-attribute-select")));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        S.selectByVisibleText("M");
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
    }


}

