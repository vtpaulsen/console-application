package airplanes;

import pilots.Pilot;

import java.util.List;

public abstract class Airplane {

    public String calculateFlightTime(int distance) {
        double flightTime = distance / (double) maximumSpeed * 60;
        int hours = (int) flightTime / 60;
        int minutes = (int) flightTime % 60;
        return hours + " hours and " + minutes + " minutes";
    }

    public int calculateFuelConsumptionInKg(int distance) {
        return distance * fuelConsumptionPerKilometer;
    }

    public enum AirplaneType {
        PASSENGER, TRANSPORTATION, PRIVATE
    }

    // Airplane properties
    AirplaneType airplaneType;
    int emptyWeight;
    int maxTakeoffWeight;
    List<Pilot> pilots;
    int maximumPassengers;
    int currentNumberOfPassengers;
    int maximumFuelCapacity;
    int currentFuelCapacity;
    int maximumSpeed;
    int fuelConsumptionPerKilometer;

    public Airplane(AirplaneType airplaneType, int emptyWeight, int maxTakeoffWeight, List<Pilot> pilots, int maximumPassengers, int maximumFuelCapacity, int maximumSpeed, int fuelConsumptionPerKilometer) {
        this.airplaneType = airplaneType;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.pilots = pilots;
        this.maximumPassengers = maximumPassengers;
        this.currentNumberOfPassengers = 0;
        this.maximumFuelCapacity = maximumFuelCapacity;
        this.currentFuelCapacity = 0;
        this.maximumSpeed = maximumSpeed;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public void addCargo(int weight) {
        if (weight + emptyWeight + currentFuelCapacity > maxTakeoffWeight) {
            System.out.println("The cargo is too heavy for this airplane!");
        } else {
            currentFuelCapacity += weight;
        }
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(int emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public int getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(int maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public List<Pilot> getPilotList() {
        return pilots;
    }

    public String getPilotNames() {
        String pilotNames = "";
        for (int i = 0; i < pilots.size(); i++) {
            pilotNames += pilots.get(i).getType();
            if (i < pilots.size() - 1) {
                pilotNames += ", ";
            }
        }
        return pilotNames;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public int getMaximumPassengers() {
        return maximumPassengers;
    }

    public void setMaximumPassengers(int maximumPassengers) {
        this.maximumPassengers = maximumPassengers;
    }

    public int getCurrentNumberOfPassengers() {
        return currentNumberOfPassengers;
    }

    public void setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
        this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

    public int getMaximumFuelCapacity() {
        return maximumFuelCapacity;
    }

    public void setMaximumFuelCapacity(int maximumFuelCapacity) {
        this.maximumFuelCapacity = maximumFuelCapacity;
    }

    public int getCurrentFuelCapacity() {
        return currentFuelCapacity;
    }

    public void setCurrentFuelCapacity(int currentFuelCapacity) {
        this.currentFuelCapacity = currentFuelCapacity;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getFuelConsumptionPerKilometer() {
        return fuelConsumptionPerKilometer;
    }

    public void setFuelConsumptionPerKilometer(int fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public int getTotalCost(int distance) {
        int fuel = calculateFuelConsumptionInKg(distance) * 20; // 15 is the current price for a kg of fuel
        int totalHourlySalary = 0;
        for (Pilot p : pilots) {
            totalHourlySalary =+ p.getHourly_salary();
        }
        double flightTime = distance / (double) maximumSpeed * 60;
        int hours = (int) flightTime / 60;
        totalHourlySalary *= hours;
        int totalCost = fuel + totalHourlySalary;
        return totalCost;
    }
}

