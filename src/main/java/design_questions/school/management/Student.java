package design_questions.school.management;

import lombok.Data;

/**
 * @author shivanidwivedi on 12/08/20
 * @project JavaProgramming
 */

@Data
public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    public Student(int id, String name, int grade){
        feesPaid = 0;
        feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void updateFees(int fees){
        feesPaid += fees;
    }
}
