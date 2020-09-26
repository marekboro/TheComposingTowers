package rooms;

public class ConferenceRoom extends Room {

    private String name;
    private double initialPrice;
    private double priceAdditionalGuest;
    private double finalPrice;
    private int defaultGuests;

    public ConferenceRoom(String name) {
        this.name = name;
        this.initialPrice = 1500.00;
        this.priceAdditionalGuest = 40;
        this.finalPrice = determineFinalPrice();
        this.defaultGuests = 30;


    }

    public double determineFinalPrice() {
        double returned = initialPrice;
        for (int i = defaultGuests; i < getGuests().size(); i++) {
            returned += priceAdditionalGuest;
        }
        return returned;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getPriceAdditionalGuest() {
        return priceAdditionalGuest;
    }

    public void setPriceAdditionalGuest(double priceAdditionalGuest) {
        this.priceAdditionalGuest = priceAdditionalGuest;
    }

    public double getFinalPrice() {
        setFinalPrice(determineFinalPrice());
        return finalPrice;
    }

    public void setFinalPrice(double total) {
        this.finalPrice = total;
    }

    public int getDefaultGuests() {
        return defaultGuests;
    }

    public void setDefaultGuests(int defaultGuests) {
        this.defaultGuests = defaultGuests;
    }
}
