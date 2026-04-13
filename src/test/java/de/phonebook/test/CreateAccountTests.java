package de.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {

        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("bob@gmail.com")
                .setPassword("Aa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutLinkPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("bob@gmail.com")
                .setPassword("Aa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }

}

//int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//type(By.name("email"), "bob" + i + "@gmail.test");