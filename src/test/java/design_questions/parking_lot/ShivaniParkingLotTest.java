package design_questions.parking_lot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author shivanidwivedi on 19/04/20
 * @project JavaProgramming
 */
public class ShivaniParkingLotTest {

    ParkingLot parkingLot = new ShivaniParkingLot();

    @Before
    public void setup() {
        parkingLot.addSpace(new Space(Size.S));
        parkingLot.addSpace(new Space(Size.S));
        parkingLot.addSpace(new Space(Size.M));
        parkingLot.addSpace(new Space(Size.M));
        parkingLot.addSpace(new Space(Size.L));
    }

    @Test
    public void test1() {
        Vehicle car = new Vehicle(Size.M);
        Ticket ticket = parkingLot.enter(car);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(5, parkingLot.getAllSpaces().size());
        Assert.assertEquals(4, parkingLot.getAvailableSpaces().size());

        parkingLot.exit(ticket);
        Assert.assertEquals(5, parkingLot.getAvailableSpaces().size());
    }
}