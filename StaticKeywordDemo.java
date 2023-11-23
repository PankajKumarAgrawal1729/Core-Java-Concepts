class Mobile {
    String brand;
    int price;
    // String name;
    static String name; // now this name is name for all object, it's shared by all the objects, it is
                        // belong to class not with object

    static {
        // to initilize the static variables and it will called only once(when class is
        // load) ir-respective
        // of the how many time we created the object of this class, and it'll called
        // only if we create any object
        name = "Phone";
        System.out.println("In static block");
    }

    Mobile() {
        brand = "";
        price = 23332;
        // name = "Phone"; if we initialize it here then every time when we create the
        // object it'll initialized but static varible is created only once then their
        // is no benefits of initializing it here
    }

    // it is intance method
    public void show() {
        System.out.println(brand + " : " + price + " : " + name);
    }

    // static method
    public static void show1() {
        // we can use only static variable(name) in static method, not instance
        // varibles(brand, price), becz instance variable are different for different
        // object, but we can access these instance variable indirectly in static method
        System.out.println("in static method");
    }

    // static method where we access instance variables
    public static void show2(Mobile obj) {
        System.out.println("in Static Method: ");
        System.out.println(obj.brand + " " + obj.price + " " + name);
    }
}

public class StaticKeywordDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Mobile mob1 = new Mobile();
        mob1.brand = "Apple";
        mob1.price = 60000;
        // mob1.name = "i13";

        Mobile mob2 = new Mobile();
        // mob2.brand = "Samsung";
        // mob2.price = 15000;
        // mob2.name = "A32";

        // mob1.name = "Smart Phone"; // it'll affect obj2 name varible also
        // Mobile.name = "Smart Phone"; // we can used static variables using class name
        mob1.show();
        mob2.show();

        // Mobile.show(); we can't do this
        // Mobile.show1();
        // Mobile.show2(mob2);

        // if we can't create any object and want to load the class, we do this by Class
        // Class.forName("StaticKeywordDemo");
    }
}
