public class Software {
    // fields are private
    private int SoftwareID;
    private String SoftwareName;
    private float SoftwarePrice;
    private String SoftwareLicenseKey;

    // 13 to 27 lines are setting ID, Name, Price, License Key. I wrote this becase parameter and field names are same.
    // Additionally, with the void code, there is no print.
    public void setSoftwareID(int SoftwareID) {
        this.SoftwareID = SoftwareID;
    }

    public void setSoftwareName(String SoftwareName) {
        this.SoftwareName = SoftwareName;
    }

    public void setSoftwarePrice(float SoftwarePrice) {
        this.SoftwarePrice = SoftwarePrice;
    }

    public void setSoftwareLicenseKey(String SoftwareLicenseKey) {
        this.SoftwareLicenseKey = SoftwareLicenseKey;
    }


    // 28 to 43 lines are getting ID, Name, Price, License Key. In the upper code, I wrote the set code.
    // Therefore, in the lower code, it is possible to get fields with return quote.
    public String getSoftwareID() {
        return "ID: " + SoftwareID;
    }

    public String getSoftwareName() {
        return "Name: " + SoftwareName;
    }

    public String getSoftwarePrice() {
        return "Price: $" + SoftwarePrice;
    }

    public String getSoftwareLicenseKey() {
        return "License Key: " + SoftwareLicenseKey;
    }
}
