package com.n11.step_definitions;

import com.n11.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class Hooks {

    public WebDriver driver;
    public Actions action;

    @Before
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        action = new Actions(driver);
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
