package com.project.hardcore.framework.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}
