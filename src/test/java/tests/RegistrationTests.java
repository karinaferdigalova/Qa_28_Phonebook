package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if SignOut present --->logout
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test(description = "Bug report #12345")// enabled-false- тест будет пропускаться
    public void registrationSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        User user = new User().withEmail("son" + i + "@gmail.com")
                .withPassword("Son123456$");


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
         Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }
    @Test
    public void registrationWrongEmail(){
        User user = new User().withEmail("songgmail.com")
                .withPassword("Son1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm (user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void registrationWrongPassword(){
        User user = new User().withEmail("song@gmail.com")
                .withPassword("Son1234");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm (user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void registrationExistUser(){
        User user = new User().withEmail("karinmc@mail.ru")
                .withPassword("Rfhbyrf29$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm (user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }



}