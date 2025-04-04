public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight = 0;
    private int limit;

    public static int totalPriceBasket = 0;
    public static int totalItem = 0;



    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseTotalPriceBasket(int count, int price) {
        Basket.totalPriceBasket = Basket.totalPriceBasket + count * price;
    }

    public static int getTotalPriceBasket() {
        return totalPriceBasket;
    }

    public static void increaseItem (int items) {
        Basket.totalItem = Basket.totalItem + items;
    }

    public static int getTotalItem() {
        return totalItem;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static double calculateAveragePriceBasket() {
        return (double) totalPriceBasket / totalItem;
    }

    public static double calculateAverageBasket() {
        return (double) totalPriceBasket / count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        increaseItem(count);
        increaseTotalPriceBasket(count, price);
            boolean error = false;

            if (contains(name)) {

                error = true;

            }

            if (totalPrice + count * price >= limit) {

                error = true;

            }

            if (error) {

                System.out.println("Error occured :(");

                return;

            }

            items = items + "\n" + name + " - " +

                    count + " шт. - " + price;

            totalPrice = totalPrice + count * price;

    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        totalWeight = totalWeight + count * weight;
        items = items + ", " + (count * weight) + " кг.";
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
