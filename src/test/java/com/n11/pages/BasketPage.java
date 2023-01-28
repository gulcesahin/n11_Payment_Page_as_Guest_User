package com.n11.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends HomePage {

    @FindBy(xpath = "//div[@id = 'userKvkkModal']//span[@class= 'btn btnBlack']")
    public WebElement closeKvkkMessageBtn;

    @FindBy(xpath = "//div[@class= 'btnHolder']//span[@id= 'js-buyBtn']")
    public WebElement buyBtn;

    @FindBy(xpath = "//form[@id= 'loginForm']//a[@class= 'btn-continue']")
    public WebElement continueAsAGuestBtn;

    @FindBy(xpath = "//section[@class= 'box box--medium boxQuestAddressForm clearfix']//h2[@class= 'box__title']")
    public WebElement contactInfoTextField;


    public void closeKvkkMessage(){
        closeKvkkMessageBtn.click();
    }

    public void clickBuyButton(){
        buyBtn.click();
    }

    public void continueAsAGuest(){
        continueAsAGuestBtn.click();
    }

    public void checkContactInfoIsOpen(){
        Assert.assertTrue((contactInfoTextField.getText()).contains("İletişim"));;
    }
}
