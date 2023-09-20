package main;

public class Airplane {

    private AirplaneTypes type;
    private int max_weight;
    private int passenger_count;
    private int fuel_capacity;
    private int max_speed;

    public Airplane(AirplaneTypes type, int max_weight, int passenger_count, int fuel_capacity, int max_speed) {
        this.type = type;
        this.max_weight = max_weight;
        this.passenger_count = passenger_count;
        this.fuel_capacity = fuel_capacity;
        this.max_speed = max_speed;
    }

    public AirplaneTypes getType() {
        return type;
    }

    public void setType(AirplaneTypes type) {
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
}
