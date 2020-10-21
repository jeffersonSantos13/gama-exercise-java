package entity.person;

public class Manager extends Employee {
    private String password;
    private String passwordAuthorization;

    public Manager(String name) {
        this.setName(name);
        this.authorization = true;
        this.password = "ADMIN123";
    }

    public String getPasswordAuthorization() {
        return passwordAuthorization;
    }

    public void setPasswordAuthorization(String passwordAuthorization) {
        this.passwordAuthorization = passwordAuthorization;
    }

    public boolean comparePasswordAuthorization(String password) {
        return this.password.equals(password);
    }

    @Override
    public String getPosition() {
        return EmployeeType.MANAGER.toString();
    }

    @Override
    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }
}