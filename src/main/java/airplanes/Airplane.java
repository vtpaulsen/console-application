package airplanes;

import pilots.Pilot;

import java.util.List;

public abstract class Airplane {

    public enum AirplaneType {
        PASSENGER, TRANSPORTATION, PRIVATE
    }

    private AirplaneType airplaneType;
    private int emptyWeight;

    private int totalWeight = emptyWeight;
    private int maxTakeoffWeight;
    private List<Pilot> pilots;
    private int maximumPassengers;
    private int currentNumberOfPassengers;
    private int currentFuelCapacity;
    private int maximumSpeed;
    private int fuelConsumptionPerKilometer;
    private static final int FUEL_PRICE_PER_KG = 15;

    public Airplane(AirplaneType airplaneType, int emptyWeight, int maxTakeoffWeight, List<Pilot> pilots, int maximumPassengers, int maximumSpeed, int fuelConsumptionPerKilometer) {
        // Initialize fields here
        this.airplaneType = airplaneType;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.pilots = pilots;
        this.maximumPassengers = maximumPassengers;
        this.maximumSpeed = maximumSpeed;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public String calculateFlightTime(int distance) {
        double flightTime = distance / (double) maximumSpeed * 60;
        int hours = (int) flightTime / 60;
        int minutes = (int) flightTime % 60;
        return hours + " hours and " + minutes + " minutes";
    }

    public int calculateFuelConsumption(int distance) {
        return distance * fuelConsumptionPerKilometer;
    }

    public void addCargo(int weight) {
        if (weight + emptyWeight > maxTakeoffWeight) {
            throw new IllegalArgumentException("The cargo is too heavy for this airplane!");
        } else {
            totalWeight += weight;
        }
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }

    public int getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public List<Pilot> getPilotList() {
        return pilots;
    }

    public String getPilotNames() {
        StringBuilder pilotNames = new StringBuilder();
        for (int i = 0; i < pilots.size(); i++) {
            pilotNames.append(pilots.get(i).getType());
            if (i < pilots.size() - 1) {
                pilotNames.append(", ");
            }
        }
        return pilotNames.toString();
    }

    public int getMaximumPassengers() {
        return maximumPassengers;
    }

    public void setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
        if (currentNumberOfPassengers > maximumPassengers) {
            throw new IllegalArgumentException("The number of passengers exceeds the maximum capacity of this airplane!");
        } else this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

    public void setCurrentFuelCapacity(int currentFuelCapacity) {
        this.currentFuelCapacity = currentFuelCapacity;
    }

    public int getFuelConsumptionPerKilometer() {
        return fuelConsumptionPerKilometer;
    }

    public int getTotalCost(int distance) {
        int fuel = calculateFuelConsumption(distance) * FUEL_PRICE_PER_KG;
        int totalHourlySalary = 0;
        for (Pilot p : pilots) {
            totalHourlySalary += p.getHourly_salary();
        }
        double flightTime = distance / (double) maximumSpeed * 60;
        int hours = (int) flightTime / 60;
        totalHourlySalary *= hours;
        return fuel + totalHourlySalary;
    }
}











