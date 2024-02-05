class OuterClass{
    int age;

    public void show(){
        System.out.println("in Outer Class");
    }

    class InnerClass{
        public void config(){
            System.out.println("in Inner Class");
        }
    }

    // we can make only inner classes as static(no need of object creation)
    static class StaticInnerClass {
        public void config(){
            System.out.println("in Static Inner Class");
        }
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        OuterClass obj = new OuterClass();
        obj.show();

        // if we want to create object of inner class we 1st need object of outer class
        OuterClass.InnerClass obj1 = obj.new InnerClass();
        obj1.config();

        OuterClass.StaticInnerClass obj2 = new OuterClass.StaticInnerClass();
        obj2.config();
        
    }
}
