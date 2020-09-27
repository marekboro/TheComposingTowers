import humans.Guest;
import org.junit.Before;
import org.junit.Test;
import rooms.BedRoom;
import rooms.RoomType;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
    public void canGetRoomByNumber(){
        BedRoom a = hotelDemo.getBedroomByNumber(11);
        assertEquals(RoomType.SINGLE,a.getType());
        BedRoom b = hotelDemo.getBedroomByNumber(1);
        assertEquals(RoomType.FAMILY,b.getType());
    }

    @Test
    public void canCheckInSingleAndGroupToRoomButNotBeyondCapacity(){
        // SINGLE ROOM
        Guest guest1 = randomiser.getDemoP1();
        Guest guest2 = randomiser.getDemoP2();
        BedRoom room = hotelDemo.getBedroomByNumber(11);
        //
        assertEquals(0,room.getGuests().size());
        hotelDemo.checkIn(11,guest1);
        assertEquals(1,room.getGuests().size());
        //
        Guest guestInRoom = room.getGuests().get(0);
        assertEquals(guest1,guestInRoom);
        //
        hotelDemo.checkIn(11,guest2);
        assertEquals(1,room.getGuests().size());
        // FAMILY ROOM:
        ArrayList<Guest> testGroupFive = randomiser.groupDemo05;
        BedRoom familyRoom = hotelDemo.getBedroomByNumber(1);
        assertEquals(0,familyRoom.getGuests().size());
        hotelDemo.checkIn(1,testGroupFive);
        assertEquals(5,familyRoom.getGuests().size());

    }

    @Test
    public void canCheckoutSingleOrGroupsProvidedAllAreGuestsOfHotel(){
        ArrayList<Guest> testGroupFour = randomiser.groupDemo04;
        BedRoom room = hotelDemo.getBedroomByNumber(1);
        hotelDemo.checkIn(1,testGroupFour);  //Steven Rambo missing
        Guest g1 = room.getGuests().get(0);
        Guest g2 = room.getGuests().get(1);
        Guest g3 = room.getGuests().get(2);
        Guest g4 = room.getGuests().get(3);
        assertEquals(g1,testGroupFour.get(0));
        assertEquals(g2,testGroupFour.get(1));
        assertEquals(g3,testGroupFour.get(2));
        assertEquals(g4,testGroupFour.get(3));
        assertEquals(4,room.getGuests().size());
        assertTrue(hotelDemo.getAllGuests().containsKey(g1));
        assertTrue(hotelDemo.getAllGuests().containsKey(g2));
        assertTrue(hotelDemo.getAllGuests().containsKey(g3));
        assertTrue(hotelDemo.getAllGuests().containsKey(g4));

        Guest missingGuest = randomiser.getDemoP4();
        assertFalse(hotelDemo.getAllGuests().containsKey(missingGuest));
        hotelDemo.checkOut(missingGuest);
        assertEquals(4,room.getGuests().size());
        assertEquals(4,hotelDemo.getAllGuests().size());
        hotelDemo.checkOut(testGroupFour);
        assertEquals(0,room.getGuests().size());
        assertEquals(0,hotelDemo.getAllGuests().size());
        hotelDemo.checkIn(1,testGroupFour);
        hotelDemo.checkOut(g1);
        assertEquals(3,room.getGuests().size());
        assertEquals(3,hotelDemo.getAllGuests().size());
    }


    @Test
    public void canCreateBookingThatHasACostAndWhichWillUpdateBankAccount(){
        Booking booking = hotelDemo.bookRoom(hotelDemo.getBedroomByNumber(11),3);
        assertEquals(booking,hotelDemo.getBookings().get(0));
        assertEquals(3450.0,hotelDemo.getBankAccount(),0.01);
        assertTrue(hotelDemo.getBookings().contains(booking));

    }

    @Test
    public void canCreateDiningRoomsWhichWillAddToHashCollectionDiningrooms(){
        hotelDemo.addDiningRoom("Sunny");
        hotelDemo.addDiningRoom("Happy");
        assertEquals(2, hotelDemo.getDiningRooms().size());

    }


    @Test
    public void canGetVacantRoomsList(){
        ArrayList<Guest> testGroupFour = randomiser.groupDemo04;
        ArrayList<Guest> testGroupOne = randomiser.groupDemo01;
        ArrayList<Guest> testGroupTwo = randomiser.groupDemo02;
        ArrayList<Guest> testGroupThree = randomiser.groupDemo03;
        Guest guest1 = randomiser.getDemoP1();
        assertEquals(12, hotelDemo.getBedRooms().size());
        assertEquals(12, hotelDemo.getVacantBedrooms().size());
        hotelDemo.checkIn(1,testGroupFour);
        hotelDemo.checkIn(2,testGroupThree);
        hotelDemo.checkIn(4,testGroupTwo);
        hotelDemo.checkIn(9,testGroupOne);
        hotelDemo.checkIn(10,guest1);
        assertEquals(12, hotelDemo.getBedRooms().size());
        assertEquals(7, hotelDemo.getVacantBedrooms().size());

    }

}
