package entity.person;

import interfaces.IEmployee;

public abstract class Employee extends Person implements IEmployee {
    public boolean authorization;

    @Override
    public boolean seal() {
        boolean employeeType = EmployeeType.valueOf(this.getPosition()).equals(EmployeeType.INTERN);

        if (employeeType && !authorization) {
            return false;
        }

        return true;
    }

    @Override
    public boolean getAuthorization() {
        return this.authorization;
    }

    @Override
    public abstract void setAuthorization(boolean authorization);

    @Override
    public String toString() {
        return "\tEmpregado" +
                "\n\tNome: " + this.getName() +
                "\n\tCargo: " + this.getPosition() +
                "\n";
    }
}
