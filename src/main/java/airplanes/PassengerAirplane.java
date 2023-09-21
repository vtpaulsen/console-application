package airplanes;

import pilots.Pilot;
import pilots.PilotType;

import java.util.List;

public class PassengerAirplane extends Airplane {

    public PassengerAirplane() {
        super(AirplaneType.PASSENGER, 50_000, 100_000, List.of(new Pilot(PilotType.PILOT, 100)), 400, 1000, 250, 6);
    }
}
