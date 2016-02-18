import java.util.ArrayList;

public class Contact {
  private String mfirstName;
  private String mlastName;
  private String mRelation;

  public Contact(String firstName, String lastName, String relation) {
    mfirstName = firstName;
    mlastName = lastName;
    mRelation = relation;
  }

  public String getFirstName() {
    return mfirstName;
  }

  public String getLastName() {
    return mlastName;
  }

  public String getRelation() {
    return mRelation;
  }

}
