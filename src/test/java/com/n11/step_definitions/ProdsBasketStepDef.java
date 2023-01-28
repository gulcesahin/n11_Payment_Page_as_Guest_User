package com.n11.step_definitions;

import com.n11.pages.HomePage;
import com.n11.pages.BasketPage;
import com.n11.pages.SearchPage;
import io.cucumber.java.en.*;

public class ProdsBasketStepDef {

    HomePage homePage = new HomePage();
    SearchPage searchPage= new SearchPage();
    BasketPage basketPage= new BasketPage();

    @Given("User opens the browser and goes to the home page and searches for the product {string} on the search bar")
    public void userOpensTheBrowserAndGoesToTheHomePageAndSearchesForTheProductOnTheSearchBar(String product) throws InterruptedException {
        homePage.goToTheUrl();
        homePage.closeCookies();
        homePage.searchProduct(product);
        searchPage.checkSearchedProductIsCorrect();
    }
    @When("User adds first and last products to the basket")
    public void userAddsFirstAndLastProductsToTheBasket() throws InterruptedException {
        searchPage.selectFirstProduct();
        searchPage.selectLastProduct();
        searchPage.goToBasket();
    }

    @Then("User continues to the payment page as a guest")
    public void userContinuesToThePaymentPageAsAGuest() {
        basketPage.closeKvkkMessage();
        basketPage.clickBuyButton();
        basketPage.continueAsAGuest();
    }

    @And("User sees that payment page opens")
    public void userSeesThatPaymentPageOpens() {
        basketPage.checkContactInfoIsOpen();
    }
}
