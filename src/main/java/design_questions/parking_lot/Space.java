package design_questions.parking_lot;

import lombok.Getter;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
public class Space {
    @Getter
    private Size size;
    private Availability availability;

    public Space(Size size) {
        this.size = size;
        this.availability = Availability.AVAILABLE;
    }

    public boolean isAvailable() {
        return availability.isAvailable();
    }
    public void occupy() {
        availability = Availability.UNAVAILABLE;
    }
    public void release() {
        availability = Availability.AVAILABLE;
    }
}

enum Availability {
    AVAILABLE(true), UNAVAILABLE(false);
    private boolean isAvailable;
    Availability(boolean b) {
        this.isAvailable = b;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
}
