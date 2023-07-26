package org.example.selenium.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class CommonUtil {

    public static void getScreenshot(WebDriver driver, String name) {
        TakesScreenshot tss = (TakesScreenshot) driver;
        File dest = tss.getScreenshotAs(OutputType.FILE);
        File src = new File("orangehrm_screenshots/"+name+"123.png");
        try {
            FileUtils.copyFile(dest, src);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

   public static void getScreenshot(WebElement element, String name) {
        TakesScreenshot tss = (TakesScreenshot) element;
        File dest = tss.getScreenshotAs(OutputType.FILE);
        File src = new File("orangehrm_screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(dest, src);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseExecution_InSec(int time_in_sec) {
        try {
            Thread.sleep(time_in_sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
