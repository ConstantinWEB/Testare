package org.example;

import org.example.pom.FormaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class FormeTest {
    public static String FIRST_NAME = "Constantin";
    public static String LAST_NAME = "Bulai";
    public static String EMAIL = "constantin.bulai01@gmail.com";
    public static String MOBILE_NUMBER = "1234567890";
    public static String SUBJECT = "Maths";
    public static String ADDRESS = "1234 Elm Street";
    public static String STATE = "NCR";
    public static String CITY = "Delhi";
    public static String FILE_PATH = "C:\\Users\\const\\OneDrive\\Desktop\\me.jpg";

    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\const\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");

        // Set up Chrome options to block ads
        ChromeOptions options = new ChromeOptions();

        // Blocarea imaginilor pentru a reduce încărcarea reclamelor
        options.addArguments("--blink-settings=imagesEnabled=false");

        // Blochează pop-up-urile și extensiile
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");

        // Configurări pentru a dezactiva reclame
        options.addArguments("--remote-allow-origins=*");

        // Inițializarea driverului Chrome cu opțiunile setate
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

        page.setDateOfBirth();

        page.setSubject(SUBJECT);
        page.selectHobbySports();
        page.selectHobbyMusic();
        page.setCurrentAddress(ADDRESS);
        page.selectState(STATE);
        page.selectCity(CITY);
        page.uploadPicture(FILE_PATH);

        // Trimite formularul
        page.submitForm();
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
