package dataStructure;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 10/04/20
 * @project JavaProgramming
 * Implementation of arraylist
 */
public class MyArrayList<E> {
    private int size = 0;
    private Object elements[];
    private final int DEFAULT_CAP = 10;
    MyArrayList() {
        elements = new Object[DEFAULT_CAP];
    }

    /**
     * Add elements to list
     * @param e
     */
    public void add(E e){
        //exception to handle null value
        if (e == null) {
            throw new RuntimeException("Null value is not allowed in Shivani's arrayList baby");
        }
        //increment the size of list by double if the list is full
        if (size == elements.length){
            int newSize = 2 * elements.length;
            elements = Arrays.copyOf(elements,newSize);
        }
        elements[size] = e;
        size++;
    }

    /**
     * Get element from the list
     * @param e
     * @return
     */
    public Object get(E e){
        for (int i = 0; i < size; i++){
            if (elements[i] == e && elements[i] != null){
                return elements[i];
            }
        }
        return null;
    }

    /**
     * Return the index of the element to be removed
     * @param e
     * @return
     */
    public int remove(E e){
        for(int i = 0; i < size; i++){
            if(elements[i] == e){
                elements[i] = null;
                size--;
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the size of arraylist
     * @return
     */
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String out = "";
        for(Object e : this.elements) {
            if(e != null) {
                out += e + " ";
            }
        }
        return "[" + out.trim() + "]";
    }
}
