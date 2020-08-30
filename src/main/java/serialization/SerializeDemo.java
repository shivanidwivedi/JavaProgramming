package serialization;

import java.io.*;

/**
 * @author shivanidwivedi on 30/08/20
 * @project JavaProgramming
 */
public class SerializeDemo {
    public static void main(String[] s){
        Employee1 employee = new Employee1();
        employee.name = "Shivani";
        employee.address = "Seattle";
        employee.ssn = 123456789;
        employee.number= 123;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/tmp/shivani.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(employee);
            out.close();
            fileOutputStream.close();
            System.out.println("Serialized data is stored in file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Employee1 implements Serializable {
     String name;
     String address;
     transient int ssn;
     int number;

     public void mailCheck(){
         System.out.println("Mailing a check to" + name + " " + address);
     }
}