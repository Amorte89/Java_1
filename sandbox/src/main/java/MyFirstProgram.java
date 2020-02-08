public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("user");
        hello("Nikita");

        double l = 6;
        System.out.println("Площать квадрата со стороной " + l + " = " + area(l));

        double a = 7;
        double b = 8;
        System.out.println("Площать прямоугольника со сторонами " + a + " и " + b +  " = " + area(a, b));



    }


    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double area(double len) {
        return  len * len;
    }

    public static double area(double a, double b) {
        return  a * b;
    }

}