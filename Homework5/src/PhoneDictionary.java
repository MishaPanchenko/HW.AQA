
import java.util.HashMap;
import java.util.HashSet;

public class PhoneDictionary {
    private final HashMap<String, HashSet<String>> rows = new HashMap<>();

    public void add(String surname, String phone) {
        HashSet<String> phones;
        phones = this.rows.get(surname);
        if (phones == null) phones = new HashSet<>();
        phones.add(phone);
        this.rows.put(surname, phones);
    }

    public HashSet<String> get(String surname) {
        return this.rows.get(surname);
    }
}
