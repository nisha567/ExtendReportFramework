package org.example.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {

    private static WebDriver driver = null;

    public static WebDriver getBrowser(String browserName) {

        switch (browserName.toLowerCase().intern()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "orangehrm_browserexes/chromedriver");
                BrowserFactory.driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "orangehrm_browserexes/msedgedriver.exe");
                BrowserFactory.driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver", "orangehrm_browserexes/geckodriver.exe");
                BrowserFactory.driver = new FirefoxDriver();
                break;
        }
        return BrowserFactory.driver;
    }

    public static void closeCurrentWindow() {
        BrowserFactory.driver.close();
    }

    public static void closeAllWindows() {
        BrowserFactory.driver.quit();
    }

    public static void openUrl(String url) {
        BrowserFactory.driver.get(url);
        BrowserFactory.driver.manage().window().maximize();
        BrowserFactory.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }


}