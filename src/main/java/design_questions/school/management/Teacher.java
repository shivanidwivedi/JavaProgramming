package design_questions.school.management;

import lombok.Data;

/**
 * @author shivanidwivedi on 12/08/20
 * @project JavaProgramming
 */

@Data
public class Teacher {
    private int id;
    private String name;
    private int salary;

    public Teacher(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
