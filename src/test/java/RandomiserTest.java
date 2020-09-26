import humans.Guest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RandomiserTest {

    Randomiser randomiser;
    Guest emptyGuest1;
    ArrayList<Guest> gruop;

    @Before
    public void before(){
        randomiser = new Randomiser();
        emptyGuest1 = new Guest();
        gruop = new ArrayList<Guest>();
    }


    @Test
    public void canGenerateRandomName(){
        String nameEmpty = "";
        String name = randomiser.getRandomName();
        assertNotEquals(name,nameEmpty);
        assertTrue(name.length()>=8);

    }
    @Test
    public void canGenerateRandomWallet(){
        double walletEmpty = 0.0;
        double wallet = randomiser.getRandomWallet();
        assertNotEquals(wallet,walletEmpty);
        assertTrue(wallet>0);
    }

    @Test
    public void canCreateDefaultNonEmptyGuestAndRandomGuest(){
        Guest guest0 = randomiser.getDemoFun();
        assertEquals("Jonny Rambo", guest0.getName());
        Guest guest1 = randomiser.getDemoP1();
        assertEquals("Ally Smith", guest1.getName());
        assertEquals(500.0, guest1.getWallet(),0.01);
        Guest rando = randomiser.createGuest();
        assertTrue(rando.getName().length()>=8);
        assertTrue(rando.getWallet()>=0);
    }
}
