package hashtest;

// new line

//import java.util.Objects;

public class Test {

    static {
        System.out.println("static");
    }

    int a;
    int b;
    private int hashCode = 0;

    public Test(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Test t = (Test) obj;
        return a == t.a &&
                b == t.b;
    }

    @Override
    public int hashCode() {
        // 1 ВАРИАНТ
        /*final int value = 0;
        int result = 1;
        result += (a + b);
        return result;*/

        // 2 ВАРИАНТ
        int result = hashCode;
        result = 31 * result + Integer.hashCode(a);
        result = 31 * result + Integer.hashCode(b);
        return result;
    }
}
