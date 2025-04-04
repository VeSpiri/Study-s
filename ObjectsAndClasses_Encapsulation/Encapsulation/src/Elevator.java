public class Elevator {
    private int minFloor;
    private int maxFloor;
    private int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("error");
            return;
        }
        if (currentFloor < floor) {
            for (; currentFloor < floor; moveUp()) {
                System.out.println(currentFloor);
            }
            System.out.println("Вы прибыли на этаж: " + floor);
            return;
        }
        for (; currentFloor > floor; moveDown()) {
            System.out.println(currentFloor);
            }
        System.out.println("Вы прибыли на этаж: " + floor);
        }
}

