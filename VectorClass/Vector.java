package DataStructures.VectorClass;

public class Vector {
    private int size;
    private int[] array;
    private int location;

    public Vector(){
        this.size = 16;
        this.array = new int[size];
        this.location = 0;
    }
    public int getSize(){return this.location;}

    public int getCapacity(){ return this.size;}

    public boolean isEmpty(){
        if(this.location == 0){return true;}
        return false;
    }
    public void print(){
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public boolean isFull(){
        if(location == size)
            return true;
        return false;
    }

    public int at(int index){
        if(!inBounds(index)){
            System.out.println("This is out of bounds");
            return -1;
        } return array[index];
    }

    public void push(int number){
        if(isFull())
            this.resize(size*2);
        this.array[location] = number;
        location++;
    }
    public boolean inBounds(int index){
        if(index < 0 || index >= size)
            return false;
        return true;
    }

    public void insert(int index, int number){
        if(!inBounds(index))
            return;
        if(isFull())
            resize(size*2);
        if(isEmpty() || location == index)
            this.push(number);
        else{
            shift(index);
            this.array[index] = number;
        }
        if(index > location)
            location = index;
    }

    public void prepend(int number){
        insert(0, number);
    }

    public int pop(){

        if(isEmpty())
            return -1;

        location--;
        int temp = array[location];
        this.array[location] = 0;
        if(location < (int)(size/4)){
            this.resize(size/2);
        }
        return temp;
    }

    public void deleteIndex(int index){
        if(!inBounds(index) || index > location)
            return;
        for(int i = index; i < location; i++)
            this.array[i] = this.array[i+1];
        this.array[location] = 0;
        this.location--;
        if(location < size/4)
          resize(size/2);
    }

    public void shift(int index){
        for(int i = location; i > index; i--)
            this.array[i] = this.array[i-1];
        this.location++;
    }

    public void remove(int number){
        for(int i = 0; i < location; i++)
            if(array[i] == number)
                deleteIndex(i);
    }

    public int getIndex(int number){
        for(int i = 0; i < location; i ++)
            if(array[i] == number)
                return i;
        return -1;
    }

    private void resize(int newSize){
        int[] ar = new int[newSize];

        for(int j = 0; j < location ; j++){
            ar[j] = array[j];
        }
        this.size = newSize;
        this.array = new int[this.size];
        for(int i = 0; i < location; i++){
            this.array[i] = ar[i];
        }

    }

}
