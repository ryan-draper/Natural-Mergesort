
package naturalmergesort;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size N: ");
        int size = s.nextInt();
        NaturalMergesort list = new NaturalMergesort();
        for(int i = 0; i < size; i++) {
            list.add((int)(Math.random()*size*size));
        }
        System.out.println("\nUnsorted: ");
        list.print();
        list.setFirst(list.sort());
        System.out.println("\nSorted: ");
        list.print();
    }
}
