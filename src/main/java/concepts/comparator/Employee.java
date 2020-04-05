package concepts.comparator;

import lombok.Data;

/**
 * @author shivanidwivedi on 03/04/20
 * @project JavaProgramming
 */
@Data
public class Employee {
    private int salary;
    private int age;
    private String name;
    public Employee(int sal, int age, String name) {
        this.age = age;
        this.salary = sal;
        this.name = name;
    }
}
