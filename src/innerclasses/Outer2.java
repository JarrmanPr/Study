package innerclasses;

public class Outer2 {

    private static int defValue;
    private int defValue2;

    public void setDefValue2(int val2) {
        defValue2 = val2;
    }

    public static class Inner2 {

        public void setDefValue(int val) {
            Outer2.defValue = val;
        }

        public static void changeValue(int val) {
            Outer2.defValue = val;
        }

        public static int getDefValue() {
            return Outer2.defValue;
        }
    }
}
