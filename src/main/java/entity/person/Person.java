package entity.person;

public abstract class Person {
    private String name;
    private int age;
    private boolean deficient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getDeficient() {
        return deficient;
    }

    public void setDeficient(boolean deficient) {
        this.deficient = deficient;
    }
}
