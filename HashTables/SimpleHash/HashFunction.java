package DataStructures.HashTables.SimpleHash;

public class HashFunction {
    public int size = 27;
    EmployeeList[] database;

    HashFunction(){
        database = new EmployeeList[size];
        for(int i =0; i < size; i++){
            database[i] = new EmployeeList();
        }
    }

    public int stringHashFunction(String wordToHash){
        int hashKeyValue = 0;

        for(int i = 0; i < wordToHash.length(); i++){
            int charCode = wordToHash.charAt(i) - 96; //get character value to index

            hashKeyValue = (hashKeyValue * 27 + charCode) % size;
        }

        return hashKeyValue;
    }

    public void insert(Employee emp){
        String wordToHash = emp.lastName;
        int hashKey = stringHashFunction(wordToHash);

        database[hashKey].insert(emp, hashKey);
    }

    public void remove(Employee emp){
        String wordToHash = emp.lastName;
        int hashKey = stringHashFunction(wordToHash);

        database[hashKey].remove(emp, hashKey);
    }

    public Employee find(String name){
        int hashKey = stringHashFunction(name);
        return database[hashKey].find(hashKey, name);
    }

    public void displayEmployees(){
        for(int i = 0; i < size; i++){
            database[i].displayEmpList();
        }
    }
}
