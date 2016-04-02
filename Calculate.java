package Calculator;

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
}
