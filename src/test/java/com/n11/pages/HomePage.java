package com.n11.pages;

import com.n11.utilities.ConfigReader;
import com.n11.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    public HomePage() {PageFactory.initElements(Driver.get(), this);}

    WebDriver driver= Driver.get();

    @FindBy(className = "efilli-layout-n11")
    public List<WebElement> shadowHosts;

    @FindBy(id = "searchData")
    public WebElement searchBar;

    @FindBy(className = "searchBtn")
    public WebElement searchBtn;

    public void goToTheUrl() throws InterruptedException {
        driver.get(ConfigReader.get("url"));
        Thread.sleep(5000);
        Assert.assertEquals(ConfigReader.get("url"),driver.getCurrentUrl());
    }

    public void closeCookies(){
        if(!shadowHosts.isEmpty()){
            WebElement shadowHost = driver.findElement(By.className("efilli-layout-n11"));
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            WebElement acceptCookiesBtn = shadowRoot.findElement(By.className("banner__accept-button"));
            acceptCookiesBtn.click();
        }
    }

    public void searchProduct(String product){
        searchBar.sendKeys(product);
        searchBtn.click();
    }
}
