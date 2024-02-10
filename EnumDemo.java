enum Status { // enum is class but we can't extends it
    Running, Failed, Pending, Success; // these all are object
}

enum Laptop {
    Macbook(2000), XPS(2200), Surface, THinkPad(1800);

    private int price;

    private Laptop() {
        this.price = 500;
    }

    private Laptop(int price) { // here we create constructor as private, becoz we create object with-in the
                                // class
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Status s = Status.Running;
        System.out.println(s); // Running
        System.out.println(s.ordinal()); // 0

        Status[] status = Status.values();
        for (Status ss : status) {
            System.out.println(ss + " : " + ss.ordinal());
        }

        Laptop laps = Laptop.Macbook;
        System.out.println(laps + " : " + laps.getPrice());

        for (Laptop lap : Laptop.values()) {
            System.out.println(lap + " : " + lap.getPrice());
        }

        Status s1 = Status.Success;
        if (s1 == Status.Running) {
            System.out.println("in the process..");
        } else if (s1 == Status.Failed) {
            System.out.println("Try Again!!");
        } else if (s1 == Status.Pending) {
            System.out.println("Be Patient");
        } else {
            System.out.println("You did it😊!!");
        }
    }
}
