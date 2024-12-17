package KeborMed.FunctionalTests;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Authorization extends Base {

    @Test
    public void verifyValidLogin() {

        driver.get("https://kebormed.com/platform/index.html");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.partialLinkText("SIGN")).click();

        // Get all window handles (tabs)
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the second tab (if it exists)
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            // Check if the current window's title matches the new tab's title
            if (driver.getTitle().equals("Sign in to Main")) {
                break;
            }
        }
        // Perform actions on the second tab (for example, print the title)
        System.out.println("Current tab title: " + driver.getTitle());

            WebElement username = driver.findElement(By.id("username"));
            WebElement emailField = driver.findElement(By.id("password"));
            WebElement Sign = driver.findElement(By.id("kc-login"));

            username.sendKeys("Test");
            emailField.sendKeys("123456789");
            //SignIn.click();

        }

        @Test
        public void verifyInvalidLogin() {


        }
    }
