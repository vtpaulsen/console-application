package airplanes;

import pilots.Pilot;
import pilots.PilotType;

import java.util.List;

public class PrivateAirplane extends Airplane {

    public PrivateAirplane() {
        super(AirplaneType.PRIVATE, 10_000, 20_000, List.of(new Pilot(PilotType.PILOT, 100)), 15, 1000, 250, 3);

    }
}
