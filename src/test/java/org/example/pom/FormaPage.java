package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormaPage {
    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstNameEl;

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastNameEl;

    @FindBy(xpath = "//*[@id='userEmail']")
    private WebElement emailEl;

    @FindBy(xpath = "//label[text()='Male']")
    private WebElement genderMaleEl;

    @FindBy(xpath = "//*[@id='userNumber']")
    private WebElement mobileNumberEl;

    @FindBy(xpath = "//*[@id='dateOfBirthInput']")
    private WebElement dateOfBirthEl;

    @FindBy(xpath = "//*[@id='subjectsInput']")
    private WebElement subjectsInputEl;

    @FindBy(xpath = "//label[text()='Sports']")
    private WebElement hobbySportsEl;

    @FindBy(xpath = "//label[text()='Music']")
    private WebElement hobbyMusicEl;

    @FindBy(xpath = "//*[@id='currentAddress']")
    private WebElement currentAddressEl;

    @FindBy(xpath = "//*[@id='react-select-3-input']")
    private WebElement stateEl;

    @FindBy(xpath = "//*[@id='react-select-4-input']")
    private WebElement cityEl;

    @FindBy(xpath = "//*[@id='uploadPicture']")
    private WebElement uploadPictureEl;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement submitButtonEl;

    public static WebDriver driver;

    public FormaPage(WebDriver driver) {
        FormaPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        firstNameEl.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameEl.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailEl.sendKeys(email);
    }

    public void setGenderMale() {
        genderMaleEl.click();
    }

    public void setMobileNumber(String mobileNumber) {
        mobileNumberEl.sendKeys(mobileNumber);
    }

    public void setDateOfBirth() {
        dateOfBirthEl.click();
        // Selectăm anul 2005
        driver.findElement(By.className("react-datepicker__year-select")).sendKeys("2005");
        // Selectăm luna Iunie
        driver.findElement(By.className("react-datepicker__month-select")).sendKeys("June");
        // Selectăm ziua 1
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='1']")).click();
    }

    public void setSubject(String subject) {
        subjectsInputEl.sendKeys(subject);
        subjectsInputEl.sendKeys("\n");
    }

    public void selectHobbySports() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hobbySportsEl)).click();
    }

    public void selectHobbyMusic() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hobbyMusicEl)).click();
    }

    public void setCurrentAddress(String address) {
        currentAddressEl.sendKeys(address);
    }

    public void selectState(String state) {
        stateEl.sendKeys(state);
        stateEl.sendKeys(Keys.RETURN);
    }

    public void selectCity(String city) {
        cityEl.sendKeys(city);
        cityEl.sendKeys(Keys.RETURN);
    }

    public void uploadPicture(String filePath) {
        uploadPictureEl.sendKeys(filePath);
    }

    public void submitForm() {
        submitButtonEl.click();
    }
}
