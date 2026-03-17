import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class C {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("04", "Futian");
        map.put("03", "Luohu");
        map.put("05", "Nanshan");
        map.put("08", "Yantian");
        map.put("06", "Baoan");
        map.put("07", "Longgang");
        map.put("09", "Longhua");
        map.put("10", "Pingshan");
        map.put("11", "Guangming");
        String name = input.next();
        String id = input.next();
        int age = 2026 - Integer.parseInt(id.substring(0, 4));
        boolean gender = Integer.parseInt(id.substring(4, 5)) % 2 != 0;
        System.out.printf("%s is a %s, %d years old, from Shenzhen's %s district\n", name, gender ? "Male" : "Female", age, map.get(id.substring(5)));
    }
}
