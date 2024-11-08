import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public enum MainMenuEnum {
        RegisterAssets(1, "Register Assets"),
        SearchAssets(2, "Search Assets"),
        SaveToCSV(3, "Save Assets to CSV"),
        Exit(9, "Exit");

        private final int number;
        private final String title;

        MainMenuEnum(int number, String title) {
            this.number = number;
            this.title = title;
        }

        public int getNumber() {
            return number;
        }

        public String getTitle() {
            return title;
        }

        static void displayMenu() {
            System.out.println("ITM Asset Management System");
            for (MainMenuEnum i : MainMenuEnum.values()) {
                System.out.println(i.getNumber() + ". " + i.getTitle());
            }
        }
    }

    public enum RegisterAssetMenuEnum {
        Hardware(1, "Hardware"),
        Software(2, "Software"),
        BacktoMainMenu(3, "Back to Main Menu");

        private final int number;
        private final String title;

        RegisterAssetMenuEnum(int number, String title) {
            this.number = number;
            this.title = title;
        }

        public int getNumber() {
            return number;
        }

        public String getTitle() {
            return title;
        }

        static void displayMenu() {
            System.out.println("Register Asset");
            for (RegisterAssetMenuEnum i : RegisterAssetMenuEnum.values()) {
                System.out.println(i.getNumber() + ". " + i.getTitle());
            }
        }
    }

    public enum SearchAssetMenuEnum {
        Fullsearch(1, "Fullsearch"),
        Byhardware(2, "By Hardware"),
        Bysoftware(3, "By Software"),
        Backtomainmenu(9, "Back to the Main Menu");

        private final int number;
        private final String title;

        SearchAssetMenuEnum(int number, String title) {
            this.number = number;
            this.title = title;
        }

        public int getNumber() {
            return number;
        }

        public String getTitle() {
            return title;
        }

        static void displayMenu() {
            System.out.println("Search Asset");
            for (SearchAssetMenuEnum i : SearchAssetMenuEnum.values()) {
                System.out.println(i.getNumber() + ". " + i.getTitle());
            }
        }
    }

    public enum DepartmentEnum {
        IT,
        Finance,
        HR,
        Marketing
    }

    public enum HardwarecategoryEnum {
        Input(1, "Input"),
        Processing(2, "Processing"),
        Storage(3, "Storage"),
        Output(4, "Output"),
        Communication(5, "Communication");

        private final int number;
        private final String title;

        HardwarecategoryEnum(int number, String title) {
            this.number = number;
            this.title = title;
        }

        public int getNumber() {
            return number;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class Hardware {
        private int id;
        private String name;
        private DepartmentEnum department;
        private HardwarecategoryEnum category;
        private float price;

        // Constructor
        public Hardware(int id, String name, DepartmentEnum department, HardwarecategoryEnum category, float price) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.category = category;
            this.price = price;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public DepartmentEnum getDepartment() {
            return department;
        }

        public HardwarecategoryEnum getCategory() {
            return category;
        }

        public float getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Hardware [id=" + id + ", name=" + name + ", department=" + department + ", category=" + category
                    + ", price=" + price + "]";
        }
    }

    public static class Software {
        private int id;
        private String name;
        private DepartmentEnum department;
        private float price;
        private String licenseKey;

        // Constructor
        public Software(int id, String name, DepartmentEnum department, float price, String licenseKey) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.price = price;
            this.licenseKey = licenseKey;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public DepartmentEnum getDepartment() {
            return department;
        }

        public float getPrice() {
            return price;
        }

        public String getLicenseKey() {
            return licenseKey;
        }

        @Override
        public String toString() {
            return "Software [id=" + id + ", name=" + name + ", department=" + department + ", price=" + price
                    + ", licenseKey=" + licenseKey + "]";
        }
    }

    public static class AssetSet {
        private List<Hardware> hardwareAssets;
        private List<Software> softwareAssets;

        public AssetSet() {
            hardwareAssets = new ArrayList<>();
            softwareAssets = new ArrayList<>();
        }

        // Getter methods to retrieve the lists
        public List<Hardware> getHardwareAssets() {
            return hardwareAssets;
        }

        public List<Software> getSoftwareAssets() {
            return softwareAssets;
        }
    }

    private static AssetSet assetSet = new AssetSet();

    private static void registerHardware(Scanner scanner) {
        try {
            System.out.println("Enter Hardware ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter Hardware Name:");
            String name = scanner.nextLine();

            DepartmentEnum department;
            while (true) {
                try {
                    System.out.println("Enter Department (IT, Finance, HR, Marketing):");
                    department = DepartmentEnum.valueOf(scanner.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid department. Please enter a valid department.");
                }
            }

            System.out.println("Enter Category (1: Input, 2: Processing, 3: Storage, 4: Output, 5: Communication):");
            HardwarecategoryEnum category = HardwarecategoryEnum.values()[scanner.nextInt() - 1];

            System.out.println("Enter Price:");
            float price = scanner.nextFloat();

            Hardware hardware = new Hardware(id, name, department, category, price);
            assetSet.getHardwareAssets().add(hardware);

            System.out.println("Hardware registered successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.next();
            registerHardware(scanner);
        }
    }

    private static void registerSoftware(Scanner scanner) {
        try {
            System.out.println("Enter Software ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter Software Name:");
            String name = scanner.nextLine();

            DepartmentEnum department;
            while (true) {
                try {
                    System.out.println("Enter Department (IT, Finance, HR, Marketing):");
                    department = DepartmentEnum.valueOf(scanner.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid department. Please enter a valid department.");
                }
            }

            System.out.println("Enter Price:");
            float price = scanner.nextFloat();
            scanner.nextLine();

            System.out.println("Enter License Key:");
            String licenseKey = scanner.nextLine();

            Software software = new Software(id, name, department, price, licenseKey);
            assetSet.getSoftwareAssets().add(software);

            System.out.println("Software registered successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.next(); // Clear the invalid input
            registerSoftware(scanner); // Retry
        }
    }

    private static void displayAllHardware() {
        List<Hardware> hardwareList = assetSet.getHardwareAssets();
        if (hardwareList.isEmpty()) {
            System.out.println("No hardware assets found.");
        } else {
            System.out.println("Hardware Assets:");
            for (Hardware hardware : hardwareList) {
                System.out.println(hardware);
            }
        }
    }

    private static void displayAllSoftware() {
        List<Software> softwareList = assetSet.getSoftwareAssets();
        if (softwareList.isEmpty()) {
            System.out.println("No software assets found.");
        } else {
            System.out.println("Software Assets:");
            for (Software software : softwareList) {
                System.out.println(software);
            }
        }
    }

    // Method to save assets to CSV
    private static void saveAssetsToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(System.getProperty("user.home") + "/Downloads/assets.csv"))) {
            writer.println("Type,ID,Name,Department,Category/LicenseKey,Price");

            for (Hardware hardware : assetSet.getHardwareAssets()) {
                writer.printf("Hardware,%d,%s,%s,%s,%.2f%n",
                        hardware.getId(),
                        hardware.getName(),
                        hardware.getDepartment(),
                        hardware.getCategory(),
                        hardware.getPrice());
            }

            for (Software software : assetSet.getSoftwareAssets()) {
                writer.printf("Software,%d,%s,%s,%s,%.2f%n",
                        software.getId(),
                        software.getName(),
                        software.getDepartment(),
                        software.getLicenseKey(),
                        software.getPrice());
            }

            System.out.println("Assets saved to assets.csv successfully.");
        } catch (IOException e) {
            System.err.println("Error saving assets to CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        boolean flag = true;
        while (flag) {
            MainMenuEnum.displayMenu();
            System.out.println("Enter your choice:");
            a = sc.nextInt();
            if (a > 10) {
                System.out.println("Error: Invalid choice");
                continue;
            }
            switch (a) {
                case 1:
                    int y;
                    boolean flag1 = true;
                    while (flag1) {
                        RegisterAssetMenuEnum.displayMenu();
                        y = sc.nextInt();
                        switch (y) {
                            case 1:
                                registerHardware(sc);
                                break;
                            case 2:
                                registerSoftware(sc);
                                break;
                            case 3:
                                flag1 = false;
                                System.out.println("Returning to the main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }
                    }
                    break;
                case 2:
                    int z;
                    boolean flag2 = true;
                    while (flag2) {
                        SearchAssetMenuEnum.displayMenu();
                        System.out.print("Enter your choice: ");
                        z = sc.nextInt();
                        switch (z) {
                            case 1:
                                displayAllHardware();
                                displayAllSoftware();
                                break;
                            case 2:
                                displayAllHardware();
                                break;
                            case 3:
                                displayAllSoftware();
                                break;
                            case 9:
                                flag2 = false;
                                System.out.println("Returning to the main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }
                    }
                    break;
                case 3:
                    saveAssetsToCSV();
                    break;
                case 9:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        sc.close();
    }
}
