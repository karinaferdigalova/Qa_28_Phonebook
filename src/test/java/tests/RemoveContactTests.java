package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveContactTests extends TestBase {
    @BeforeMethod (alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("margo@gmail.com").withPassword("Mmar123456$"));
        }
        app.getHelperContact().provideContacts();//if list of contacts <3 ==> add 3 contacts

    }


    @Test(groups ={ "smoke"})
    public void removeFirstContact() {
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);

    }
    @Test
    public void removeAllContacts(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());
        //"No contacts here

    }
}



