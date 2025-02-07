import java.util.List;

public abstract class drone {
    private String ID;
    private String status;
    private double CargoCapacity; //грузоподьемность дрона
    private double currentCargoWeight; // текещий грзовой вес
    private List<String> allowedAtmospheres;
    public drone(String ID, double CargoCapacity, List<String> allowedAtmospheres) { // constructor dlya vizova new Drone()
        this.ID = ID;
        this.status = "IDLE";
        this.CargoCapacity = CargoCapacity;
        this.currentCargoWeight = 0;
        this.allowedAtmospheres = allowedAtmospheres;
    } public drone() {

    }
    public boolean canFlyAtmospheres(String atms) {
        return allowedAtmospheres.contains(atms);
    }
    public String getStatus() {
        return status;
    }
    public double getCargoCapacity() {
        return CargoCapacity;
    }
    public double getCurrentCargoWeight() {
        return currentCargoWeight;
    }
    public String getID() {
        return ID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setID(String ID) {
        this.ID = ID;
    } public void setCargoCapacity(double cargoCapacity) {
        this.CargoCapacity = cargoCapacity;
    }

    public void setCurrentCargoWeight(double currentCargoWeight) {
        this.currentCargoWeight = currentCargoWeight;
    }

    public boolean loadCargo(double weight) { // проверяет поднимет ли груз
        if (currentCargoWeight + weight <= CargoCapacity) {
            currentCargoWeight += weight;
            return true;
        } else {
            return false;
        }
    } public void DropCargo () { // сбрасывает груз если сделал задачу
        currentCargoWeight = 0;
    }
    public abstract double calculateFlightTime(double dist); // абстракт потому-что используется и в легком и в тяжелом дроне
    }

