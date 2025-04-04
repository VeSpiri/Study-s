public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");

        Basket basket1 = new Basket();
        basket1.add("Milk", 40, 2, 0.75);
        basket1.add("Pancake", 600, 3, 1);
        basket.print("Basket: ");

        System.out.println(Basket.getTotalPriceBasket());
        System.out.println(Basket.getTotalItem());
        System.out.println(Basket.calculateAveragePriceBasket());
        System.out.println(Basket.calculateAverageBasket());
    }
}
