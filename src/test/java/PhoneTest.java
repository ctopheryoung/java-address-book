import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void phone_instantiatesCorrectly_true() {
    Phone testPhone = new Phone("123-456-7890", "Cell");
    assertEquals(true, testPhone instanceof Phone);
  }

  @Test
  public void getPhoneNumberAndType_returnsPhoneNumberAndType_true() {
    Phone testPhone = new Phone("123-456-7890", "Cell");
    assertEquals("123-456-7890", testPhone.getPhoneNumber());
    assertEquals("Cell", testPhone.getType());
  }

  @Test
  public void all_returnsAttInstancesOfPhone_true() {
    Phone testPhoneOne = new Phone("123-456-7890", "Cell");
    Phone testPhoneTwo = new Phone("098-765-4321", "Home");
    assertTrue(Phone.all().contains(testPhoneOne));
    assertTrue(Phone.all().contains(testPhoneTwo));
  }
  @Test
  public void newId_todosInstantiateWithAnID_true() {
    Phone testPhone = new Phone("123-456-7891", "Cell");
    assertEquals(Phone.all().size(), testPhone.getId());
  }

  @Test
  public void find_returnsPhoneWithSameId_multiple() {
    Phone testPhone = new Phone("123-456-7891", "Cell");
    Phone testPhoneTwo = new Phone("145-345-3241", "Home");
    assertEquals(Phone.find(testPhoneTwo.getId()), testPhoneTwo);
  }

  @Test
  public void find_returnsNullWhenNoToDoFound_null() {
    assertTrue(Phone.find(999) == null);
  }

  @Test
  public void clear_emptiesAllToDosFromArrayList() {
    Phone testPhone = new Phone("123-123-1232", "Cell");
    Phone.clear();
    assertEquals(Phone.all().size(), 0);
  }
}
