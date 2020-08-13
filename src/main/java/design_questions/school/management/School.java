package design_questions.school.management;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 12/08/20
 * @project JavaProgramming
 */

@Data
public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private int totalMoneyEarned;
    private int totalMoneySpent;

    public School(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void updateTotalMoneyEarned(int moneyEarned){
        totalMoneyEarned += moneyEarned;
    }

    public void updateTotalMoneySpent(int moneySpent){
        totalMoneyEarned-=moneySpent;
    }
}
