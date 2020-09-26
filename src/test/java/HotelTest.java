import humans.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Randomiser randomiser;
    Hotel hotel;
    Hotel hotelDemo;

    @Before
    public void before(){
        hotel = new Hotel();
        randomiser = new Randomiser();
        hotelDemo = randomiser.createHotelDemo();
    }

    @Test
    public void canAddConferenceRoom(){
        assertEquals(0,hotel.getConferenceRooms().size());
        hotel.addConferenceRoom("The Eagle");
        assertEquals(1,hotel.getConferenceRooms().size());
        assertEquals("The Eagle",hotel.getConferenceRooms().get(0).getName());
    }

    @Test
    public void canAddBedroomsButNotIfRoomNumberAlreadyExists(){
        assertEquals(0,hotel.getBedRooms().size());
        hotel.addSingleRoom(1);
        assertEquals(1,hotel.getBedRooms().size());
        hotel.addSingleRoom(2);
        assertEquals(2,hotel.getBedRooms().size());
        hotel.addSingleRoom(2);
        assertEquals(2,hotel.getBedRooms().size());
        hotel.addFamilyRoom(3);
        assertEquals(3,hotel.getBedRooms().size());
        hotel.addDoubleRoom(1);
        assertEquals(3,hotel.getBedRooms().size());
    }

    @Test
    public void canGetDemoHotelDetails(){
        assertEquals(12,hotelDemo.getBedRooms().size());
        assertEquals("The Mountain",hotelDemo.getConferenceRooms().get(0).getName());
    }

    @Test
    public void canCheckInToRoom(){
        Guest guest = randomiser.getDemoP1();
        hotel.checkin(11,guest);
    }


}
