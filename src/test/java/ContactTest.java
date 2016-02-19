import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void getNameAndRelation_returnsFirstNameLastNameRelation_true() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    assertEquals("Bill", testContact.getFirstName());
    assertEquals("Murray", testContact.getLastName());
    assertEquals("Friend", testContact.getRelation());
  }

  @Test
  public void getId_returnsContactId() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    assertTrue(Contact.all().size() == testContact.getId());
  }

  @Test
  public void getFullName_returnsFirstNameAndLastName() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    assertEquals("Bill Murray", testContact.getFullName());
  }

  @Test
  public void getPhones_initiallyReturnsEmptyArrayList() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    assertTrue(testContact.getPhones() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesOfContact_true() {
    Contact firstContact = new Contact("Bill", "Murray", "Friend");
    Contact secondContact = new Contact("Some", "Dude", "Friend");
    assertTrue(Contact.all().contains(firstContact));
    assertTrue(Contact.all().contains(secondContact));
  }

  @Test
  public void clear_removesAllContactInstancesFromMemory() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    Contact.clear();
    assertEquals(Contact.all().size(), 0);
  }

  @Test
  public void find_returnsContactWothSameId() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    assertEquals(Contact.find(testContact.getId()), testContact);
  }

  @Test
  public void addPhoneNumbertoContactObject() {
    Contact testContact = new Contact("Bill", "Murray", "Friend");
    Phone testPhone = new Phone("123-456-7891", "Cell");
    testContact.addPhone(testPhone);
    assertTrue(testContact.getPhones().contains(testPhone));
  }

}
