package KeborMed.FunctionalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ResetPasswordTest extends Base{

    @Test
    public void testForgotPasswordValidEmail() throws InterruptedException {
        driver.get("https://kebormed.com/platform/index.html");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.partialLinkText("SIGN")).click();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the second tab
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            // Check if the current window's title matches the new tab's title
            if (driver.getTitle().equals("Sign in to Main")) {
                break;
            }
        }

        driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
        driver.findElement(By.id("username")).sendKeys("Kebormedtest@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'You should receive an email shortly with further i')]")).getText(),
                "You should receive an email shortly with further instructions.",
                "missing informative message that instructions was sent");
    }

    @Test
    public void testForgotPasswordInvalidEmail() throws InterruptedException {
        driver.get("https://kebormed.com/platform/index.html");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.partialLinkText("SIGN")).click();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the second tab
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            // Check if the current window's title matches the new tab's title
            if (driver.getTitle().equals("Sign in to Main")) {
                break;
            }
        }

        driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
        driver.findElement(By.id("username")).sendKeys("ExampleInvalid@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'You should receive an email shortly with further i')]")).getText(),
                "You should receive an email shortly with further instructions.",
                "missing informative message that instructions was sent");
    }
}

