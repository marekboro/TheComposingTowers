import rooms.BedRoom;

public class Booking {

    private BedRoom room;
    private int nights;
    private double cost;

    public Booking(BedRoom room, int nights) {
        this.room = room;
        this.nights = nights;
        this.cost = room.getRate()*nights;

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public BedRoom getRoom() {
        return room;
    }

    public void setRoom(BedRoom room) {
        this.room = room;
        this.cost = room.getRate()*nights;

    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
        this.cost = room.getRate()*nights;
    }





}
