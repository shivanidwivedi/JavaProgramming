package design_patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 03/08/20
 * @project JavaProgramming
 */

//BuiderPatternDemo uses MealBuider to demonstrate builder pattern.
public class BuilderPatternDemo {
    public static void main(String s[]) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.preparevegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}

//Create an interface Item representing food item and packing.
interface Item{
    public String name();
    public float price();
    public Packing packing();
}

interface Packing{
    public String pack();
}

//Create concrete classes implementing the Packing interface.
class Wrapper implements Packing{
    @Override
    public String pack(){
        return "wrapper";
    }
}

class Bottle implements Packing {
    @Override
    public String pack() {
        return "bottle";
    }
}

//Create abstract classes implementing the item interface providing default functionalities.
abstract class Burger implements Item{
    @Override
    public Packing packing(){
        return new Wrapper();
    }
    public abstract float price();
}

abstract class Coldrink implements Item{
    @Override
    public Packing packing(){
        return new Wrapper();
    }
    public abstract float price();
}

//Create concrete classes extending Burger and ColdDrink classes
class Chicken extends Burger{
    @Override
    public float price(){
        return 5.0f;
    }

    public String name(){
        return "Chicken Burger";
    }
}

class Veg extends Burger{
    @Override
    public float price(){
        return 3.0f;
    }

    public String name(){
        return "Veg Burger";
    }

}

class Coke extends Coldrink{
    @Override
    public float price(){
        return 3.0f;
    }

    public String name(){
        return "Coke";
    }

}

class Pepsi extends Coldrink{
    @Override
    public float price(){
        return 3.0f;
    }

    public String name(){
        return "Pepsi";
    }
}

//Create a Meal class having Item objects defined above.
class Meal{
    List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item : items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}

//Create a MealBuilder class, the actual builder class responsible to create Meal objects.
class MealBuilder{
    public Meal preparevegMeal(){
        Meal meal = new Meal();
        meal.addItem(new Veg());
        meal.addItem(new Coke());
        return meal;
    }
    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new Chicken());
        meal.addItem(new Pepsi());
        return meal;
    }
}