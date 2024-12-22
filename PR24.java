class Complex {
    private int real;
    private int image;

    public Complex() {
        this.real = 0;
        this.image = 0;
    }

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return real + " + " + image + "i";
    }
}
interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int image);
}
class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex();
    }

    @Override
    public Complex createComplex(int real, int image) {
        return new Complex(real, image);
    }
}
public class PR24 {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();

        Complex defaultComplex = factory.createComplex();
        System.out.println("Default Complex: " + defaultComplex);

        Complex customComplex = factory.createComplex(5, 10);
        System.out.println("Custom Complex: " + customComplex);
    }
}