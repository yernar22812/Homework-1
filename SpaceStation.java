 class SpaceStation extends CelestialBody {
     private int StationLevel;

     public SpaceStation(String name, int coordinateX, int coordinateY, int StationLevel) {
         super(name, coordinateX, coordinateY);
         this.StationLevel = StationLevel;
     }
 }