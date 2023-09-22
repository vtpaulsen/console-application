import airplanes.*;
import pilots.Pilot;

import java.util.*;

public class Simulator {
    private final Scanner reader = new Scanner(System.in);
    private final List<Airport> airports = new ArrayList<>();
    private final List<Airplane> airplanes = new ArrayList<>();

    private Airplane chosenAirplane;
    private Airport chosenDepartureAirport;
    private Airport chosenArrivalAirport;
    private int distance;

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.initialize();
    }

    public void initialize() {
        setUp();

        System.out.println("\n************************ Airplane Simulator ************************");
        System.out.println("Welcome to the Airplane Simulator!\n");

        // Start the game
        start();
    }

    public void start() {
        System.out.println("The available airports are: ");
        printAirportList();
        chosenDepartureAirport = selectAirport("Please select a departure airport: ");
        chosenArrivalAirport = selectAirport("Please select an arrival airport: ");

        if (!chosenDepartureAirport.equals(chosenArrivalAirport)) {
            System.out.println("You have chosen to fly from " + chosenDepartureAirport + " to " + chosenArrivalAirport + ".\n");

            System.out.println("The available airplanes are: ");
            printAirplaneList();
            Airplane airplane = selectAirplane();
            System.out.println("You have chosen to fly with the " + airplane.getAirplaneType() + " airplane.\n");
            chosenAirplane = airplane;

            List<Pilot> pilots = airplane.getPilotList();
            if (!pilots.isEmpty()) {
                System.out.print("The pilot(s) for this flight is/are: ");
                for (int i = 0; i < pilots.size(); i++) {
                    System.out.print(pilots.get(i).getType());
                    if (i < pilots.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(".\n");
            } else {
                System.out.println("No pilot assigned to this airplane.\n");
            }
        } else {
            System.out.println("Invalid selection. Departure and arrival airports cannot be the same. Please try again.\n");
            start();
        }

        // Select the amount of fuel in kg
        int fuel = selectFuelAmount();
        System.out.println("You have selected " + fuel + " kg of fuel.\n");

        // Select the number of passengers
        int passengers = selectPassengerAmount();
        System.out.println("You have selected " + passengers + " passengers.\n");

        // Select the amount of cargo in kg
        int cargo = selectCargoAmount();
        System.out.println("You have selected " + cargo + " kg of cargo.\n");

        // The total cost


        // Summary of the flight
        System.out.println("Summary of the flight:");
        System.out.println(" You are flying from " + chosenDepartureAirport.getName() + " to " + chosenArrivalAirport.getName() + " with the " + chosenAirplane.getAirplaneType() + " airplane.");
        System.out.println(" The distance between the airports is " + distance + " km, with an estimated flight time of " + chosenAirplane.calculateFlightTime(distance));
        System.out.println(" The pilot(s) for this flight is/are: " + chosenAirplane.getPilotNames());
        System.out.println(" The fuel consumption for this flight is estimated to be " + chosenAirplane.calculateFuelConsumptionInKg(distance) + " kg.");
        System.out.println(" The total cost for this fligt is : " + chosenAirplane.getTotalCost(distance) + " DKK");

        // End the game
        end();
    }

    private int selectCargoAmount() {
        while (true) {
            try {
                System.out.print("Please select the amount of cargo in kg: ");
                int cargo = reader.nextInt();
                if (cargo >= 0) {
                    if (cargo > chosenAirplane.getMaxTakeoffWeight() - chosenAirplane.getEmptyWeight()) {
                        System.out.println("The airplane can only carry " + (chosenAirplane.getMaxTakeoffWeight() - chosenAirplane.getEmptyWeight()) + " kg of cargo. Please try again.");
                    } else {
                        chosenAirplane.addCargo(cargo);
                        return cargo;
                    }
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.next(); // Clear the invalid input
            }
        }
    }

    private int selectPassengerAmount() {
        while (true) {
            try {
                System.out.print("Please select the number of passengers: ");
                int passengers = reader.nextInt();
                if (passengers >= 0) {
                    if (passengers > chosenAirplane.getMaximumPassengers()) {
                        System.out.println("The airplane can only carry " + chosenAirplane.getMaximumPassengers() + " passengers. Please try again.");
                    } else {
                        chosenAirplane.setCurrentNumberOfPassengers(passengers);
                        return passengers;
                    }
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.next(); // Clear the invalid input
            }
        }
    }



    public int selectFuelAmount() {
        while (true) {
            try {
                System.out.println("The chosen airplane has a consumption of " + chosenAirplane.getFuelConsumptionPerKilometer() + " kg per 100 km.");
                distance = (int) DistanceCalculator.distance(chosenDepartureAirport, chosenArrivalAirport, "K");
                int fuelNeeded = distance * chosenAirplane.getFuelConsumptionPerKilometer();
                System.out.println("You need at least " + fuelNeeded + " kg of fuel.");
                System.out.print("Please select the amount of fuel in kg: ");
                int fuel = reader.nextInt();
                if (fuel >= 0 && fuel >= fuelNeeded) {
                    chosenAirplane.setCurrentFuelCapacity(fuel);
                    return fuel;
                } else {
                    System.out.println("The airplane needs at least " + fuelNeeded + " kg of fuel. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.next(); // Clear the invalid input
            }
        }
    }

    private void end() {
        System.out.println("\nThank you for playing the Airplane Simulator!");
        System.exit(0);
    }

    private void printAirportList() {
        for (int i = 0; i < airports.size(); i++) {
            System.out.println((i + 1) + ". " + airports.get(i).getName());
        }
    }

    private void printAirplaneList() {
        for (int i = 0; i < airplanes.size(); i++) {
            System.out.println((i + 1) + ". " + capitalize(airplanes.get(i).getAirplaneType().toString()));
        }
    }

    private Airport selectAirport(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int choice = reader.nextInt();
                if (choice >= 1 && choice <= airports.size()) {
                    return airports.get(choice - 1);
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.next(); // Clear the invalid input
            }
        }
    }

    private Airplane selectAirplane() {
        while (true) {
            try {
                System.out.print("Please select an airplane: ");
                int choice = reader.nextInt();
                if (choice >= 1 && choice <= airplanes.size()) {
                    return airplanes.get(choice - 1);
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.next(); // Clear the invalid input
            }
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public void setUp() {
        // Initialize airports and airplanes here
        // Add the appropriate objects to the 'airports' and 'airplanes' lists
        airports.add(new Airport("Aarhus", 56.2999988, 10.617997528));
        airports.add(new Airport("Aalborg", 55.73749705, 9.150999396));
        airports.add(new Airport("Billund", 57.088999644, 9.842829962));
        airports.add(new Airport("Heathrow", 51.470020, -0.454295));
        airports.add(new Airport("New York", 40.641766, -73.780968));
        airports.add(new Airport("Guatamala City", 14.576497694, -90.522997908));
        airports.add(new Airport("Hanoi", 21.221200943, 105.807998657));

        airplanes.add(new PrivateAirplane());
        airplanes.add(new PassengerAirplane());
        airplanes.add(new TransportationAirplane());
    }
}
