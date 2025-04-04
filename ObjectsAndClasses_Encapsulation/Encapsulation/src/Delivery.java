import java.awt.*;

public class Delivery {
    private final String deliveryAddress;
    private final boolean flipPproperty; // 0 - no, 1 - yes
    private final String registrationNumber;
    private final double weight;
    private final boolean fragility; // 0 - no, 1 - yes
    private final Dimensions dimensions;

    public Delivery(String deliveryAddress, boolean flipPproperty, String registrationNumber, double weight, boolean fragility, Dimensions dimensions) {
        this.deliveryAddress = deliveryAddress;
        this.flipPproperty = flipPproperty;
        this.registrationNumber = registrationNumber;
        this.weight = weight;
        this.fragility = fragility;
        this.dimensions = dimensions;
    }

    public Delivery setDeliveryAddress(String deliveryAddress) {
        return  new Delivery(deliveryAddress, flipPproperty, registrationNumber, weight, fragility, dimensions);
    }

    public Delivery setWeight(double weight) {
        return  new Delivery(deliveryAddress, flipPproperty, registrationNumber, weight, fragility, dimensions);
    }

    public Delivery setDimensions(Dimensions dimensions) {
        return  new Delivery(deliveryAddress, flipPproperty, registrationNumber, weight, fragility, dimensions);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean getFlipPproperty() {
        return flipPproperty;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getFragility() {
        return fragility;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void print() {
        System.out.println(deliveryAddress + " " + registrationNumber + " " + weight + " " + fragility + " " + flipPproperty + " " + dimensions.getVolume());
    }
}
