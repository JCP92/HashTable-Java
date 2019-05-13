package DataStructures.Queue;

public class Driver {
    public static void main(String[] args){
        QueueDynamic go = new QueueDynamic();

        for(int i = 0; i < 9; i++) {
            go.enqueue((int)(Math.random()*10));
            go.printQueue();
        }
        for(int i = 0; i < 10; i++) {
            go.dequeue();
            go.printQueue();
        }
        for(int i = 0; i < 9; i++) {
            go.enqueue((int) (Math.random() * 10));
            go.printQueue();
        }
        go.empty();
        go.printQueue();
    }
}
