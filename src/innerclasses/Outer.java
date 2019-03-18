package innerclasses;

public class Outer {

    static int statOut = 20;

    public static int getStatOut() {
        return statOut;
    }

    int a = 1;
    private int b = 11;

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    void test(){  // ??????
        Inner in = new Inner();
        in.setD(55);
    }

    class Inner extends Outer{

        //static int re = 8; ОШИБКА Внутренний класс не может содержать
        // статических переменнных
        int c = 2;
        private int d = 22;

        public void setD(int d) {
            this.d = d;
        }

        public int getD() {
            return d + a + statOut;
        }
    }

    class Inner_2 extends Inner{
        int f = 3;
        private int g = 33;

        public int getG() {
            return g;
        }

        public void inner2Method() {
            System.out.println("Метод внутреннего класса");
        }
    }
}
