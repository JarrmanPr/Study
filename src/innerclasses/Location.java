package innerclasses;

public class Location {

    private String name = "Пещера Хьялмара";
    private int heroLevelValue;

    public void setHeroLevelValue(int heroLevelValue) {
        this.heroLevelValue = heroLevelValue;
    }

    public String getName() {
        return name;
    }

    public int setTrophyValue() {

        int boxValue = 5;

        class Box {
            int value;
            private int defNumberOfCoins = 100;

            int setTropfy() {
                value = heroLevelValue * defNumberOfCoins;
                return value;
            }

            void set() {
                name = "ghtrjy";
                /*т.о., используя локальный класс внутри какой-то локации, можно создать
                что-то вроде события, и поменять название локации на имя героя и т.д.*/
            }
        }

        Box box = new Box();
        boxValue = box.setTropfy();
        box.set();
        return boxValue;
    }
}
