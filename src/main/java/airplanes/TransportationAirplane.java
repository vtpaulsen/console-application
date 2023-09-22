package airplanes;

import pilots.Pilot;

import java.util.List;

public class TransportationAirplane extends Airplane {

    public TransportationAirplane() {
        super(AirplaneType.TRANSPORTATION, 100_000, 300_000,
                List.of(new Pilot(Pilot.PilotType.CAPTAIN, 200),
                        new Pilot(Pilot.PilotType.STUDENT, 100)),
                8, 200, 12);
    }
}
