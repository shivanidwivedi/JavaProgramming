package dataStructure.hashmap;

import java.util.HashMap;

/**
 * @author gaganmani
 * @date 05/10/19
 * @package dataStructure.hashmap
 */
public class CustomHashMap {

    class EmployeeKey {
        String name;
        int age;

        public EmployeeKey(String name, int age){
            this.name = name;
            this.age = age;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeKey that = (EmployeeKey) o;
            return age == that.age &&
                    name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode() + age;
            //return 1; //bad hashcode
        }
    }

    HashMap<EmployeeKey, Integer> employeeMap = new HashMap<EmployeeKey, Integer>();

}
