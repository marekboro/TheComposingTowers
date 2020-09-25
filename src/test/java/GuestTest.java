import humans.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GuestTest {

    Guest guest1;
    Guest guest2;

    Randomiser randomiser;

    @Before
    public void before(){
        guest1 = new Guest();
        guest2 = new Guest();
        randomiser = new Randomiser();
        guest2.setName(randomiser.getRandomName());
        guest2.setWallet(randomiser.getRandomWallet());
    }

    @Test
    public void GuestHasNoNameAtInitialisation(){
        assertEquals("", guest1.getName());
        assertEquals(0, guest1.getName().length());
    }
    @Test
    public void RandomiserCanChangeName(){
        assertNotEquals(0.00, guest2.getName().length());
        assertNotEquals("", guest2.getName());
    }
    @Test
    public void RandomiserCanChangeWallet(){
        assertNotEquals(0.00, guest2.getWallet());
    }

    @Test
    public void GuestCanBeAssignedNewName(){
        guest1.setName("Jonny no 5");
        assertEquals("Jonny no 5", guest1.getName());
        guest1.setName("Hallo!");
        assertEquals("Hallo!", guest1.getName());


    }



}
