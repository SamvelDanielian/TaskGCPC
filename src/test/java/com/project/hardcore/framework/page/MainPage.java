package com.project.hardcore.framework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{
    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='YSM5S']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@class='qdOxv-fmcmS-wGMbrd']")
    WebElement searchInput;

    @FindBy(xpath = "//a[text()='Google Cloud Pricing Calculator']")
    WebElement calculatorLink;

    @FindBy(xpath = "//*[@class='UywwFc-vQzf8d'][text()='Add to estimate']")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//a[text()='legacy version']")
    WebElement legacyVersion;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public void openComputeEnginePage(){
        searchButton.click();
        searchInput.sendKeys("Google Cloud Pricing Calculator", Keys.ENTER);
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Google Cloud Pricing Calculator']")));
        calculatorLink.click();
        addToEstimateButton.click();
        legacyVersion.click();
    }
}