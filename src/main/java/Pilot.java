public class Pilot {

    private String type;
    private int salary;

    public Pilot(String type, int salary) {
        this.type = type;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getType() {
        return type;
    }
}
