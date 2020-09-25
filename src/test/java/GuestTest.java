import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    }

}
