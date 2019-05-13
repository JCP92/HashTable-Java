package DataStructures.Queue;

public class QueueStatic {
    private int[] queue;
    public int line = 0;
    public QueueStatic(){ this.queue = new int[10] ;}
    public QueueStatic(int size){
        this.queue = new int[size];
    }

    public void engueue(int value){
        if(line == queue.length){
            System.out.println("Queue is full");
            return;
        }else{
            queue[line] = value;
            line++;
        }
    }
    public int dequeue(){
        if(line == 0){
            return -1;
        }else{
            int temp = queue[0];
            shift();
            return temp;
        }
    }

    public void shift(){
        for(int i = 0; i < line; i++)
            queue[i] = queue[i+1];
        line--;
    }

    public void empty(){
        for(int i = 0; i < line; i++) {
            queue[i] = 0;
            line--;
        }
    }
}
