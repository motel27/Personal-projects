package KeborMed.FunctionalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactForm extends Base {

    @Test
    public void verifyContactFormSubmission() {
        driver.get("https://kebormed.com/about/index.html");

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement messageField = driver.findElement(By.id("message"));
        WebElement subjectField = driver.findElement(By.id("subject"));
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'SEND')]"));

        nameField.sendKeys("Test User");
        emailField.sendKeys("test@example.com");
        messageField.sendKeys("This is a test message.");
        subjectField.sendKeys("TEST SUBJECT");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        // submitButton.click();

        // Test if request is send by checking confirmation text
        WebElement successMessage = driver.findElement(By.id("success"));
        Assert.assertTrue(successMessage.isDisplayed(), "missing success confirmation message");

    }
       @Test
        public void verifyContactFormSubmission2() throws InterruptedException {
        driver.get("https://kebormed.com/about/index.html");
         Actions actions = new Actions(driver);
         actions.sendKeys(Keys.END).perform();
         driver.findElement(By.xpath("//button[contains(text(),'SEND')]")).click();

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           WebElement subjectError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject-error")));
           Assert.assertEquals(subjectError.getText(), "Please enter a subject", "missing error messages for Subject field");

           Assert.assertEquals(driver.findElement(By.id("message-error")).getText(),
                   "Please enter your message",
                   "missing error messages for box message");

           Assert.assertEquals(driver.findElement(By.id("name-error")).getText(),
                   "Please enter your name",
                   "missing error message for Name field");

           Assert.assertEquals(driver.findElement(By.id("email-error")).getText(),
                   "Please enter your email",
                   "missing error message for Email field");
           }
       }
