import com.datastructure.vector.List;
import com.datastructure.vector.ObjectVector;
import com.datastructure.vector.Vector;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ObjectVector vector = new ObjectVector(3);
        List<String> vectorList = new List<>(1);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("A");
        arrayList.add("C");
        System.out.println(arrayList);

        arrayList.add(1, "B");
        System.out.println(arrayList);

        boolean exists = arrayList.contains("A");
        if (exists) {
            System.out.println("We found your element.");
        } else {
            System.out.println("Your element does not exist inside the array.");
        }

        int index = arrayList.indexOf("D");
        if (index > -1) {
            System.out.println("We found your element.");
        } else {
            System.out.println("Your element does not exist inside the array.");
        }

        System.out.println(arrayList.get(2));
        arrayList.remove(0);
        arrayList.remove("B");

        System.out.println("The size of your array is: " + arrayList.size());

        System.out.println("---------------------------------------------");

        Contact firstContact = new Contact("John", "11111-1111", "1@gmail.com");
        Contact secondContact = new Contact("Lucy", "22222-2222", "2@gmail.com");
        Contact thirdContact = new Contact("Marie", "33333-3333", "3@gmail.com");

        vector.addElementGoodWay(firstContact);
        vector.addElementGoodWay(secondContact);
        vector.addElementGoodWay(thirdContact);

        vector.addElementGoodWay("A");
        vector.addElementGoodWay("B");
        vector.addElementGoodWay("C");
        vector.addElementGoodWay("D");
        vector.addElementGoodWay("E");
        vector.addElementGoodWay("F");
        vector.addElementGoodWay("G");

        vectorList.addElementGoodWay("Ugly list vector");
        vectorList.addElementGoodWay("Testing if this is working");
        System.out.println(vectorList);

        System.out.println("---------------------------------------------");

        System.out.println(vector);
        vector.addNewElement(3, "1");

        System.out.println(vector);

        vector.addNewElement(5, "2");
        System.out.println(vector);

        vector.removeElement(3);
        System.out.println(vector);

        System.out.println("---------------------------------------------");


        System.out.println("I would like to remove an element.");
        int position = vector.findElement("2");
        if (position > -1) {
            vector.removeElement(position);
            System.out.println("Element removed: " + vector);
        } else {
            System.out.println("This element doesn't exists.");
        }

        List<String> list = new List<>(100);
        list.addElementGoodWay("1");
        list.addElementGoodWay("2");
        list.addElementGoodWay("1");
        list.addElementGoodWay("235");

        System.out.println("Last element is: " + list.lastElement("1"));

        list.remove("235");

        System.out.println(list);
        System.out.println(list.containsToList("1"));
        System.out.println(list.searchElement(2));
    }
}
