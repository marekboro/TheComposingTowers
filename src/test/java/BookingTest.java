import org.junit.Before;
import org.junit.Test;
import rooms.BedRoom;
import rooms.RoomType;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    BedRoom bedRoom;
    Booking booking2;
    BedRoom bedRoom2;
    BedRoom bedRoom3;

    @Before
    public void before(){
        bedRoom = new BedRoom(1, RoomType.FAMILY);
        booking = new Booking(bedRoom,3);

        bedRoom2 = new BedRoom(2, RoomType.SINGLE);
        booking2 = new Booking(bedRoom2,4);
        bedRoom3 = new BedRoom(3, RoomType.DOUBLE);
    }

    @Test
    public void shouldHaveARoom(){
        assertEquals(bedRoom,booking.getRoom());
        assertEquals(bedRoom2,booking2.getRoom());
    }
    @Test
    public void shouldHaveARoomNumberAndCanChangeIt(){
        assertEquals(1,booking.getRoom().getRoomNumber());
        assertEquals(2,booking2.getRoom().getRoomNumber());
        booking.getRoom().setRoomNumber(3);
        assertEquals(3,booking.getRoom().getRoomNumber());
    }
    @Test
    public void shouldHaveABookingDurationNights(){
        assertEquals(3,booking.getNights());
        assertEquals(4,booking2.getNights());
    }
    @Test
    public void shouldHaveACostProportionalToType(){
        assertEquals(2250.0,booking.getCost(),0.01);
        assertEquals(600.0,booking2.getCost(),0.01);
    }

    @Test
    public void canUpdateRoomAndNightsWhichWillModifyCost(){
        assertEquals(bedRoom2,booking2.getRoom());
        assertEquals(600.0,booking2.getCost(),0.01);
        booking2.setRoom(bedRoom3);
        assertEquals(1200.0,booking2.getCost(),0.01);
        booking2.setNights(2);
        assertEquals(600.0,booking2.getCost(),0.01);
    }

    @Test
    public void canManuallySetCost(){
        assertEquals(bedRoom2,booking2.getRoom());
        assertEquals(600.0,booking2.getCost(),0.01);
        booking2.setCost(500.00);
        assertEquals(500.0,booking2.getCost(),0.01);

    }




}
