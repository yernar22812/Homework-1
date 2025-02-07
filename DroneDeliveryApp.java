import java.util.*;
public class DroneDeliveryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<drone> drones = new ArrayList<>();
    private static List<CelestialBody> celestialBodies = new ArrayList<>();
    public static List<DeliveryTask> tasks = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== DRONE DELIVERY SYSTEM ===");
            System.out.println("1. Добавить дрон");
            System.out.println("2. Добавить небесное тело");
            System.out.println("3. Создать задачу доставки");
            System.out.println("4. Показать статус дронов");
            System.out.println("5. Завершить задачу");
            System.out.println("0. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addDrone();
                case 2 -> addCelestialBody();
                case 3 -> createDeliveryTask();
                case 4 -> showDronesStatus();
                case 5 -> completeTask();
                case 0 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private static void addDrone() {
        System.out.println("Выберите тип дрона:");
        System.out.println("1. Легкий дрон (LightDrone)");
        System.out.println("2. Тяжелый дрон (HeavyDrone)");
        int type = scanner.nextInt();
        System.out.println("Ведите ID дрона: ");
        String id = scanner.nextLine();
        System.out.println("Введите скорость: ");
        double sp = scanner.nextDouble();


        scanner.nextLine();
        drone Drone;
        if (type == 1) {
            Drone = new LightDrone(id,sp);
        } else if (type ==2) {
            Drone = new HeavyDrone(id,sp);
        } else {
            System.out.println("выбирите один или два");
            return;
        }
        drones.add(Drone);
        System.out.println("ДРОН " + id + " Успешно добавлен!");

    }
    private static void addCelestialBody() {
        System.out.print("Введите название небесного тела: ");
        String name = scanner.nextLine();

        System.out.print("Введите координату X: ");
        int x = scanner.nextInt();
        System.out.print("Введите координату Y: ");
        int y = scanner.nextInt();
        scanner.nextLine();

        System.out.println("1. Планета");
        System.out.println("2. Космическая станция");
        int type = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Введите тип атмосферы: ");
            String atmosphere = scanner.nextLine();
            celestialBodies.add(new Planet(name, x, y, atmosphere));
        } else if (type == 2) {
            System.out.print("Введите уровень станции: ");
            int level = scanner.nextInt();
            scanner.nextLine();
            celestialBodies.add(new SpaceStation(name, x, y, level));
        } else {
            System.out.println("Неверный выбор.");
        }
        System.out.println("Небесное тело добавлено!");
    }
public static void createDeliveryTask() {
        if (drones.isEmpty() || celestialBodies.size() < 2) {
            System.out.println("Недостатосно данных добавьте дронов и небесные тела 2 штуки мин ");
            return;
        }
    System.out.println("Выберите место отправки:");
    for (int i = 0; i < celestialBodies.size(); i++) {
        System.out.println(i + ". " + celestialBodies.get(i).getName());
    }
    int originIndex = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Выберите место назначения:");
    for (int i = 0; i < celestialBodies.size(); i++) {
        if (i != originIndex) {
            System.out.println(i + ". " + celestialBodies.get(i).getName());
        }
    }
    int destinationIndex = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Введите вес груза: ");
    double weight = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Введите описание груза: ");
    String description = scanner.nextLine();

    Cargo cargo = new Cargo(weight, description);
    DeliveryTask task = new DeliveryTask(celestialBodies.get(originIndex), celestialBodies.get(destinationIndex), cargo);

    System.out.println("Выберите дрон для доставки:");
    for (int i = 0; i < drones.size(); i++) {
        System.out.println(i + ". " + drones.get(i).getID() + " [" + drones.get(i).getStatus() + "]");
    }
    int droneIndex = scanner.nextInt();
    scanner.nextLine();

    if (task.assignDrone(drones.get(droneIndex))) {
        tasks.add(task);
        System.out.println("Задача успешно создана и назначена на дрон " + drones.get(droneIndex).getID());
    } else {
        System.out.println("Не удалось назначить дрон.");
    }
}

    private static void showDronesStatus() {
        if (drones.isEmpty()) {
            System.out.println("Дронов пока нет.");
            return;
        }

        System.out.println("=== Статус дронов ===");
        for (drone Drone : drones) {
            System.out.println("ID: " + Drone.getID() + ", Статус: " + Drone.getStatus() +
                    ", Груз: " + Drone.getCurrentCargoWeight() + "/" + Drone.getCargoCapacity());
        }
    }

    private static void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("Нет активных задач.");
            return;
        }

        System.out.println("Выберите задачу для завершения:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).getAssignedDrone().getID() + " -> " + tasks.get(i).getDest().getName());
        }
        int taskIndex = scanner.nextInt();
        scanner.nextLine();

        tasks.get(taskIndex).completeTask();
        tasks.remove(taskIndex);
        System.out.println("Задача завершена!");
    }
}

