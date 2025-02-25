package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        wd.findElement(By.xpath("//*[text()='ADD']")).click();
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//*[text()='Save']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list){
            if (el.getText().equals(name)){
                return true;
            }
        }return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list){
            if (el.getText().equals(phone)){
                return true;
            }
        }return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public void removeFirstContact() {

        WebElement firstContact = wd.findElement
                (By.xpath("(//div[@class='contact-item_card__2SOIM'])[1]"));
        firstContact.click();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[normalize-space()='Remove']")));
        removeButton.click();
    }
//   

    public int getContactCount() {
        WebElement contactsContainer =
                wd.findElement(By.xpath("//div[@class='contact-page_contactspage__2TPwe']"));

        List<WebElement> contacts = contactsContainer.findElements
                (By.xpath(".//div[@class='contact-card']"));

        return contacts.size();
    }
}