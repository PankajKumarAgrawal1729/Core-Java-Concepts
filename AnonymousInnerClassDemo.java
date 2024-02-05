class OuterClass{
    public void show(){
        System.out.println("in Outer class show");
    }
}

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        OuterClass obj = new OuterClass(){
            // this is a anonymous inner class
            public void show(){
                System.out.println("in Outer class new show");
            }
        };
        obj.show();
    }
}
