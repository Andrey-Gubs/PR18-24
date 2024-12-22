public class MyGenericClass<T, V, K> {
    private T firstVariable;
    private V secondVariable;
    private K thirdVariable;

    public MyGenericClass(T firstVariable, V secondVariable, K thirdVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
        this.thirdVariable = thirdVariable;
    }

    public T getFirstVariable() {
        return firstVariable;
    }

    public V getSecondVariable() {
        return secondVariable;
    }

    public K getThirdVariable() {
        return thirdVariable;
    }

    public void printClassNames() {
        System.out.println("Тип 1 переменной: " + firstVariable.getClass().getName());
        System.out.println("Тип 2 переменной: " + secondVariable.getClass().getName());
        System.out.println("Тип 3 переменной: " + thirdVariable.getClass().getName());
    }

    public static void main(String[] args) {
        MyGenericClass<String, Integer, Double> myObject = new MyGenericClass<>("Hello", 42, 3.14);
        myObject.printClassNames();
    }
}