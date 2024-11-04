package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


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

    public void setDateOfBirth(String dateOfBirth) {
        // Setează valoarea datei folosind JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", dateOfBirthEl, dateOfBirth);
    }

    public void setSubject(String subject) {
        subjectsInputEl.sendKeys(subject);
        subjectsInputEl.sendKeys("\n"); // Press Enter to add the subject
    }

    public void selectHobbySports() {
        hobbySportsEl.click();
    }

    public void selectHobbyMusic() {
        hobbyMusicEl.click();
    }

}