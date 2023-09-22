package pilots;

public class Pilot {

    public enum PilotType {
        PILOT, CAPTAIN, STUDENT
    }

    private PilotType type;
    private int hourly_salary;

    public Pilot(PilotType type, int hourly_salary) {
        this.type = type;
        this.hourly_salary = hourly_salary;
    }

    public int getHourly_salary() {
        return hourly_salary;
    }

    public PilotType getType() {
        return type;
    }

}
