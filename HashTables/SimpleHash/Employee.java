package DataStructures.HashTables.SimpleHash;

public class Employee {
    public String firstName;
    public String lastName;
    public String badgeNum;

    public Employee next;
    public int Key;

    public Employee(String name, String lastName, String number){
        this.firstName = name;
        this.lastName = lastName;
        this.badgeNum = number;
    }

    public String toString(){
        return "Employe Name: " + firstName + " " + lastName + "\t Badge Number: " + badgeNum + "\n";
    }
}
