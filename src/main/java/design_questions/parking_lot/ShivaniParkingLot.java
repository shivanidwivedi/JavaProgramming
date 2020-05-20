package design_questions.parking_lot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
public class ShivaniParkingLot implements ParkingLot{
    private List<Space> parkingSpace;
    private List<Ticket> tickets;

    public ShivaniParkingLot() {
        parkingSpace = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    @Override
    public Ticket enter(Vehicle v) {
        Space space = isSpaceAvailable(v.getSize());
        if(space != null) {
            Ticket ticket = new Ticket(space, v);
            tickets.add(new Ticket(space, v));
            return ticket;
        }
        return null;
    }

    
    @Override
    public void exit(Ticket t) {
        t.getSpace().release();
        tickets.remove(t);
    }

    @Override
    public List<Space> getAllSpaces() {
        return this.parkingSpace;
    }

    @Override
    public List<Space> getAvailableSpaces() {
        List<Space> availableSPaces = new ArrayList();
        this.parkingSpace.stream().forEach(space ->{
                    if(space.isAvailable()) {
                        availableSPaces.add(space);
                    }
                }
        );
        return availableSPaces;
    }

    @Override
    public boolean addSpace(Space space) {
        if(space != null) {
            this.parkingSpace.add(space);
        }
        return false;
    }


    private Space isSpaceAvailable(Size size) {
        for(Space currSpace : parkingSpace) {
            if(currSpace.isAvailable() && currSpace.getSize().equals(size)){
                return currSpace;
            }
        }
        return null;
    }
}

