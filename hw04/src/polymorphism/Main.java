package polymorphism;

public class Main {

    public static void main(String[] args) {

        Shape circle = new Circle(3);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 4);

        Shape[] shapes = new Shape[]{circle, square, triangle};

        for (Shape shape : shapes) {
            System.out.println(shape.calculateArea());
        }
    }
}
