package design_questions.parking_lot;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
public class Vehicle {
    private Size size;

    public Vehicle(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return this.size;
    }

}

enum Size {
    S,  M, L
}
