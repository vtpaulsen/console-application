package airplanes;

import pilots.Pilot;

import java.util.List;

public class PrivateAirplane extends Airplane {

    public PrivateAirplane() {
        super(AirplaneType.PRIVATE, 10_000, 50_000,
                List.of(new Pilot(Pilot.PilotType.PILOT, 100)),
                15, 250, 3);
    }
}
