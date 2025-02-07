 class CelestialBody {
    private String name;
    private int coordinateX;
    private int CoordinateY;
    public CelestialBody(String name, int coordinateX, int coordinateY) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.CoordinateY = coordinateY;

    } public CelestialBody() {
     }

     public String getName() {
         return name;
     }

     public int getCoordinateX() {
         return coordinateX;
     }

     public int getCoordinateY() {
         return CoordinateY;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setCoordinateX(int coordinateX) {
         this.coordinateX = coordinateX;
     }

     public void setCoordinateY(int coordinateY) {
         CoordinateY = coordinateY;
     }

     public double calculateDistTo(CelestialBody other) {
        int dx = this.coordinateX - other.coordinateX;
        int dy = this.CoordinateY - other.CoordinateY;
        return Math.sqrt(dx * dx + dy * dy);
     }
 }
