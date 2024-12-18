package FunctionalTests;

import KeborMed.Base.MainBase;
import KeborMed.FunctionalTests.ContactForm.ContactFormPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactFormTest extends MainBase {

    private ContactFormPage contactPage;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUpTest() {
        setUp();
        driver.get("https://kebormed.com/about/index.html");
        contactPage = new ContactFormPage(driver, wait);
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    @Test(enabled = true)
    public void verifyContactFormSubmission() {
        contactPage.fillContactForm("Test User", "test@example.com", "TEST SUBJECT", "This is a test message.");
        contactPage.scrollToBottom();
        // contactPage.clickSend();
       // Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "Missing success confirmation message");
    }

    @Test
    public void verifyContactFormSubmissionWithEmptyFields() {
       contactPage.scrollToBottom();
       contactPage.clickSend();

        Assert.assertEquals(contactPage.getSubjectError(), "Please enter a subject", "Missing error message for Subject field");
        Assert.assertEquals(contactPage.getMessageError(), "Please enter your message", "Missing error message for Message field");
        Assert.assertEquals(contactPage.getNameError(), "Please enter your name", "Missing error message for Name field");
        Assert.assertEquals(contactPage.getEmailError(), "Please enter your email", "Missing error message for Email field");
    }
}
