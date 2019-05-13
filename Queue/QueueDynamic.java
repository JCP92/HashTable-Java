package DataStructures.Queue;

public class QueueDynamic {
    Node head;
    Node tail;

    public QueueDynamic() {}

    public QueueDynamic(int value){
        head = tail = new Node(value);
    }

    public void enqueue(int value) {
        if(head == null){
            head = tail = new Node(value);
        }
        tail.next = new Node(value);
        tail = tail.next;
    }
    public int dequeue(){
        Node temp = head;
        if(head == null) { return -1; }
        else if(head.next == null){
            head = tail = null;
        }else {
            head = head.next;
            temp.next = null;
        }
        return temp.value;
    }
    public void empty(){
        while(head != null){
            dequeue();
        }
    }
    public void printQueue(){
        if(head == null){
            System.out.println("Empty Queue");
            return;
        }
        Node navi = head;
        while(navi.next != null){
            System.out.print(navi.value + " ");
            navi = navi.next;
        }
        System.out.println();
    }
}
