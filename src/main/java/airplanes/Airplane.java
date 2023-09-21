import java.util.List;

public abstract class Airplane {

    AirplaneType type;

    List<Pilot> pilots;
    int max_weight;
    int passenger_count;
    int fuel_capacity;
    int max_speed;
    int fuel_consumption_kilogrames_per_hour;

    public Airplane(AirplaneType type, int max_weight, int passenger_count, int fuel_capacity, int max_speed, int fuel_consumption_kilogrames_per_hour, List<Pilot> pilots) {
        this.type = type;
        this.pilots = pilots;
        this.max_weight = max_weight;
        this.passenger_count = passenger_count;
        this.fuel_capacity = fuel_capacity;
        this.max_speed = max_speed;
        this.fuel_consumption_kilogrames_per_hour = fuel_consumption_kilogrames_per_hour;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    public int getMax_weight() {
        return max_weight;
    }

    public void setMax_weight(int max_weight) {
        this.max_weight = max_weight;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getFuel_capacity() {
        return fuel_capacity;
    }

    public void setFuel_capacity(int fuel_capacity) {
        this.fuel_capacity = fuel_capacity;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public int getPrice() {
        return 100;
    }


    public int getFuel_consumption_kilogrames_per_hour() {
        // The fuel usage is given in liters per 100 km
        return fuel_consumption_kilogrames_per_hour;
    }


}

