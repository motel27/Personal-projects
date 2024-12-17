package KeborMed.PositiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ResponsiveTest extends Base {

    @Test
    public void verifyMobileView() {
        driver.get("https://kebormed.com");

        driver.manage().window().setSize(new Dimension(375, 812)); // iPhone X

        WebElement BurgerMenu = driver.findElement(By.id("burger-icon"));
        BurgerMenu.click();
        WebElement Platform = driver.findElement(By.xpath("//a[contains(text(),'Platform')]"));
        Platform.click();

        // Check if menu is adaptive
        boolean isMenuCollapsed = driver.findElement(By.id("invitation-btn-top")).isDisplayed();
        Assert.assertTrue(isMenuCollapsed, "Menu is not adaptive for Mobile-View");
    }
}
