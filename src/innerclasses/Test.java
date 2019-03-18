package innerclasses;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Test {
    public static void main(String args[]) {

        //Outer.Inner out = new Outer().new Inner();

        // доступ к внешнему классу
        Outer out = new Outer();
        System.out.println(out.a);
        System.out.println(out.getB());
        out.setB(56);
        System.out.println(out.getB());

        // доступ к внутреннему классу
        Outer.Inner outin = new Outer().new Inner();
        System.out.println(outin.c);
        System.out.println(outin.getD());
        outin.setD(57);
        System.out.println(outin.getD());
        System.out.println(Outer.statOut);
        System.out.println(Outer.getStatOut());

        // 2 доступ к внутреннему классу
        Outer.Inner_2 outin2 = new Outer().new Inner_2();
        System.out.println(outin2.f);
        System.out.println(outin2.getG());
        System.out.println(outin.getD());

        out.test();
        System.out.println(outin.getD());  // ??? возвр 78


        // Тестирование статических вложенных классов
        System.out.println("Static class testing ...");
        Outer2.Inner2 staticClass = new Outer2.Inner2();
        staticClass.setDefValue(5);
        System.out.println(staticClass.getDefValue());
        staticClass.changeValue(20);
        System.out.println(staticClass.getDefValue());

        Outer2.Inner2 staticClass2 = new Outer2.Inner2();
        staticClass2.setDefValue(40);
        System.out.println(staticClass.getDefValue());

        //Тестирование локальных классов
        System.out.println("Local classes testing ...");
        int heroLevel = 15; // пусть уровень героя - 15й
        int heroTrophy = 0;
        // обьявляем новую локацию, персонажи по очереди заходят в нее
        Location location = new Location();
        System.out.println(location.getName());

        location.setHeroLevelValue(heroLevel);
        heroTrophy = location.setTrophyValue();
        System.out.println("\tFirst hero trophy: " + heroTrophy);

        int hero2Level = 20; // пусть уровень героя - 15й
        int hero2Trophy = 0;
        location.setHeroLevelValue(hero2Level);
        hero2Trophy = location.setTrophyValue();
        System.out.println("\tSecond hero trophy: " + hero2Trophy);
        System.out.println(location.getName());

        // Тестирование анонимных классов
        Car car1 = new Car();
        car1.startEngine();
        car1.drive();

        /*Car car2 = new Car(){
            void drive(){
                super.drive();
                System.out.println("Driiiiive!");
            }

            @Override
            void startEngine(){
                System.out.println("Start Super engine");
            }
        };

        car2.startEngine();
        car2.drive();*/

        //Test t1 = new Test();
        //t1.show();
    }
}
