package design_questions.school.management;

/**
 * @author shivanidwivedi on 12/08/20
 * @project JavaProgramming
 */
public class Main {
    public static void main(String[] s){

        Teacher shivani = new Teacher(1, "Shivani", 30000);
        Student gagan = new Student(1, "Gagan", 6);

        School school = new School();
        school.addTeacher(shivani);
        school.addStudent(gagan);

        System.out.println(shivani.getSalary());
        System.out.println(gagan.getFeesPaid());
        gagan.setFeesPaid(3000);
        gagan.setGrade(7);
        System.out.println(gagan.getFeesPaid());

    }
}
