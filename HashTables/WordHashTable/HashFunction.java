package DataStructures.HashTables.WordHashTable;
import java.util.Arrays;
import java.util.ArrayList;

public class HashFunction {
    String[] theArray;
    int arraySize;
    int itemsArray = 0;

    public static void main(String[] args){
        HashFunction theFunc = new HashFunction(31);// important to use prime number to store values
        String[] elementsToAdd = {"100", "510", "170", "214", "268", "398",
        "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        String[] elementsToAdd2 = {"30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        theFunc.hashFucntion2(elementsToAdd2, theFunc.theArray);

        theFunc.increaseArraySize(60);

        theFunc.displayTheHashTable();

        theFunc.emptyArray();

        theFunc.displayTheHashTable();

        System.out.println("EMPTIED");

        theFunc.doubleHashFunction(elementsToAdd2, theFunc.theArray);

        theFunc.displayTheHashTable();

        theFunc.findKeyDblHased("989");

    }


    public boolean isPrime(int num){
        if(num % 2 == 0)
            return false;
        for(int i = 3; i*i <= num; i += 2){
            if(num % i ==0)
                return false;
        }
        return true;
    }

    public void increaseArraySize(int minArraySize){
        int newArraySize = getNextPrime(minArraySize);// gets a prime size for better hashing

        moveOldArray(newArraySize); // rehashes old hash table to new size hashtable with new key locations
    }

    public void moveOldArray(int newArraySize){
        String[] cleanArray =  removeEmptySpaceInArray(theArray);//empties all "-1" locations
        theArray = new String[newArraySize]; //makes new array with the appropriate siez
        arraySize = newArraySize; //sets new arraysize

        emptyArray(); // sets the new array all set to -1

        hashFucntion2(cleanArray, theArray); // rehashes old hash table to new size hashtable with new key locations
    }

    public String[] removeEmptySpaceInArray(String[] arrayToClean){
        ArrayList<String> stringList = new ArrayList<String>(); // creates new arraylist

        for(String theString : arrayToClean)//improved for loop assigns theString to each element of the array
            if(!theString.equals("-1") && !theString.equals(""))
                stringList.add(theString);
        return stringList.toArray(new String[stringList.size()]);
    }

    public void emptyArray(){
        Arrays.fill(theArray, "-1");
    }


    public int getNextPrime( int minNum2Check){//helper function: uses current number to expand the hashtable but returns
        //the prime because it makes the hashing sequence easier to understand
        for(int i = minNum2Check; true; i++){
            if(isPrime(i))
                return i;
        }
    }

    public void hashFucntion(String[] stringsForArray, String[] theArray){//takes the numbers to add to hash function
        // and the array that it'll be stored into
        // basic binary hashFunctionon places number directly into the array at the same element = to the value
        for(int i = 0; i < stringsForArray.length; i++){// navigates through the
            String newElementVal =  stringsForArray[i]; // takes value
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }
    }
    public void doubleHashFunction(String[] stringsForArray, String[] theArray){ // hash function using modulus
        for(int n = 0; n < stringsForArray.length; n++){
            String newElementVal = stringsForArray[n]; // takes string value from numbers being added into the hashtable
            int arrayIndex = Integer.parseInt(newElementVal) % arraySize;//modulus based on the size of the hasttable.

            int stepDistance = 5 - (Integer.parseInt(newElementVal) % 5);
            System.out.println("Modulus Index= " + arrayIndex +  " for value " + newElementVal);

            while(theArray[arrayIndex] != "-1"){ //navigates through the array to find open element
                arrayIndex += stepDistance;
                System.out.println("Collision Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize; // if array open element not found uses arraySize to adjust the index
            }

            theArray[arrayIndex] = newElementVal;
        }
    }
    public String findKeyDblHased(String key){
        int arrayIndexHash = Integer.parseInt(key)% arraySize; //reversing hash function to locate key
        int stepDistance = 5 - (Integer.parseInt(key) % 5);
        while(theArray[arrayIndexHash] != "-1"){ // navigates through to find it
            if (theArray[arrayIndexHash] == key){// key is found
                System.out.println(key + " was foun in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            arrayIndexHash += stepDistance;
            arrayIndexHash %= arraySize; //uses array size to find location
        }
        return null;

    }
    HashFunction(int size){ // constructor initiates all values to -1 to state them as empty
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray,"-1");

    }
    public void hashFucntion2(String[] stringsForArray, String[] theArray){ // hash function using modulus
        for(int n = 0; n < stringsForArray.length; n++){
            String newElementVal = stringsForArray[n]; // takes string value from numbers being added into the hashtable
            int arrayIndex = Integer.parseInt(newElementVal) % arraySize;//modulus based on the size of the hasttable.
            System.out.println("Modulus Index= " + arrayIndex +  " for value " + newElementVal);

            while(theArray[arrayIndex] != "-1"){ //navigates through the array to find open element
                ++arrayIndex;
                System.out.println("Collision Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize; // if array open element not found uses arraySize to adjust the index
            }

            theArray[arrayIndex] = newElementVal;
        }
    }

    public String findKey(String key){
        int arrayIndexHash = Integer.parseInt(key)% 29; //reversing hash function to locate key
        while(theArray[arrayIndexHash] != "-1"){ // navigates through to find it
            if (theArray[arrayIndexHash] == key){// key is found
                System.out.println(key + " was foun in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            arrayIndexHash++;
            arrayIndexHash %= arraySize; //uses array size to find location
        }
        return null;

    }

    public void displayTheHashTable(){

        for(int i = 0; i < theArray.length; i++){
            if( i % 9 == 0){
                System.out.println("\n________________________________________________________");
                System.out.print("|");
            }
            System.out.print(" " + theArray[i] + " |");

        }
    }
}
