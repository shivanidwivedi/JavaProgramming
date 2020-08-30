package serialization;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse
 * process where the byte stream is used to recreate the actual Java object in memory.
 * This mechanism is used to persist the object.
 *
 * Advantages of Serialization
 * 1. To save/persist state of an object.
 * 2. To travel an object across a network.
 */
public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializationDemo demo = new SerializationDemo();

        //the object to serialize
        String fileName = demo.serialize(new Employee(1, "Gagan"));

        //deserialize
        Employee employee = demo.deserialize(fileName);
        //Magic: verify de-serialized object
        Assert.assertEquals(1, employee.getId());
        Assert.assertEquals("Gagan", employee.getName());

        //clean up the file
        FileUtils.forceDelete(new File(fileName));
    }

    /**
     * Note that this will generate a serialized file.
     * You serialize an object.
     * @param employee
     * @throws IOException
     */
    private String serialize(Employee employee) throws IOException {
        String fileName = "employee.ser";
        //OUTPUT STREAM
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        //this will create serialized file. You can transfer this persistent object over the nextwork.
        //at the receiver end, it should be de-serialized into java object in order to use it.
        out.writeObject(employee);
        out.close();

        System.out.println("Object has been serialized");
        return fileName;
    }

    /**
     * You deserialize a file
     * Java knows how to de-serialize a file, dont worry about internals sweety.
     * @param fileName
     * @return
     */
    private Employee deserialize(String fileName) throws IOException, ClassNotFoundException {
        //INPUT stream
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);

        //we already know that it is an employee object
        Employee employee = (Employee) in.readObject();
        System.out.println("Object has been de-serialized");
        return employee;
    }
}

/**
 *
 */
class Employee implements Serializable {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}