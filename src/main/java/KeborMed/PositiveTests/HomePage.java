package KeborMed.PositiveTests;



import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends Base{

    @Test
    public void verifyHomePageLoads() {
        driver.get("https://kebormed.com");
        String expectedTitle = "KeborMed";              // insert Title of page for check
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Home page did not load correctly!");
    }
}
