package de.phonebook.fw;

import de.phonebook.core.BaseHelper;
import de.phonebook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.xpath("//button[.='Save']"));
    }

    public void fillAddContactForm(Contact contact) {
        type(By.xpath("//input[1]"), contact.getName());
        type(By.xpath("//input[2]"), contact.getLastName());
        type(By.xpath("//input[3]"), contact.getPhone());
        type(By.xpath("//input[4]"), contact.getEmail());
        type(By.xpath("//input[5]"), contact.getAddress());
        type(By.xpath("//input[6]"), contact.getDescription());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean verifyByName(String text) {
        return verifyText(text, By.cssSelector("h2"));
        // return contacts.stream().anyMatch(e -> e.getText().contains(text));
    }
    public boolean verifyText(String text, By locator) {
        List<WebElement> contacts = driver.findElements(locator);
        return contacts.getLast().getText().trim().equals(text);
        // return contacts.stream().anyMatch(e -> e.getText().contains(text));
    }

    public void removeContact() {
        click(By.className("contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts() {
        return driver.findElements(By.className("contact-item_card__2SOIM")).size();
    }

    public boolean verifyByPhone(String phone) {
        return verifyText(phone, By.cssSelector("h3"));
    }
}
