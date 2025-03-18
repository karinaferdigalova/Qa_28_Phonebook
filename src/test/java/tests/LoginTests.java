package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //if SignOut present --->logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
        logger.info("Before method finished logout");
    }


    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Start test with name 'loginSuccess'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        logger.info("Test data --> email: "+ email+" & password: "+password);
        app.getHelperUser().submitLogin();
        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue()
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign out' present");
    }


    @Test(dataProvider = "loginModel",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data-->"+ user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test(dataProvider = "loginFile",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Test data-->"+ user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }


    @Test(groups = {"smoke"})
    public void loginWrongEmail(){
        logger.info("Test data --> email: 'maragmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data --> email: 'mara@gmail.com' & password: 'Mmar123'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com","Mmar123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --> email: 'maaa@gmail.com' & password: 'Maa123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maaa@gmail.com","Maa123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

}
//package tests;
//
//import manager.DataProviderUser;
//import models.User;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class LoginTests extends TestBase {
//
////    @BeforeMethod (alwaysRun = true)
//    public void preCondition(){
//        //if SignOut present --->logout
//        if(app.getHelperUser().isLogged())
//            app.getHelperUser().logout();
//        logger.info("Before method finished logout");
//    }
//
//
//    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
//    public void loginSuccess(String email, String password) {
//        logger.info("Start test with name 'loginSuccess'");
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm(email,password);
//        logger.info("Test data --> email: "+ email+" & password: "+password);
//        app.getHelperUser().submitLogin();
//        //Assert
////        Assert.assertEquals();
////        Assert.assertNotEquals();
////        Assert.assertTrue()
////        Assert.assertFalse();
//        Assert.assertTrue(app.getHelperUser().isLogged());
//        logger.info("Assert check is element button 'Sign out' present");
//    }
//
//
//    @Test(dataProvider = "loginFile",dataProviderClass = DataProviderUser.class)
//    public void loginSuccessModelDP(User user) {
//        logger.info("Test data-->"+ user.toString());
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm(user);
//        app.getHelperUser().submitLogin();
//        Assert.assertTrue(app.getHelperUser().isLogged());
//    }
//
//
//
//
//    @Test(groups ={ "smoke"})
//    public void loginWrongEmail(){
//        logger.info("Test data --> email: 'karinmc9mail.ru' & password: 'Rfhbyrf29$'");
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm ("karinmc9mail.ru","Rfhbyrf29$");
//        app.getHelperUser().submitLogin();
//        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
//        logger.info("Assert check is alert present with error text 'Wrong email or password'");
//    }
//
//    @Test
//    public void loginWrongPassword(){
//        logger.info("Test data --> email: 'karinmc9@mail.ru' & password: 'Rfhbyrf29'");
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm("karinmc9@mail.ru","Rfhbyrf29");
//        app.getHelperUser().submitLogin();
//        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
//        logger.info("Assert check is alert present with error text 'Wrong email or password'");
//
//    }
//
//    @Test
//    public void loginUnregisteredUser(){
//        logger.info("Test data --> email: 'maaa@gmail.com' & password: 'Maa123456$'");
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm("maaa@gmail.com","Maa123456$");
//        app.getHelperUser().submitLogin();
//        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
//        logger.info("Assert check is alert present with error text 'Wrong email or password'");
//
//
//    }
//
//}