package KeborMed.FunctionalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ResetPassword extends Base{


    private Actions scrollUtils;

    @Test
    public void testForgotPassword() {
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        scrollUtils.scrollToElement(forgotPasswordLink);
        forgotPasswordLink.click();

    }
}

