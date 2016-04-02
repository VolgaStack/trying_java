package Calculator;

/**
 *  Класс калькудятор выполняет операции над числами типа double
 */
public class Calculator {
    private double lastResult;

    public Calculator() {
        this.lastResult = 0;
    }

    /**
     * Получает на вход числа и операцию, сохраняет результат в переменную lastResult
     * @param first первый аргумент
     * @param second второй аргумент
     * @param operation операция
     */
    public void calculate(double first, double second, String operation) {
        switch (operation) {
            case "*":
                this.lastResult = multiply(first, second);
                break;
            case "/":
                this.lastResult = divide(first, second);
                break;
            case "+":
                this.lastResult = add(first, second);
                break;
            case "-":
                this.lastResult = subtract(first, second);
                break;
        }
    }

    private double add(double first, double second) {
        return first + second;
    }

    private double subtract(double first, double second) {
        return first - second;
    }

    private double multiply(double first, double second) {
        return first * second;
    }

    private double divide(double first, double second) {
        return first / second;
    }

    public double getLastResult() {
        return lastResult;
    }
}
