package com.project.hardcore.framework.util;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class TabUtils {
    public static void switchToFirstTab(WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        String firstHandle = handles.iterator().next();
        driver.switchTo().window(firstHandle);
    }

    public static void switchToNewTab(WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
