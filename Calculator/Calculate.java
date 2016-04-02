package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  простой калькулятор для командной строки
 */
public class Calculate {

    public static void main(String[] args) {
        UserInteract interaction = new UserInteract();
        Calculator calc = new Calculator();

        double first;
        double second;
        String operation;

        while (true) {
            String[] inputs = interaction.getUserCommands();

            if (interaction.MemoryAsFirstArg()) {
                first = calc.getLastResult();
            } else {
                first = Double.parseDouble(inputs[0]);
            }

            if (interaction.MemoryAsSecondArg()) {
                second = calc.getLastResult();
            } else {
                second = Double.parseDouble(inputs[2]);
            }

            operation = inputs[1];

            calc.calculate(first, second, operation);
            double curResult = calc.getLastResult();
            System.out.printf("result is %f\n", curResult);
        }
    }

    /**
     *  Работает с вводом пользователя, реализует их предварительную обработку, возвращает массив строк.
     */
    public static class UserInteract {
        private final Scanner scan;
        private boolean memoryFirst;
        private boolean memorySecond;
        private String[] inputs;

        public UserInteract() {
            this.scan = new Scanner(System.in);
        }

        /**
         *  Получает то что ввел пользователь, проверяет на корректность
         *  Возвращает массив строк
         */
        public String[] getUserCommands() {
            System.out.println("Please input first argument, operation and second argument with spaces between them");
            System.out.println("to use last result for next calculation use 'M' instead of any argument");
            System.out.println("Example: 10 * 31 or M + 21");
            System.out.println("to exit input nothing and press enter");
            String input = scan.nextLine();
            if (input.trim().isEmpty()) System.exit(-1);
            this.inputs = input.split(" ");
            if (inputs.length != 3) throw new InputMismatchException("Please input first argument, operation and second argument");
            if (inputs[0].equals("M")) this.memoryFirst = true;
            if (inputs[2].equals("M")) this.memorySecond = true;
            return inputs;
        }

        public boolean MemoryAsFirstArg() {
            return this.memoryFirst;
        }

        public boolean MemoryAsSecondArg() {
            return this.memorySecond;
        }
    }

    /**
     *  Класс калькудятор выполняет операции над числами типа double
     */
    public static class Calculator {
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
}
