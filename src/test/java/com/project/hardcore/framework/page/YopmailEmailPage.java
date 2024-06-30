package com.project.hardcore.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class YopmailEmailPage extends AbstractPage{
    private final String PAGE_URL = "https://yopmail.com/email-generator";

    @FindBy(id = "cprnd")
    WebElement copyToClipboard;

    public YopmailEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public YopmailEmailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public void getYopmailEmailCopy(){
        copyToClipboard.click();
    }

    public void getPasteYopmailEmail(WebElement whereToPast){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        try{
            whereToPast.sendKeys((String)contents.getTransferData(DataFlavor.stringFlavor));
        }
        catch (UnsupportedFlavorException | IOException ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}