package KeborMed.PositiveTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactForm extends Base {

    @Test
    public void verifyContactFormSubmission() {
        driver.get("https://kebormed.com/about/index.html");

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement messageField = driver.findElement(By.id("message"));
      //WebElement submitButton = driver.findElement(By.id("submit"));

        nameField.sendKeys("Test User");
        emailField.sendKeys("test@example.com");
        messageField.sendKeys("This is a test message.");
        //submitButton.click();


        // Test if request is send by checking confirmation text
       WebElement successMessage = driver.findElement(By.id("success"));
       Assert.assertTrue(successMessage.isDisplayed(), "missing succsess confirmation message");
    }
}