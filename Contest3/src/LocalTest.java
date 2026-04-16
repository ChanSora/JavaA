import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.lang.reflect.*;

public class LocalTest {

    private static ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private static PrintStream originalOut = System.out;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input 1-5 to test your code:");
        if (!in.hasNextInt()) return;
        int a = in.nextInt();

        switch (a) {
            case 1: test1(); break;
            case 2: test2(); break;
            case 3: test3(); break;
            case 4: test4(); break;
            case 5: test5(); break;
            default: System.out.println("Invalid test point.");
        }
        in.close();
    }

    private static void startCapture() {
        baos.reset();
        System.setOut(new PrintStream(baos));
    }

    private static String stopCapture() {
        System.out.flush();
        System.setOut(originalOut);
        return baos.toString().trim().replaceAll("\\r\\n", "\n");
    }

    // --- 测试点 1：测试 Parcel 类的封装与 print ---
    public static void test1() {
        try {
            Class<?> clazz = Class.forName("Parcel");
            Constructor<?> ctor = clazz.getDeclaredConstructor(String.class, char.class, int.class);
            Object obj = ctor.newInstance("P001", 'A', 15);

            Method print = clazz.getMethod("print");

            startCapture();
            print.invoke(obj);
            String output = stopCapture();

            String expected = "[P001] (A) {15}kg";
            if (expected.equals(output)) {
                System.out.println("AC");
            } else {
                System.out.println("WA. Expected '" + expected + "', but got '" + output + "'");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("RE: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("RE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("RE: " + e.getMessage());
        }
    }

    // --- 测试点 2：测试 DeliveryBox 类的 isValidBox 和单包裹 print ---
    public static void test2() {
        try {
            Class<?> pClass = Class.forName("Parcel");
            Class<?> bClass = Class.forName("DeliveryBox");

            Constructor<?> pCtor = pClass.getDeclaredConstructor(String.class, char.class, int.class);
            Constructor<?> bCtorSingle = bClass.getDeclaredConstructor(pClass, char.class);

            Object p1 = pCtor.newInstance("P002", 'B', 10);
            Object box = bCtorSingle.newInstance(p1, 'B'); // 合法单包裹箱子
            Object badBox = bCtorSingle.newInstance(p1, 'A'); // 非法单包裹箱子

            Method isValidBox = bClass.getMethod("isValidBox");
            boolean valid1 = (boolean) isValidBox.invoke(box);
            boolean valid2 = (boolean) isValidBox.invoke(badBox);

            Method print = bClass.getMethod("print");
            startCapture();
            print.invoke(box);
            String output = stopCapture();

            if (valid1 && !valid2 && "B_P002_Empty".equals(output)) {
                System.out.println("AC");
            } else {
                System.out.println("WA. Valid1:" + valid1 + " Valid2:" + valid2 + " Out:" + output);
            }
        } catch (Exception e) {
            System.out.println("RE: " + e.getMessage());
        }
    }

    // --- 测试点 3：测试 DeliveryBox 双包裹排序逻辑 ---
    public static void test3() {
        try {
            Class<?> pClass = Class.forName("Parcel");
            Class<?> bClass = Class.forName("DeliveryBox");

            Constructor<?> pCtor = pClass.getDeclaredConstructor(String.class, char.class, int.class);
            Constructor<?> bCtorDouble = bClass.getDeclaredConstructor(pClass, pClass, char.class);

            // 制造重量相同，测试是否按字典序排序 (X999 和 A001)
            Object p1 = pCtor.newInstance("X999", 'C', 50);
            Object p2 = pCtor.newInstance("A001", 'C', 50);
            Object box = bCtorDouble.newInstance(p1, p2, 'C');

            Method print = bClass.getMethod("print");
            startCapture();
            print.invoke(box);
            String output = stopCapture();

            if ("C_A001_X999".equals(output)) {
                System.out.println("AC");
            } else {
                System.out.println("WA. Expected 'C_A001_X999', got '" + output + "'");
            }
        } catch (Exception e) {
            System.out.println("RE: " + e.getMessage());
        }
    }

    // --- 测试点 4：测试 LogisticsSystem.check() ---
    public static void test4() {
        try {
            Class<?> pClass = Class.forName("Parcel");
            Class<?> bClass = Class.forName("DeliveryBox");
            Class<?> sClass = Class.forName("LogisticsSystem");

            Constructor<?> pCtor = pClass.getDeclaredConstructor(String.class, char.class, int.class);
            Constructor<?> bCtorSingle = bClass.getDeclaredConstructor(pClass, char.class);

            Object p1 = pCtor.newInstance("A1", 'A', 10);
            Object p2 = pCtor.newInstance("B1", 'B', 20);
            System.out.println("...1");
            Object parcelArray = Array.newInstance(pClass, 2);
            Array.set(parcelArray, 0, p1);
            Array.set(parcelArray, 1, p2);

            // p1 放错了区 (A区包裹放进B区箱子)，p2 没打包
            Object badBox = bCtorSingle.newInstance(p1, 'B');
            Object boxArray = Array.newInstance(bClass, 1);
            Array.set(boxArray, 0, badBox);
            System.out.println("...2");
            Method checkMethod = sClass.getMethod("check", parcelArray.getClass(), boxArray.getClass());
            System.out.println("...3");
            System.out.println("parcelArray 实际类型: " + parcelArray.getClass().getName());
            System.out.println("boxArray 实际类型: " + boxArray.getClass().getName());

            Object resultObj = checkMethod.invoke(null, parcelArray, boxArray);
            if (resultObj == null) {
                System.out.println("WA");
                return;
            }

            int length = Array.getLength(resultObj);
            if (length == 2) {
                System.out.println("AC");
            } else {
                System.out.println("WA. Expected 2 errors, got " + length);
            }
        } catch (Exception e) {
            System.out.println("RE: " + e.getMessage());
        }
    }

    // --- 测试点 5：测试 LogisticsSystem.autoPack() ---
    public static void test5() {
        try {
            Class<?> pClass = Class.forName("Parcel");
            Class<?> sClass = Class.forName("LogisticsSystem");
            Constructor<?> pCtor = pClass.getDeclaredConstructor(String.class, char.class, int.class);

            // 3个A区包裹，故意让最轻的那个落单
            Object p1 = pCtor.newInstance("P1", 'A', 50);
            Object p2 = pCtor.newInstance("P2", 'A', 40);
            Object p3 = pCtor.newInstance("P3", 'A', 60);

            Object parcelArray = Array.newInstance(pClass, 3);
            Array.set(parcelArray, 0, p1);
            Array.set(parcelArray, 1, p2);
            Array.set(parcelArray, 2, p3);

            Method packMethod = sClass.getMethod("autoPack", parcelArray.getClass());
            Object resultBoxes = packMethod.invoke(null, parcelArray);

            if (resultBoxes == null) {
                System.out.println("WA");
                return;
            }

            int length = Array.getLength(resultBoxes);
            if (length == 2) {
                System.out.println("AC");
            } else {
                System.out.println("WA. Expected 2 boxes, got " + length);
            }
        } catch (Exception e) {
            System.out.println("RE: " + e.getMessage());
        }
    }
}