package KeborMed.LoadTests;

import KeborMed.Base.MainBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PerformanceTest extends MainBase {

    public static void runTest(int threadNumber) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode

        WebDriver driver = new ChromeDriver(options);

        try {
            System.out.println("Thread " + threadNumber + " started.");

            long startTime = System.currentTimeMillis();
            driver.get("https://kebormed.com/index.html");
            long endTime = System.currentTimeMillis();

            long responseTime = endTime - startTime;
            System.out.println("Thread " + threadNumber + " - Page loaded in " + responseTime + " ms.");

            String title = driver.getTitle();
            System.out.println("Thread " + threadNumber + " - Page Title: " + title);

        } catch (Exception e) {
            System.err.println("Thread " + threadNumber + " encountered an error: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Thread " + threadNumber + " finished.");
        }
    }

    @Test
    public void testMultipleThreads() {
        int numberOfThreads = 6;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 1; i <= numberOfThreads; i++) {
            final int threadNumber = i;
            executor.submit(() -> runTest(threadNumber));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("All tests finished.");
    }
}


