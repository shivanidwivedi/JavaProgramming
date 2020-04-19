package design_questions.parking_lot;

import lombok.Getter;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
@Getter
public class Ticket {
    private static int id = 0;
    private Space space;
    private Vehicle vehicle;

    public Ticket(Space space, Vehicle v) {
        this.space = space;
        this.space.occupy();
        this.vehicle = v;
        id++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Ticket ticket = (Ticket) obj;
        return id == ticket.getId();
    }
}
