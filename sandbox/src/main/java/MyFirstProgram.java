public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("user");
        hello("Nikita");

        Square s = new Square(6);
        System.out.println("Площать квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(6, 7);
        System.out.println("Площать прямоугольника со сторонами " + r.a + " и " + r.b +  " = " + r.area());

    }


    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }
}