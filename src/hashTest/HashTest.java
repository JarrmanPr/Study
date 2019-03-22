package hashtest;

public class HashTest {

    /*static {
        System.out.println("static");
    }*/

    public static void main(String args[]) {

        Test o1 = new Test(3,4);
        Test o2 = new Test(3, 4);
        Test o3 = new Test(3, 4);
        Test o4 = new Test(3,4);
        String string = new String("hello");

        //Test o4 = new Test(3, 4);

        System.out.println("Рефлексивность \no1.equals(o1): " + o1.equals(o1));
        System.out.println("o1.hashCode(): " + o1.hashCode());
        System.out.print("Симметричность \no1.equals(o2): " + o1.equals(o2));
        System.out.println("\no2.equals(o1): " + o2.equals(o1));
        System.out.println("o2.hashCode(): " + o2.hashCode());
        System.out.print("Транзитивность \no1.equals(o2): " + o1.equals(o2));
        System.out.print("\no2.equals(o3): " + o2.equals(o3));
        System.out.println("\no1.equals(o3): " + o1.equals(o3));
        System.out.println("o3.hashCode(): " + o3.hashCode());
        System.out.println("Согласованность (после o2.a = 5)");
        o2.a = 5;
        System.out.println("o1.equals(o2): " + o1.equals(o2));
        System.out.println("o2.hashCode(): " + o2.hashCode());
        System.out.println("Сравнение с объектом другого класса");
        System.out.print("o1.equals(string): " + o1.equals(string));
        System.out.println("\nПроверка на null");
        o4 = null;
        System.out.println(o1.equals(o4));
    }
}
