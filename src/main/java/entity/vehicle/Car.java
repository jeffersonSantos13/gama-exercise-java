package entity.vehicle;

public class Car extends Vehicles {
    public Car() {
        setIPI(1.15);
    }

    @Override
    public String getIdVehicle() {
        return this.getNumber();
    }

    @Override
    public double getCarValue() {
        return this.getValue() * this.getIPI();
    }
}
