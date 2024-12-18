package KeborMed.FunctionalTests.ContactForm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactFormPage{
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By messageField = By.id("message");
    private final By subjectField = By.id("subject");
    private final By submitButton = By.xpath("//button[contains(text(),'SEND')]");
    private final By successMessage = By.id("success");

    // Error locators
    private final By subjectError = By.id("subject-error");
    private final By messageError = By.id("message-error");
    private final By nameError = By.id("name-error");
    private final By emailError = By.id("email-error");

    public ContactFormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void scrollToBottom() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
    }

    public void clickSend() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public String getErrorMessage(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // Error message getters
    public String getSubjectError() {
        return getErrorMessage(subjectError);
    }

    public String getMessageError() {
        return getErrorMessage(messageError);
    }

    public String getNameError() {
        return getErrorMessage(nameError);
    }

    public String getEmailError() {
        return getErrorMessage(emailError);
    }
}
