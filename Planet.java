public class Planet extends CelestialBody{
    private String atmosphereType;
    public Planet(String name, int coordinateX, int coordinateY, String atmosphereType) {
        super(name, coordinateX,coordinateY);
        this.atmosphereType = atmosphereType;
    }

    public String getAtmosphereType() {
        return atmosphereType;
    }

    public void setAtmosphereType(String atmosphereType) {
        this.atmosphereType = atmosphereType;
    }
}
