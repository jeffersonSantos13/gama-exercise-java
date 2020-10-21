package entity.person;

public class Client extends Person {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\tCliente" +
                "\n\tNome: " + this.getName() +
                "\n\tÉ deficiente: " + ( this.getDeficient() ? "Sim" : "Não") +
                "\n";
    }
}
