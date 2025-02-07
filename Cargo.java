public class Cargo {
    private double weight;
    private String descrip;
    public Cargo(double weight, String descrip) {
        this.weight = weight;
        this.descrip = descrip;
    }
    public double getWeight() {
        return weight;
    }

    public String getDestination() {
        return descrip;
    }

    public void setDestination(String destination) {
        this.descrip = destination;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
