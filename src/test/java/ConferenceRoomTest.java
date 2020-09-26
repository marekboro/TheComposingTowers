import humans.Guest;
import org.junit.Before;
import org.junit.Test;
import rooms.ConferenceRoom;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Randomiser randomiser;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom("The Nexus");
        conferenceRoom.setCapacity(50);
        randomiser = new Randomiser();
    }
    @Test
    public void roomHasNameOnSetupAndNameCanBeChanged(){
        assertEquals("The Nexus",conferenceRoom.getName());
        conferenceRoom.setName("The Dolphin");
        assertEquals("The Dolphin",conferenceRoom.getName());
    }
    @Test
    public void roomHasFinalPrice(){
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);
    }
    @Test
    public void addingGuestsWithinDefaultGuestsDoesNoAdjustPrice(){
        Guest person1 = randomiser.getDemoP1();
        Guest person2 = randomiser.getDemoP2();
        conferenceRoom.addGuest(person1);
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);


    }

    @Test
    public void roomPriceAdjustsToPartySize(){
        ArrayList<Guest> party1 = randomiser.makeParty(31);
        conferenceRoom.addGroup(party1);
        assertEquals(31,conferenceRoom.getGuests().size());
        assertEquals(1540.0,conferenceRoom.getFinalPrice(),0.01);
        ArrayList<Guest> party2 = randomiser.makeParty(4);
        conferenceRoom.addGroup(party2);
        assertEquals(35,conferenceRoom.getGuests().size());
        assertEquals(1700.0,conferenceRoom.getFinalPrice(),0.01);
    }

    @Test
    public void canModifyDefaultGuestsOfRoomAndModifyChangesInPrice(){
        ArrayList<Guest> party1 = randomiser.makeParty(30);
        conferenceRoom.addGroup(party1);
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);
        conferenceRoom.setDefaultGuests(25);
        assertEquals(1700.0,conferenceRoom.getFinalPrice(),0.01);
        conferenceRoom.setDefaultGuests(35);
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);

    }

    @Test
    public void canAdjustRoomPriceByAlteringCostOfAdditionalGuests(){
        ArrayList<Guest> party1 = randomiser.makeParty(30);
        conferenceRoom.addGroup(party1);
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);
        conferenceRoom.setDefaultGuests(25);
        conferenceRoom.setPriceAdditionalGuest(50);
        assertEquals(1750.0,conferenceRoom.getFinalPrice(),0.01);

    }
    @Test
    public void canAdjustInitialPrice(){
        ArrayList<Guest> party1 = randomiser.makeParty(30);
        conferenceRoom.addGroup(party1);
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);
        conferenceRoom.setDefaultGuests(25);
        conferenceRoom.setInitialPrice(1300.0);
        assertEquals(1500.0,conferenceRoom.getFinalPrice(),0.01);

    }




}
