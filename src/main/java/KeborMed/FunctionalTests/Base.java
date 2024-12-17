package KeborMed.FunctionalTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Base {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Инициализация драйвера (можно выбрать браузер через переменные)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mihail\\Desktop\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        // Установка таймаутов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
  /*  public void screens() throws Exception{

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\User\\Desktop\\Selenium.Log\\Automation\\Screens\\";
        FileUtils.copyFile(src, new File(path + time() + driver.getPageSource().getClass() + " " +this.getClass().getSimpleName() + "png"));
    }
    public String time() {
        return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());}
*/

