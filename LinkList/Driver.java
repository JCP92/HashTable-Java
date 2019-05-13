package DataStructures.LinkList;
import java.lang.Math;

public class Driver {
    LinkedList test = new LinkedList();

    public static void main(String[] args){
        LinkedList test = new LinkedList();

        for(int i = 0; i < 10; i++) {
            test.pushFront((int)(Math.random() * 10));
            test.printLL();
        }
        for(int i = 0; i < 11; i++) {
            System.out.print(test.valueAt(i) + " ");
        }
        System.out.println("\nPopping: ");
        for(int i = 0; i < 11; i++){
            System.out.println("Popped: " + test.pop() + " ");
            test.printLL();
        }
        System.out.print("Head is: ");
        test.getFront();
        System.out.println();
        System.out.print("End is: ");
        test.getEnd();
        for(int i = 0; i < 6; i++){
            test.queue((int)(Math.random()*10));
            test.printLL();
        }
        System.out.println("Dequeue ");
        for(int i = 0; i < 1; i++){
            test.dequeue();
            test.printLL();
        }
        test.insert(0, 99);
        test.printLL();

        System.out.println("Removing: ");
        test.remove(7);
        test.printLL();

        test.valueNfromEnd(2);

        test.reverse();
        test.printLL();

    }

}
