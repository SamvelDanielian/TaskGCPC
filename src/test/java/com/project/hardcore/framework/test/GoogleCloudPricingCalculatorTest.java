package com.project.hardcore.framework.test;

import static org.testng.AssertJUnit.assertEquals;

import com.project.hardcore.framework.model.Instance;
import com.project.hardcore.framework.page.ComputeEnginePage;
import com.project.hardcore.framework.page.MainPage;
import com.project.hardcore.framework.page.YopmailEmailPage;
import com.project.hardcore.framework.service.InstanceCreator;
import com.project.hardcore.framework.util.TabUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest extends CommonConditions{

    private MainPage mainPage;
    private ComputeEnginePage computeEnginePage;
    private Instance instance;

    @Test
    public void testGoogleCloudPricingCalculator() {
        mainPage = new MainPage(driver);
        computeEnginePage = new ComputeEnginePage(driver);
        instance = InstanceCreator.withCredentialsFromProperty();

        mainPage.openPage().openComputeEnginePage();
        TabUtils.switchToFirstTab(driver);
        computeEnginePage.openPage().fillComputeEngineForm(instance);
        computeEnginePage.emailEstimate();
        getYopmailEmailCopyAndSendEmail(computeEnginePage);

        assertEquals("ERROR! Something went wrong!",
            calculateActualCost(computeEnginePage), computeEnginePage.getEstimatedComponentCost());
    }

    private void getYopmailEmailCopyAndSendEmail(ComputeEnginePage computeEnginePage) {
        TabUtils.switchToNewTab(driver);
        YopmailEmailPage yopmailEmailPage = new YopmailEmailPage(driver);
        yopmailEmailPage.openPage().getYopmailEmailCopy();
        TabUtils.switchToFirstTab(driver);
        computeEnginePage.sendEmail(yopmailEmailPage);
    }

    private String calculateActualCost(ComputeEnginePage computeEnginePage) {
        return computeEnginePage.getTotalEstimatedCost()
            .getText()
            .trim()
            .substring(26);
    }
}