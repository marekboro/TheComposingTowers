package rooms;

public class BedRoom extends Room {

    private int roomNumber;
    private RoomType type;

    public BedRoom(int roomNumber, RoomType type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.setCapacity(type.getCapacity());

    }



}
