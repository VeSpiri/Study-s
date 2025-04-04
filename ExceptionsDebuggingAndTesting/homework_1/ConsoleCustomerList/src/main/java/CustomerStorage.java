import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    public CustomerStorage() {
        storage = new HashMap<>();
    }
    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String phoneRegex = "^((8|7|\\+7)([0-9]{10}))$";
        final String emailRegex = "(([A-Za-z0-9\\-_.]+)(@)([a-z]+)(.)([a-z]{2,5}))$";
        String[] components = data.split("\\s+");

        if (components.length == 4) {
            if (components[INDEX_PHONE].matches(phoneRegex)) {
                if (components[INDEX_EMAIL].matches(emailRegex)) {
                    String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
                    storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
                } else {
                    throw new WrongEmailException();
                }
            } else {
                throw new WrongPhoneNumberException();
            }
        } else {
            throw new WrongCountComponentsException();
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}