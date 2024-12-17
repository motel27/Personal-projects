package KeborMed.FunctionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePage extends Base{

    @Test
    public void verifyHomePageLoads() {
        driver.get("https://kebormed.com");
        String expectedTitle = "KeborMed";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Home page did not load correctly!");
    }
}
