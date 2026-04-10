package de.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "bob@gmail.test");
        type(By.name("password"), "Aa12345!");
        click(By.name("login"));
    }
    @Test
    public void addContactPositiveTest(){
        click(By.cssSelector("[href='/add']"));
        type(By.xpath("//input[1]"),"Jack");
        type(By.xpath("//input[2]"),"Sparrow");
        type(By.xpath("//input[3]"),"1234567890");
        type(By.xpath("//input[4]"),"jack@gmail.com");
        type(By.xpath("//input[5]"),"Caribbean");
        type(By.xpath("//input[6]"),"Capitan");
        click(By.xpath("//button[.='Save']"));
        //Assert.assertTrue(isElementPresent());
    }
}
