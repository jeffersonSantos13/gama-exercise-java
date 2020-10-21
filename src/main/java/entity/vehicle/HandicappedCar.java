package entity.vehicle;

public class HandicappedCar extends Vehicles {
    @Override
    public String getIdVehicle() {
        return this.getNumber();
    }

    @Override
    public double getCarValue() {
        return this.getValue();
    }

}
