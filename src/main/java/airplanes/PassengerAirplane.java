package airplanes;

import pilots.Pilot;

import java.util.List;

public class PassengerAirplane extends Airplane {

    public PassengerAirplane() {
        super(AirplaneType.PASSENGER, 50_000, 200_000,
                List.of(new Pilot(Pilot.PilotType.PILOT, 100)),
                400, 250, 6);
    }
}
