package DataStructures.VectorClass;
import java.util.Scanner;
import java.lang.Math;

public class Driver {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Vector a = new Vector();

        for(int i = 0; i < 15; i ++){
            a.push((int)(Math.random()*10));
        }
        a.print();
        for(int i = 0; i < 16 ; i++)
            System.out.print(a.at(i) + " ");
        System.out.println();
        a.print();
        a.insert(15, 9);
        a.print();
        a.insert(15, 9);
        a.insert(0, 33);
        a.print();
        a.prepend(44);
        a.print();
        //for (int i = 0; i < 12; i ++)
          //  a.deleteIndex(0);
        System.out.println("What number would you like to remove: ");
        a.remove(input.nextInt());
        a.print();

    }

}
