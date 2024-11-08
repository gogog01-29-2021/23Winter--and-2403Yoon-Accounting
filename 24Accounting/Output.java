import java.util.Scanner;

public class Output {

    /*aroused the Object and enum's method, and printed Hardware and Software part.
     The explanations of each method in objects are in each class.*/
    public static void main(String[] args) {
        Hardware.HardwareCategoryEnum first = Hardware.HardwareCategoryEnum.Input;
        Scanner sc = new Scanner(System.in);
        Hardware hd = new Hardware();
        AssetSet as = new AssetSet();
        Software sw = new Software();

        System.out.println("--- Register New Hardware ---");
        System.out.print("Enter Hardware ID: ");
        hd.setHardwareID(sc.nextInt());

        sc.nextLine(); // this code could remove newline String which left because of the sc.nextInt().
        System.out.print("Enter Hardware Name: ");
        hd.setHardwareName(sc.nextLine());

        as.AssetSet();
        as.setChoice(sc.nextInt());

        first.cases();
        first.setChoice(sc.nextInt());

        System.out.print("Enter Price: ");
        hd.setHardwarePrice(sc.nextFloat());

        System.out.println();
        System.out.println();

        System.out.println("Hardware registered successfully!");
        System.out.println(hd.getHardwareID());
        System.out.println(hd.getHardwareName());
        as.getAssetSet();
        System.out.println(first.getCategory());
        System.out.println(hd.getHardwarePrice());


        System.out.println();
        System.out.println();

        System.out.println("--- Register New Software ---");
        System.out.print("Enter Software ID: ");
        sw.setSoftwareID(sc.nextInt());

        sc.nextLine();
        System.out.print("Enter Software Name: ");
        sw.setSoftwareName(sc.nextLine());

        as.AssetSet();
        as.setChoice(sc.nextInt());

        System.out.print("Enter Price: ");
        sw.setSoftwarePrice(sc.nextFloat());

        System.out.print("Enter License Key: ");
        sw.setSoftwareLicenseKey(sc.next());


        System.out.println();
        System.out.println();

        System.out.println("Software registered successfully!");
        System.out.println(sw.getSoftwareID());
        System.out.println(sw.getSoftwareName());
        as.getAssetSet();
        System.out.println(sw.getSoftwarePrice());
        System.out.println(sw.getSoftwareLicenseKey());
    }
}
