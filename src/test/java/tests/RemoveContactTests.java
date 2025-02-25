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

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("karinmc9@mail.ru").setPassword("Rfhbyrf29$"));
        }
    }


    @Test
    public void removeFirstContact() {
        int before = app.getHelperContact().getContactCount();
        System.out.println(app.getHelperContact().getContactCount());// Количество контактов ДО удаления
        app.getHelperContact().removeFirstContact();
        app.getHelperContact().pause(10000);// Удаление первого контакта
        System.out.println(app.getHelperContact().getContactCount());
        int after = app.getHelperContact().getContactCount(); // Количество контактов ПОСЛЕ удаления

        Assert.assertEquals(after, before - 1);
    }



}



//    @Test
//    public void removeAllContacts(){
//            app.getHelperContact().removeAllContacts(); // Удаляем все контакты
//            Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
//        }
//
//    }

