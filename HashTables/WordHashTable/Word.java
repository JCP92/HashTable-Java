package DataStructures.HashTables.WordHashTable;

class Word{
    public String theWord;
    public String definition;

    public int key;
    public Word next;

    Word(String theWord, String definition){
        this.theWord = theWord;
        this.definition = definition;
    }

    public String toString(){
        return theWord + ": " + definition;
    }
}

