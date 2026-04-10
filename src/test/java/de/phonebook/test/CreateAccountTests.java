package de.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        click(By.cssSelector("[href='/login']"));
        //type(By.name("email"), "bob@gmail.test");
        type(By.name("email"), "bob" + i + "@gmail.test");
        type(By.name("password"), "Aa12345!");
        click(By.name("registration"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "bob@gmail.test");
        type(By.name("password"), "Aa12345!");
        click(By.name("registration"));
        Assert.assertTrue(isAlertPresent());
    }

}
