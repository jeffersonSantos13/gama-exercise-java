package entity.vehicle;

import interfaces.IVehicle;

import java.util.UUID;

public abstract class Vehicles implements IVehicle {
    private String number;
    private double value;
    private double IPI;
    private int quantityFinance;
    private double financePercentage;
    private double discount;

    public Vehicles() {
        UUID uuid = UUID.randomUUID();
        this.number = uuid.toString();
        this.financePercentage = 1.89;
        this.discount = 10;
    }

    void setFinancePercentage(double financePercentage) {
        this.financePercentage = financePercentage;
    }

    void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinancePercentage() {
        return financePercentage;
    }

    public void setQuantityFinance(int quantityFinance) {
        this.quantityFinance = quantityFinance;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public double getValue() {
        return this.value;
    };

    public void setIPI(double IPI) {
        this.IPI = IPI;
    };

    public double getIPI() {
        return this.IPI;
    }

    public abstract double getCarValue();

    public double getDiscount() {
        return discount;
    }

    public void resultSoldVehicle() {
        this.setValue(this.getCarValue());

        if (this.quantityFinance > 0) {
            double valueCar = this.value;

            for (int i = 0; i < this.quantityFinance; i++) {
                double newValueFinance = (this.financePercentage / 100) * valueCar;
                valueCar += newValueFinance;
            }

            setDiscount(0);
            setValue(valueCar);
        } else {
            setFinancePercentage(0);
            setValue(this.value - (this.value * ( discount / 100)));
        }

    }

    @Override
    public String toString() {
        return "\tVeículo" +
                "\n\tNumber: " + this.number +
                "\n\tValue: " + this.value +
                "\n\tIPI: " + this.IPI +
                "\n\tQuantidade financiamento: " + this.quantityFinance +
                "\n\tPorcentagem financiamento: " + this.financePercentage +
                "\n\tDesconto: discount " + this.discount +
                "\n";
    }
}
