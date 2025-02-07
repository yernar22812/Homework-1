public class Main {
    public static void main(String[] args) {
        LightDrone lightDrone = new LightDrone("drone 1",10);
        HeavyDrone heavyDrone = new HeavyDrone("drone 2",20);

        // Создаем небесные тела
        Planet earth = new Planet("Earth", 0, 0, "Oxygen-rich");
        Planet mars = new Planet("Mars", 50, 50, "Thin");
        Planet venus = new Planet("Venus", 100, 100, "Dense");
        SpaceStation iss = new SpaceStation("ISS", 200, 200, 5);

        // Создаем груз
        Cargo cargo1 = new Cargo(5, "Medical Supplies");
        Cargo cargo2 = new Cargo(30, "Equipment");

        // Создаем и проверяем задачи
        DeliveryTask task1 = new DeliveryTask(earth, mars, cargo1); // Земля -> Марс (разреженная)
        DeliveryTask task2 = new DeliveryTask(mars, iss, cargo2);   // Марс -> Станция
        DeliveryTask task3 = new DeliveryTask(venus, iss, cargo1);  // Венера -> Станция (плотная атмосфера)

        System.out.println("Assigning cargo1 to LightDrone: " + task1.assignDrone(lightDrone)); // Должно сработать
        System.out.println("Assigning cargo2 to HeavyDrone: " + task2.assignDrone(heavyDrone)); // Должно сработать
        System.out.println("Assigning cargo1 to LightDrone on Venus: " + task3.assignDrone(lightDrone)); // Должно отказать

        // Завершаем задания
        task1.completeTask();
        task2.completeTask();

        System.out.println("LightDrone Status after task: " + lightDrone.getStatus());
        System.out.println("HeavyDrone Status after task: " + heavyDrone.getStatus());
    }
}
