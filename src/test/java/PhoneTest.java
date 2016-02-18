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

}
