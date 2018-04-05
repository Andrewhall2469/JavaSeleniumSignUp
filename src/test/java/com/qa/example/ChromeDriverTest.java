package com.qa.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {

	private static WebDriver cdriver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		cdriver = new ChromeDriver();

	}

	@Test
	public void testGoogleSearch() throws InterruptedException {

        try {
            ApachePOIExcelWrite excelWrite = new ApachePOIExcelWrite();
            excelWrite.init();
            ExcelUtils excelUtils = new ExcelUtils();
            excelUtils.initialise();

            cdriver.get("http://www.google.com/");
            cdriver.manage().window().fullscreen();
           // Thread.sleep(5000); // Let the user actually see something!
            WebElement searchBox = cdriver.findElement(By.name("q"));
            searchBox.sendKeys("Twitter Sign Up");
            searchBox.submit();
            WebElement chromeDriverLink = cdriver
                    .findElement(By.linkText("Sign up for Twitter"));
            chromeDriverLink.click();
            //Thread.sleep(5000);


            WebElement enterName = cdriver.findElement(By.xpath("//*[@id=\"full-name\"]"));
            enterName.sendKeys(excelUtils.getName());


            WebElement enterEmail = cdriver.findElement(By.xpath("//*[@id=\"email\"]"));
            enterEmail.sendKeys(excelUtils.getEmail());

            WebElement enterPassword = cdriver.findElement(By.xpath("//*[@id=\"password\"]"));
            enterPassword.sendKeys(excelUtils.getPassword());

            Thread.sleep(2500);

            WebElement submit = cdriver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
            submit.click();

            Thread.sleep(2500);

            WebElement skip = cdriver.findElement(By.xpath("//*[@id=\"sms-phone-create-form\"]/div[3]/div[2]/a"));
            skip.click();

            Thread.sleep(2500);

            WebElement skip2 = cdriver.findElement(By.xpath("//*[@id=\"phx-signup-form\"]/div[3]/div[2]/a"));
            skip2.click();

            Thread.sleep(2500);

            Screenshot screen = new Screenshot();
            screen.takeScreenshot();

        }
        finally
        {

        }
    }

	@After
	public void tearDown() {
		cdriver.quit();
	}

}
