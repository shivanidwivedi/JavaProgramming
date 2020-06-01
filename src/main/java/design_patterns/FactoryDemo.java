package design_patterns;

/**
 * @author shivanidwivedi on 01/06/20
 * @project JavaProgramming
 *
 * EXAMPLE OF FACTORY DESIGN PATTERN
 */
public class FactoryDemo {
    public static void main(String s[]){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeCircle = shapeFactory.getShape("Circle");
        shapeCircle.draw();
        Shape shapeSquare = shapeFactory.getShape("Square");
        shapeSquare.draw();
        Shape shapeRectangle = shapeFactory.getShape("Rectangle");
        shapeRectangle.draw();
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        if(shapeType.equalsIgnoreCase("Square")){
            return new Square();
        }
        if(shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        return null;
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside circle draw method");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside square draw method");
    }
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside rectangle draw method");
    }
}
interface Shape{
    public void draw();
}