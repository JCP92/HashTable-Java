package DataStructures.HashTables.WordHashTable;

import java.util.Scanner;

class WordList{// initiates word list
    public Word firstWord = null;

    public void insert(Word newWord, int hashKey){// adds additional words to the llist
        Word previous = null;// tracking pervious word
        Word current = firstWord; // tracks current word

        newWord.key = hashKey; // assign the key to the new word

        while(current != null && newWord.key > current.key){//navigate through the word file until open
            //location is found while the key for the new word is smaller than the key for the current word
            previous = current;
            current = current.next;
        }

        if(previous == null) // verify that the list isn't empty
            firstWord = newWord;
        else
            previous.next = newWord; // the current word is larger so inserting the new word before it

        newWord.next = current;// puts current pointer in front of previous pointer

    }

    public void displayWordList(){
        Word current = firstWord; //sets current word to the head word
        while(current != null){// navigates through the list until the list is over
            System.out.print(current + " ");
            current = current.next;
        }
    }

    public Word find(int hashKey, String wordToFind){
        Word current = firstWord;//points to the head of the list

        while(current != null && current.key <= hashKey){// makes sure its not at end of list and the
            //value of the key isn't passed
            if(current.theWord.equals(wordToFind)){//compares the word inside of the node to the one looking for
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public static void main(String[] args0){
        Scanner input = new Scanner(System.in);

        HashFunctionChaining wordHashTable = new HashFunctionChaining(11);

        String wordLookUp = "a";

        while(!wordLookUp.equalsIgnoreCase("x")){
            System.out.println(": ");
            wordLookUp = input.nextLine();
            System.out.println(wordHashTable.find(wordLookUp));
        }

        wordHashTable.displayTheArray();

    }
}
