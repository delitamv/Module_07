public class Fruit {
    private Type type;
    private int shelfLife;
    private String date;
    private int price;

    public Fruit(Type type, int shelfLife, String date, int price) {
        this.type = type;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public enum Type {
        STRAWBERRY,
        APPLE,
        PEAR,
        KIWI,
        GRAPES,
        ORANGE,
        PEACH,
        TANGERINE,
        MELON,
        CHERRY
    }

    public Type getType() {
        return type;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }


}
