package br.com.example.uploadfileselenium.app;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static br.com.example.uploadfileselenium.constants.Constants.SITE;
import static br.com.example.uploadfileselenium.constants.Constants.ELEMENT_TO_CLICK_PATH;
import static br.com.example.uploadfileselenium.constants.Constants.FILE_UPLOAD_PATH;
import static br.com.example.uploadfileselenium.constants.Constants.FILE_UPLOAD;

public class Upload {

    public static void main(String[] args) throws AWTException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(SITE);
        driver.manage().window().maximize();

        driver.findElement(By.xpath(ELEMENT_TO_CLICK_PATH)).click();

        // Using Robot class methods
        WebElement button = driver.findElement(By.xpath(FILE_UPLOAD_PATH));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",button); //click action on the button

        /* 1- Copy the path ; 2 - CTRL + V ; 3 - ENTER */
        Robot rb = new Robot();
        rb.delay(2000);

        // Pur path to file in a clipboard
        StringSelection ss = new StringSelection(FILE_UPLOAD);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        // CTRL + V Press on
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(2000);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);

        // ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
}
