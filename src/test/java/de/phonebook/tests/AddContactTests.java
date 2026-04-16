package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent())
            app.getUser().clickOnSignOutButton();

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User()
                .setEmail("bob@gmail.test")
                .setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new de.phonebook.model.Contact()
                .setName("Jack")
                .setLastName("Sparrow")
                .setPhone("1234567890")
                .setEmail("jack@gmail.com")
                .setAddress("Caribbean")
                .setDescription("Capitan"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyByName("Jack"));
    }

    @AfterMethod
    public void postConditions() {
        app.getContact().removeContact();
    }

}
