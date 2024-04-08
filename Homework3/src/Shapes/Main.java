package Shapes;

interface Shape {
    double calculatePerimeter();
    double calculateArea();
}


class Circle implements Shape {
    private final double radius;
    private final String fillColor;
    private final String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void displayInfo() {
        System.out.println("Circle Perimeter: " + calculatePerimeter());
        System.out.println("Circle Area: " + calculateArea());
        System.out.println("Fill Color: " + fillColor);
        System.out.println("Border Color: " + borderColor);
    }
}


class Rectangle implements Shape {
    private final double width;
    private final double height;
    private final String fillColor;
    private final String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public void displayInfo() {
        System.out.println("Rectangle Perimeter: " + calculatePerimeter());
        System.out.println("Rectangle Area: " + calculateArea());
        System.out.println("Fill Color: " + fillColor);
        System.out.println("Border Color: " + borderColor);
    }
}


class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public void displayInfo() {
        System.out.println("Triangle Perimeter: " + calculatePerimeter());
        System.out.println("Triangle Area: " + calculateArea());
        System.out.println("Fill Color: " + fillColor);
        System.out.println("Border Color: " + borderColor);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Красный", "Чёрные");
        circle.displayInfo();

        System.out.println();

        Rectangle rectangle = new Rectangle(3, 4, "Голубой", "Зелёные");
        rectangle.displayInfo();

        System.out.println();

        Triangle triangle = new Triangle(3, 4, 5, "Оранжевый", "Жёлтые");
        triangle.displayInfo();
    }
}
