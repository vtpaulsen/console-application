import java.util.List;

public class PassengerAirplane extends Airplane {

    public PassengerAirplane() {
        super(AirplaneType.PASSENGER, 1500, 3000, 1000,250, 100, List.of(new Pilot(PilotType.PASSENGER, 1000)));
    }
}
