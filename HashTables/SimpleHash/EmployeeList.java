package DataStructures.HashTables.SimpleHash;

public class EmployeeList {
    public Employee firstEmp = null;

    public void insert(Employee newEmp, int key){
        Employee current = firstEmp;
        Employee previous = null;

        newEmp.Key = key;

        while(current.next != null && newEmp.Key > current.Key){
            previous = current;
            current = current.next;
        }

        if(previous == null)
            firstEmp = newEmp;
        else
            previous.next = newEmp;

        newEmp.next = current;
    }

    public void remove(Employee emp, int hashKey){
        Employee current = firstEmp;
        Employee previous = null;

        while(current.next != null && hashKey != current.Key){
            previous = current;
            current = current.next;
        }

        if(current.Key != hashKey) {
            System.out.println("Does not exist");
            return;
        }
        if(current.next != null){
            previous.next = current.next;
            current.next = null;
        }else{
            previous.next = null;
        }
    }

    public Employee find(int hashKey, String wordToFind){
        Employee nav = firstEmp;

        while(nav != null && nav.Key <= hashKey){
            if(nav.lastName.equals(wordToFind)){
                return nav;
            }
            nav = nav.next;
        }
        return null;
    }

    public void displayEmpList(){
        Employee nav = firstEmp;
        while(nav != null){
            nav.toString();
            nav = nav.next;
        }
    }
}
