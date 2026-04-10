package de.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void isHomeComponentPresentTest() {
        //Assert.assertTrue(isHomeComponentPresent());
        Assert.assertTrue(isElementPresent(By.xpath("//div[2]//h1")));
    }


}
