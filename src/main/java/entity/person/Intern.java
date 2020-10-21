package entity.person;

public class Intern extends Employee {
    private Manager managerSupervisor;

    public Intern(String name) {
        this.setName(name);
        this.authorization = false;
    }

    @Override
    public String getPosition() {
        return EmployeeType.INTERN.toString();
    }

    public void setManagerSupervisor(Manager managerSupervisor) {
        this.managerSupervisor = managerSupervisor;
    }

    public void setAuthorization(boolean authorization, Manager manager) {
        if (this.managerSupervisor.comparePasswordAuthorization(manager.getPasswordAuthorization())) {
            if (manager.equals(this.managerSupervisor)) {
                this.authorization = authorization;
            }
        }
    }

    @Override
    public void setAuthorization(boolean authorization) {

    }
}
