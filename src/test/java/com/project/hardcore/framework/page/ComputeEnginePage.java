package com.project.hardcore.framework.page;

import com.project.hardcore.framework.model.Instance;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;


public class ComputeEnginePage extends AbstractPage{
    final String PAGE_URL = "https://cloudpricingcalculator.appspot.com";
    final String gpuTypeFieldLocatorXpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]/div/div[1]/div[1]/md-input-container[1]";
    final String numOfGPUsFieldLocatorXpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]/div/div[1]/div[1]/md-input-container[2]";
    final String addGPUsLocatorXpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[13]/div[1]/md-input-container/md-checkbox/div[2]";
    final String finalAddToEstimateLocatorXpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "input_100")
    WebElement numberOfInstancesInput;

    @FindBy(id = "select_value_label_95")
    WebElement seriesField;

    @FindBy(id = "select_option_224")
    WebElement seriesType;

    @FindBy(id = "select_value_label_96")
    WebElement machineTypeField;

    @FindBy(xpath = gpuTypeFieldLocatorXpath)
    WebElement gpuTypeField;

    @FindBy(xpath = numOfGPUsFieldLocatorXpath)
    WebElement numOfGPUsField;

    @FindBy(id = "select_value_label_468")
    WebElement localSSDField;

    @FindBy(id = "select_value_label_98")
    WebElement dataCenterLocationField;

    @FindBy(id = "select_value_label_99")
    WebElement commitedUsageField;

    @FindBy(xpath = "//*[@value='NVIDIA_TESLA_V100']")
    WebElement gpuType;

    @FindBy(id = "select_option_520")
    WebElement numOfGPUs;

    @FindBy(id = "select_option_495")
    WebElement localSSD;

    @FindBy(id = "select_option_268")
    WebElement dataCenterLocation;

    @FindBy(id = "select_option_138")
    WebElement commitedUsage;

    @FindBy(id = "select_option_474")
    WebElement machineType;

    @FindBy(xpath = addGPUsLocatorXpath)
    WebElement addGPUs;

    @FindBy(xpath = finalAddToEstimateLocatorXpath)
    WebElement finalAddToEstimate;

    @FindBy(id = "Email Estimate")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[8]/div[1]/b")
    WebElement estimatedComponentCost;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/div[1]/h2/b")
    WebElement totalEstimatedCost;

    public ComputeEnginePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public ComputeEnginePage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public void fillComputeEngineForm(Instance instance) {
        numberOfInstancesInput.click();
        numberOfInstancesInput.sendKeys(instance.getNumberOfInstances());
        seriesField.click();
        seriesType.click();
        machineTypeField.click();
        machineType.click();
        addGPUs.click();
        gpuTypeField.click();
        gpuType.click();
        numOfGPUsField.click();
        numOfGPUs.click();
        localSSDField.click();
        driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", instance.getLocalSSD()))).click();
        dataCenterLocationField.click();
        driver.findElement(By.xpath(String.format("//*[@id='select_option_268']//div[contains(text(), '%s')]", instance.getDataCenterLocation()))).click();
        commitedUsageField.click();
        commitedUsage.click();
        logger.info("Compute Engine is ready.");
    }

    public void emailEstimate(){
        finalAddToEstimate.click();
        emailEstimateButton.click();
    }

    public void sendEmail(YopmailEmailPage yopmailEmailPage){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
        emailInput.click();
        yopmailEmailPage.getPasteYopmailEmail(emailInput);
        sendEmailButton.click();
    }

    public String getEstimatedComponentCost(){
        return estimatedComponentCost.getText()
                                     .substring(30);
    }

    public WebElement getTotalEstimatedCost(){
        return totalEstimatedCost;
    }
}