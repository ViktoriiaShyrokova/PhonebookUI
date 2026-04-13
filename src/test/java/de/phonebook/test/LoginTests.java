package de.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginRegisteredUserPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("bob@gmail.test")
                .setPassword("Aa12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutLinkPresent());
    }

    @Test
    public void loginRegisteredUserWithoutEmailNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("Aa12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }

}
