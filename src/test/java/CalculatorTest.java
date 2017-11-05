import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start()
    {
        System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///D:/calc.html");
    }

    @Before
    public void clean()
    {
        driver.findElement(By.xpath("//input[@value='C']")).click();
    }

    @Test
    public void adding()
    {
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("125", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void subtraction()
    {
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("-4", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void multiplication()
    {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("132", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void division()
    {
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("2.25",driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @AfterClass
    public static void stop()
    {
        driver.quit();
    }
}
