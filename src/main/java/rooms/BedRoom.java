package rooms;


public class BedRoom extends Room {

    private int roomNumber;
    private RoomType type;
    private Double rate;

    public BedRoom(int roomNumber, RoomType type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.setCapacity(type.getCapacity());
        this.rate = 150.0*getCapacity();

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
