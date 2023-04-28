package phone_number;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        PhoneNumber number1 = new PhoneNumber("981", "0234567");
        PhoneNumber number2 = new PhoneNumber("7890", "0654321");
        PhoneNumber number3 = new PhoneNumber("7890", "06543215");

        // Использование класса PhoneNumber с множествами
        HashSet<PhoneNumber> phoneSet = new HashSet<>();
        phoneSet.add(number1);
        phoneSet.add(number2);
        System.out.println(phoneSet.size()); // 2

        // Использование класса PhoneNumber с ассоциативными массивами
        HashMap<PhoneNumber, String> phoneMap = new HashMap<>();
        phoneMap.put(number1, "Person 1");
        phoneMap.put(number2, "Person 2");
        System.out.println(phoneMap.get(number1)); // Person 1
        System.out.println(phoneMap.toString());


    }
}
