import java.util.List;

public class PrivateAirplane extends Airplane {

    public PrivateAirplane() {
        super(AirplaneType.PRIVATE, 1000,1500, 500, 150, 30, List.of(
                    new Pilot(PilotType.PRIVATE, 1000)
                )
        );
    }
}
