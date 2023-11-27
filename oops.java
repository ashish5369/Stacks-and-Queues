public class oops {
    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + age + "says hi");
        }

        // by default a function gets created with the same name as the class and that
        // is constructor
        Person() {
        }
        // even if we forget then also java creates a constructor by deafult

        // this a parametrized contrusctor
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // two ways to create a objetc

        Person p1 = new Person();

        p1.age = 10;
        p1.name = "a";
        p1.saysHi();

        // or we can use parametrized constructor

        Person p2 = new Person(20, "b"); 
        p2.saysHi();

    }
}