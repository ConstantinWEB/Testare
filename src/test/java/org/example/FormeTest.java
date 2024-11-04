package org.example;

import org.example.pom.FormaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormeTest {
    public static String FIRST_NAME = "Anatolie";
    public static String LAST_NAME = "Popescu";
    public static String EMAIL = "anatolie.popescu@example.com";
    public static String MOBILE_NUMBER = "1234567890";
    public static String DOB = "01 Jun 2005";
    public static String SUBJECT = "Maths";


    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\const\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void FormaTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        FormaPage page = new FormaPage(driver);
        page.setFirstName(FIRST_NAME);
        page.setLastName(LAST_NAME);
        page.setEmail(EMAIL);
        page.setGenderMale();
        page.setMobileNumber(MOBILE_NUMBER);
        page.setDateOfBirth(DOB);
        page.setSubject(SUBJECT);
        page.selectHobbySports();
        page.selectHobbyMusic();

    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
