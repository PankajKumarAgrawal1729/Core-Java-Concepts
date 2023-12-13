class Laptop {
    int price;
    String name;
    public String toString(){
        return "Hello";
    }
}

public class ObjectClass {
    public static void main(String[] args) {
        Laptop obj = new Laptop();
        obj.name = "Mac";
        obj.price = 128322;

        // they both return same result becz when we print any object it calls toString
        // method by default
        System.out.println(obj); // Laptop@7344699f   or Hello
        System.out.println(obj.toString()); // Laptop@7344699f  or Hello
    }
}
