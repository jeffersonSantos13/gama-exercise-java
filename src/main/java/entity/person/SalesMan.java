package entity.person;

public class SalesMan extends Employee {
    public SalesMan(String name) {
        this.setName(name);
        this.authorization = true;
    }

    @Override
    public String getPosition() {
        return EmployeeType.SALESMAN.toString();
    }

    @Override
    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }
}
