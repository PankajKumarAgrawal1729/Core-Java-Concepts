class Human {

    //encapsulate the variable and only access by methods
    private int age;
    private String name;

    //getter : methos who give the value
    public int getAge(){
        return age;
    }

    //setter : method who set the value
    public void setAge(int a){
        age = a;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.setAge(24);
        obj.setName("Ram");
        System.out.println(obj.getName() + " : " + obj.getAge());
    }
}
