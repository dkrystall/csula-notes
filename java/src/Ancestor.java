import java.util.ArrayList;

/**
 * javaRefreshse
 * Created by davidkrystall on 1/31/18.
 * <p>
 * <p>
 * (c) ontometrics 2015, All Rights Reserved
 */
public class Ancestor {
    public static final int numberOfMethods = 1;
    public static void main(String[]Args){
        System.out.println(1.5+5);
//        ArrayList<String> stringArray = new ArrayList<String>();
//        stringArray.add("Hello");
//        SomeObject obj = new SomeObject();
//        obj.changeOjbect(obj.arr);
//        System.out.println(obj.arr.get(0));
//        obj.arr.add("Good Luck");
//        System.out.println(obj.arr.get(1));
    }
}

class SomeObject{
    ArrayList<String> arr = new ArrayList<>();


    public void changeOjbect(ArrayList<String> arr){ // The argument here takes in the object in the class because the reference is the same.
        arr.add("First");
        arr = new ArrayList<String>();
        arr.add("Second");
    }

}

