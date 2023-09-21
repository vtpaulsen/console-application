package airplanes;

import pilots.Pilot;
import pilots.PilotType;

import java.util.List;

public class TransportationAirplane extends Airplane {

    public TransportationAirplane() {
        super(AirplaneType.TRANSPORTATION, 100_000, 300_000, List.of(new Pilot(PilotType.CAPTAIN, 200), new Pilot(PilotType.STUDENT, 100)), 8, 1500, 200, 12);
    }

}
