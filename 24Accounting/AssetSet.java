public class AssetSet {
    // private field. choice will be a variable that choose something in the departments.
    private int choice;

    private String[] departments = {"IT", "HR", "Finance", "Marketing"};

    // setter method
    public void setChoice(int choice) {
        this.choice = choice;
    }

    // getter method
    public String getChoice() {
        return "Department: " + choice;
    }


    /* I thought that it is very hard to write with bracket. First aroused the object 'AssetSet.
    * Secondly, printed some Strings and with the iteration, it could print each index and value in the departments array.
    * I added some conditional code when the code should stop writing ','.
    * Lastly, printed left String and returned a choice*/
    public String AssetSet() {
        AssetSet as = new AssetSet();

        System.out.print("Enter Department [");
        for (int i = 0; i < departments.length; i++) {
            System.out.printf("%d: %s", i+1, departments[i]);

            if (i != 3) {
                System.out.print(", ");
            }
        }
        System.out.print("]: ");

        return as.getChoice();
    }

    // not a return, just printed with the printf(unction) code, value and index
    public void getAssetSet() {
        System.out.printf("Department: %s (%d)%n", departments[choice-1], choice);
    }
}

