package DataStructures.LinkList;


public class LinkedList {
    Node head;
    int length = 0;

    public LinkedList(){};
    public LinkedList(int value){
        head = new Node(value);
    }

    public int getSize() {
        return length;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public int valueAt(int index) {
        if ((index > length - 1) || (index < 0))
            return -1;
        Node navi = head;
        for (int i = 0; i < index; i++)
            navi = navi.next;
        return navi.value;

    }

    public void pushFront(int value) {
        if (head == null) {
            head = new Node(value);
            length++;
            return;
        }
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
        length++;
    }

    public int pop() {
        Node navi = head;
        if (head == null) return -1;
        if (head.next == null) {
            navi = head;
            head = null;
            length--;
            return navi.value;
        }
        while (navi.next.next != null)
            navi = navi.next;

        Node temp = navi.next;
        navi.next = null;
        length--;
        return temp.value;
    }

    public void getFront() {
        if(isEmpty()){
            System.out.print("Empty");
            return;
        }
        System.out.println(head.value);
    }

    public void getEnd() {
        if(isEmpty()){
            System.out.print("Empty");
            return;
        }
        Node navi = head;
        while (navi.next != null)
            navi = navi.next;
        System.out.println(navi.value);
    }

    public void queue(int value) {
        if (isEmpty()) {
            head = new Node(value);
            length++;
            return;
        }
        Node navi = head;
        while (navi.next != null)
            navi = navi.next;
        navi.next = new Node(value);
        length++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        Node temp = head;
        head = head.next;
        length--;
        return temp.value;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Out of bounds");
            return;
        }
        if (index == 0) {
            pushFront(value);
            return;
        } else if (index == length) {
            queue(value);
            return;
        } else {
            Node navi = head;
            for (int i = 0; i < index - 1; i++)
                navi = navi.next;
            Node newNode = new Node(value);
            newNode.next = navi.next;
            navi.next = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            System.out.println("Out of bounds");
            return;
        }
        if (index == 0) {
            Node temp = head;
            head = head.next;
            length--;
            return;
        } else if (index == length) {
            pop();
            return;
        } else {
            Node navi = head;
            for (int i = 0; i < index - 1; i++)
                navi = navi.next;
            Node temp = navi.next;
            navi.next = temp.next;
            temp.next = null;
            length--;
        }
    }

    public void valueNfromEnd(int n) {
        if (n == length) {
            getFront();
            return;
        } else if (n == 0) {
            getEnd();
            return;
        }
        n = length - 1 - n;
        Node navi = head;
        for (int i = 0; i < n; i++)
            navi = navi.next;
        System.out.println("Value from end: " + navi.value);
    }

    public void reverse() {
        Node navi = head;
        Node tail = null;
        Node establish;
        while (navi.next.next != null)
            navi = navi.next;
        tail = navi.next;
        navi.next = null;
        establish = tail;

        while(head.next != null){
            navi = head;
            while(navi.next.next != null)
                navi = navi.next;
            establish.next = navi.next;
            navi.next = null;
            establish = establish.next;
        }
        establish.next = head;
        head = tail;
    }

    public void removeValue(int val) {
        Node navi = head;

        while (navi.next.value != val)
            navi = navi.next;
        Node temp = navi.next;
        navi.next = temp.next;
        temp.next = null;
        length--;
    }

    public void printLL(){
        Node navi = head;
        for(int i = 0; i < length; i++){
            System.out.print("[Node " + i + ": " + navi.value + "]  ->  ");
            navi = navi.next;
        }
        System.out.print("null\tLength: " + length +"\n");

    }
}