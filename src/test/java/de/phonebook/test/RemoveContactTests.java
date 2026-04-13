package de.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("bob@gmail.test")
                .setPassword("Aa12345!"));
        clickOnLoginButton();

        clickOnAddLink();
        fillAddContactForm(new Contact()
                .setName("Jack")
                .setLastName("Sparrow")
                .setPhone("1234567890")
                .setEmail("jack@gmail.com")
                .setAddress("Caribbean")
                .setDescription("Capitan"));
        clickOnSaveButton();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();

        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
