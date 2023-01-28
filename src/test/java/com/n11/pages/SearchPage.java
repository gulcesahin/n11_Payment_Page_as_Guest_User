package com.n11.pages;

import com.n11.utilities.Commons;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage extends HomePage {

    @FindBy(className = "resultText")
    public WebElement resultText;

    @FindBy(css = ".lazy.cardImage")
    public List<WebElement> productsNum;

    @FindBy(xpath = "//div[@class = 'product-add-cart']//button[@type='submit']")
    public WebElement addBasketBtn;

    @FindBy(className = "iconsBasketWhite")
    public WebElement goToBasketPageIcon;

    public void checkSearchedProductIsCorrect(){
        Assert.assertTrue(resultText.getText().contains("IPhone"));
    }

    public void selectFirstProduct() throws InterruptedException {
        Commons.hover(productsNum.get(0));
        productsNum.get(0).click();
        Thread.sleep(5000);
        Commons.switchTab(1);
        addBasketBtn.click();
        Commons.switchTab(0);
    }

    public void selectLastProduct() throws InterruptedException {
        int lastProduct = productsNum.size() - 1;
        Commons.hover(productsNum.get(lastProduct));
        productsNum.get(lastProduct).click();
        Thread.sleep(5000);
        Commons.switchTab(2);
        addBasketBtn.click();
        Thread.sleep(5000);
    }

    public void goToBasket() throws InterruptedException {
        Thread.sleep(5000);
        goToBasketPageIcon.click();
    }
}
