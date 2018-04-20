import java.util.*;

/**
 * Lab06_davidkrystall
 * Created by davidkrystall on 3/17/18.
 *
 */
public class Lab06_davidkrystall {
    public static void main(String[] args){
        Integer[] prospects = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Permute By Sorting, 5 attempts on array 1-10:");
        System.out.println(permuteBySorting(prospects).values());
        System.out.println(permuteBySorting(prospects).values());
        System.out.println(permuteBySorting(prospects).values());
        System.out.println(permuteBySorting(prospects).values());
        System.out.println(permuteBySorting(prospects).values());

        System.out.println();

        System.out.println("Randomize in place, 5 attempts on array 1-10:");
        printIntArray(randomizeInPlace(prospects));
        printIntArray(randomizeInPlace(prospects));
        printIntArray(randomizeInPlace(prospects));
        printIntArray(randomizeInPlace(prospects));
        printIntArray(randomizeInPlace(prospects));

    }
    static TreeMap permuteBySorting(Integer[] interviewees){
        int n = interviewees.length;

        TreeMap<Integer, Integer> intervieweeMap = new TreeMap<>();
        for(int i = 0; i < n; i++ ){
            intervieweeMap.put(new Random().nextInt(n*n*n),interviewees[i]);
        }
        intervieweeMap.descendingKeySet().descendingIterator();

        return intervieweeMap;
    }
    static Integer[] randomizeInPlace(Integer[] interviewees){
        int n = interviewees.length;

        for(int i = 0; i < n; i++){
            int random = new Random().nextInt(n);
            int temp = interviewees[i];
            interviewees[i] = interviewees[random];
            interviewees[random] = temp;
        }
        return interviewees;
    }
    static  < E > void printIntArray(E[] a){
        System.out.print("[");
        int index = 0;
        for(E element : a) {
            if(index == a.length-1) {
                System.out.printf("%s", element);
            } else {
                System.out.printf("%s, ", element);
            }
            index++;
        }
        System.out.print("]");
        System.out.println();
    }
}
