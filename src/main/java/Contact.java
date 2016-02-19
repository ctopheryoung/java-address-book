import java.util.ArrayList;

public class Contact {

  private static ArrayList<Contact> instances = new ArrayList<Contact>();

  private String mFirstName;
  private String mLastName;
  private String mRelation;
  private int mId;
  private ArrayList<Phone> mPhones;

  public Contact(String firstName, String lastName, String relation) {
    mFirstName = firstName;
    mLastName = lastName;
    mRelation = relation;
    instances.add(this);
    mId = instances.size();
    mPhones = new ArrayList<Phone>();
  }

  public String getFirstName() {
    return mFirstName;
  }

  public String getLastName() {
    return mLastName;
  }

  public String getFullName() {
    return mFirstName + " " + mLastName;
  }

  public String getRelation() {
    return mRelation;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Phone> getPhones() {
    return mPhones;
  }

  public void addPhone(Phone phone) {
    mPhones.add(phone);
  }

  public static ArrayList<Contact> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Contact find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}
