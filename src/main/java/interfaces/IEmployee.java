package interfaces;

import entity.person.Employee;

public interface IEmployee {
    String getPosition();
    boolean seal();
    boolean getAuthorization();
    void setAuthorization(boolean authorization);
}
