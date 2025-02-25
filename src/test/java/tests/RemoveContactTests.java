package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("karinmc9@mail.ru").setPassword("Rfhbyrf29$"));
        }
    }


    @Test
    public void removeFirstContact(){
        //Assert size contactList less by one

    }

    @Test
    public void removeAllContacts(){
        //"No contacts here

    }
}