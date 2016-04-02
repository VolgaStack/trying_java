package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Работает с вводом пользователя, реализует их предварительную обработку, возвращает массив строк.
 */
public class UserInteract {
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
