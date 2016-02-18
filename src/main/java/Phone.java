import java.util.ArrayList;

public class Phone {

  private static ArrayList<Phone> instances = new ArrayList<Phone>();

  private String mPhoneNumber;
  private String mType;
  private int mId;

  public Phone (String phoneNumber, String type) {
    mPhoneNumber = phoneNumber;
    mType = type;
    instances.add(this);
    mId = instances.size();
  }

  public String getPhoneNumber() {
    return mPhoneNumber;
  }

  public String getType() {
    return mType;
  }

  public int getId() {
    return mId;
  }

  public static Phone find(int id) {
    try {
      return instances.get(id-1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

  public static ArrayList<Phone> all() {
    return instances;
  }
}
