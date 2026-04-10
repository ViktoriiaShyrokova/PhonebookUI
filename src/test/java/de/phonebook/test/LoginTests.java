package de.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginRegisteredUserPositiveTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "bob@gmail.test");
        type(By.name("password"), "Aa12345!");
        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

}
