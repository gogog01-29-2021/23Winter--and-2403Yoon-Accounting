public class Hardware {
    // fields are private
    private int HardwareID;
    private String HardwareName;
    private float HardwarePrice;

    // 8 to 18 lines are set ID, Name, Price. I wrote this becase parameter and field names are same.
    // Additionally, with the void code, there is no print.
    public void setHardwareID(int HardwareID) {
        this.HardwareID = HardwareID;
    }

    public void setHardwareName(String HardwareName) {
        this.HardwareName = HardwareName;
    }

    public void setHardwarePrice(float HardwarePrice) {
        this.HardwarePrice = HardwarePrice;
    }


    // 23 to 33 lines are getter code. each code returns value which set the name before.
    public String getHardwareID() {
        return "ID: " + HardwareID;
    }

    public String getHardwareName() {
        return "Name: " + HardwareName;
    }

    public String getHardwarePrice() {
        return "Price: $" + HardwarePrice;
    }

    // separated enum, because this code only adjust to 'Category'. Each enum needs number and title.
    public enum HardwareCategoryEnum {
        Input(1, "Input"),
        Processing(2, "Processing"),
        Storage(3,"Storage"),
        Output(4, "Output"),
        Communication(5,"Communication");

        // private fields. Number and title are enum's fields, and choice is the number which select the enum's number.
        private final int number;
        private final String title;
        private int choice;

        // just setting Enum to use
        HardwareCategoryEnum(int number, String title) {
            this.number = number;
            this.title = title;
        }

        // Enum's number getter code
        public int getNumber() {
            return number;
        }

        // Enum's title getter code
        public String getTitle() {
            return title;
        }

        /* It is same with AssetSet's departments.
        Firstly, printed some strings.
         Secondly, wrote iteration to print each number and title in enum.
         I wrote some conditional code, because there are five enums but it only requires 4 apostrophe, so in the last number, if the number is same as the choice, code do not print apostrophe.
         */
        void cases(){
            System.out.print("Enter Hardware Category [");
            for (HardwareCategoryEnum list1 : HardwareCategoryEnum.values()) {
                System.out.print(list1.getNumber() + ": " + list1.getTitle());
                if (list1.getNumber() != 5) {
                    System.out.print(", ");
                }
            }
            System.out.print("]: ");
        }

        // choice setter code
        public void setChoice(int choice) {
            this.choice = choice;
        }

        // If the number is same as enum's number, each number and value same as choice will be printed. Therefore, I wrote 5 conditional code.
        public String getCategory() {
            if (choice == Input.getNumber()) {
                return "Category: " + Input.getTitle() + " (" + Input.getNumber() + ")";
            }
            else if (choice == Processing.getNumber()) {
                return "Category: " + Processing.getTitle() + " (" + Processing.getNumber() + ")";
            }
            else if (choice == Storage.getNumber()) {
                return "Category: " + Storage.getTitle() + " (" + Storage.getNumber() + ")";
            }
            else if (choice == Output.getNumber()) {
                return "Category: " + Output.getTitle() + " (" + Output.getNumber() + ")";
            }
            else if (choice == Communication.getNumber()) {
                return "Category: " + Communication.getTitle() + " (" + Communication.getNumber() + ")";
            }

            else return null;
        }
    }
}
