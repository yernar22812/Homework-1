 class DeliveryTask {
    private CelestialBody origin;
    private CelestialBody dest;
    private Cargo cargo;
    private drone assignedDrone;
    public DeliveryTask(CelestialBody origin, CelestialBody dest, Cargo cargo ) {
        this.origin = origin;
        this.dest = dest;
        this.cargo = cargo;
    } public boolean assignDrone(drone Drone) {
        if (origin instanceof Planet) {
            Planet planet = (Planet) origin;
            if (!Drone.canFlyAtmospheres(planet.getAtmosphereType())) {
                System.out.println(("Drone " + Drone.getID() + " cannot fly in atmosphere: " + planet.getAtmosphereType()));
                return false;
            }
        }


        double distance = origin.calculateDistTo(dest);
        double flightTime = Drone.calculateFlightTime(distance);
        if (Drone.loadCargo(cargo.getWeight())) {
            assignedDrone = Drone;
            Drone.setStatus("IN WoooOOOOoork");
            System.out.println("Drone " + Drone.getID() + " assigned. Estimated flight time: " + flightTime + " hours.");
            return true;

        }
            return false;
        }
     public void completeTask() {
        if (assignedDrone != null) {
            assignedDrone.DropCargo();
            assignedDrone.setStatus("IDLE");
        }
         }

     public CelestialBody getDest() {
         return dest;
     }

     public void setDest(CelestialBody dest) {
         this.dest = dest;
     }  public drone getAssignedDrone() {
         return assignedDrone;
     }
 }

