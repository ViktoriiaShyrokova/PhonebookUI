package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if(!app.getUser().isLoginLinkPresent())
            app.getUser().clickOnSignOutButton();

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User()
                .setEmail("bob@gmail.test")
                .setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new de.phonebook.model.Contact()
                .setName("Jack")
                .setLastName("Sparrow")
                .setPhone("1234567890")
                .setEmail("jack@gmail.com")
                .setAddress("Caribbean")
                .setDescription("Capitan"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
