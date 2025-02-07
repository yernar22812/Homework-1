import java.util.Arrays;

class LightDrone extends drone {
    private double speed;
    public LightDrone(String ID, double speed) {
        super(ID, 10, Arrays.asList("Oxygen-rich", "Thin")); // 10 поднимает
       this.speed = speed;

    }

    @Override
    public double calculateFlightTime(double dist) {
        return dist/speed;
    }
}
