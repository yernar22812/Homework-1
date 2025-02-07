import java.util.Arrays;

public class HeavyDrone extends drone {
    private double speed;
    public HeavyDrone(String ID,double speed) {
        super(ID,50, Arrays.asList("No Atmosphere", "Thin")); // 50 поднимает
        this.speed = speed;
    }

    @Override
    public double calculateFlightTime(double dist) {
        return dist/speed;
    }
}
