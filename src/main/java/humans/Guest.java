package humans;

public class Guest {

    private String name;
    private Double wallet;

    public Guest() {
        this.name = "";
        this.wallet = 0.00;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}
