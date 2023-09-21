import java.util.List;

public class TransportationAirplane extends Airplane {

    public TransportationAirplane() {
        super(AirplaneType.TRANSPORTATION, 2000, 6000, 3000,200, 200, List.of(new Pilot(PilotType.TRANSPORTATION, 1000)));
    }

}
