package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent())
            app.getUser().clickOnSignOutButton();
    }

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User()
                .setEmail("bob@gmail.com")
                .setPassword("Aa12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutLinkPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User()
                .setEmail("bob@gmail.com")
                .setPassword("Aa12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

//int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//type(By.name("email"), "bob" + i + "@gmail.test");