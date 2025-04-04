import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Delivery delivery = new Delivery("N/A ",false,"N/A",1,false, new Dimensions(1,2,1));
        Delivery copy = new Delivery(
                delivery.getDeliveryAddress(),
                delivery.getFlipPproperty(),
                delivery.getRegistrationNumber(),
                delivery.getWeight(),
                delivery.getFragility(),
                delivery.getDimensions()
        );

        copy = copy.setDimensions(new Dimensions(1,3,4));

        delivery.print();
        copy.print();



        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

    }
}
