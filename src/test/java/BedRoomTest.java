import humans.Guest;
import org.junit.Before;
import org.junit.Test;
import rooms.BedRoom;
import rooms.RoomType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BedRoomTest {

    BedRoom bedRoom1;
    BedRoom bedRoom2;
    BedRoom bedRoom3;
    BedRoom bedRoom5;

    Guest guest1;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Guest guest5;

    ArrayList<Guest> guests1;
    ArrayList<Guest> guests2;
    ArrayList<Guest> guests3;
    ArrayList<Guest> guests4;
    ArrayList<Guest> guests5;

    @Before
    public void before(){
        // CREATE GUESTLists
        guests1 = new ArrayList<Guest>();
        guests2 = new ArrayList<Guest>();
        guests3 = new ArrayList<Guest>();
        guests4 = new ArrayList<Guest>();
        guests5 = new ArrayList<Guest>();

        //CREATE BEDROOMS TO TEST
        bedRoom1 = new BedRoom(1, RoomType.SINGLE);
        bedRoom2 = new BedRoom(2, RoomType.DOUBLE);
        bedRoom3 = new BedRoom(3, RoomType.TRIPLE);
        bedRoom5 = new BedRoom(4, RoomType.FAMILY);

        //CREATE GUESTS TO TEST
        //#1
        guest1 = new Guest();
        guest1.setName("Marek");
        guest1.setWallet(200.00);
        //#2
        guest2 = new Guest();
        guest2.setName("Jonny");
        guest2.setWallet(300.00);
        //#3
        guest3 = new Guest();
        guest3.setName("Callum");
        guest3.setWallet(500.00);
        //#4
        guest4 = new Guest();
        guest4.setName("Tim");
        guest4.setWallet(350.00);
        //#5
        guest5 = new Guest();
        guest5.setName("Ben");
        guest5.setWallet(250.00);

        // POPULATE GUEST LISTS WITH GUESTS
        guests1.add(guest1);

        guests2.add(guest1);
        guests2.add(guest2);

        guests3.add(guest2);
        guests3.add(guest3);
        guests3.add(guest4);

        guests4.add(guest1);
        guests4.add(guest2);
        guests4.add(guest4);
        guests4.add(guest5);

        guests5.add(guest1);
        guests5.add(guest2);
        guests5.add(guest3);
        guests5.add(guest4);
        guests5.add(guest5);

    }

    @Test
    public void bedRoomsHaveTheRightCapacityOnInitiationBasedOnType(){
        assertEquals(1, bedRoom1.getCapacity());
        assertEquals(2, bedRoom2.getCapacity());
        assertEquals(3, bedRoom3.getCapacity());
        assertEquals(5, bedRoom5.getCapacity());
    }

    @Test
    public void bedroomsHaveNoGuestsAtCreation(){

        assertEquals(0, bedRoom1.getGuests().size());
        assertEquals(0, bedRoom2.getGuests().size());
        assertEquals(0, bedRoom3.getGuests().size());
        assertEquals(0, bedRoom5.getGuests().size());

    }

    @Test
    public void guestCanBeAddedAndRemovedFromRooms(){
        //Add guest1 by means of overwriting guests with array of guests
        bedRoom1.setGuests(guests1);
        assertEquals(1, bedRoom1.getCapacity());
        assertEquals(guest1, bedRoom1.getGuests().get(0));

        //remove all guests by overwriting guests with empty array
        bedRoom1.removeAllGuests();
        assertEquals(0, bedRoom1.getGuests().size());

        //Can retrieve a specific guest from room.
        bedRoom1.setGuests(guests1);
        assertEquals(1, bedRoom1.getCapacity());
        Guest retrieved = bedRoom1.removeAGuest(guest1);
        assertEquals(retrieved, guest1);
        assertEquals(0, bedRoom1.getGuests().size());

        //Can add a specific guest to room
        bedRoom1.removeAllGuests();
        bedRoom1.addGuest(guest1);
        assertTrue(bedRoom1.getGuests().contains(guest1));

    }

    @Test
    public void cannotAddToRoomBeyondCapacity(){
        assertEquals(5, bedRoom5.getCapacity());
        bedRoom5.setGuests(guests4);
        assertEquals(4,bedRoom5.getGuests().size());
        bedRoom5.addGuest(guest3);
        assertEquals(5,bedRoom5.getGuests().size());
        bedRoom5.addGuest(guest3);
        assertEquals(5,bedRoom5.getGuests().size());

        bedRoom5.removeAllGuests();
        assertEquals(0,bedRoom5.getGuests().size());
        bedRoom5.addGroup(guests2);
        assertEquals(2,bedRoom5.getGuests().size());
        bedRoom5.addGroup(guests4);
        assertEquals(2,bedRoom5.getGuests().size());

    }

    @Test
    public void roomHasARoomNumber(){
        assertEquals(1, bedRoom1.getRoomNumber());
        assertEquals(2, bedRoom2.getRoomNumber());
        assertEquals(3, bedRoom3.getRoomNumber());
        assertEquals(4, bedRoom5.getRoomNumber());

    }
    @Test
    public void roomHasAType(){
        assertEquals(RoomType.SINGLE, bedRoom1.getType());
        assertEquals(RoomType.DOUBLE, bedRoom2.getType());
        assertEquals(RoomType.TRIPLE, bedRoom3.getType());
        assertEquals(RoomType.FAMILY, bedRoom5.getType());

    }

    @Test
    public void roomsHaveProportionalRate(){
        assertEquals(150.0,bedRoom1.getRate(),0.01);
        assertEquals(300.0,bedRoom2.getRate(),0.01);
        assertEquals(450.0,bedRoom3.getRate(),0.01);
        assertEquals(750.0,bedRoom5.getRate(),0.01);
    }






}
