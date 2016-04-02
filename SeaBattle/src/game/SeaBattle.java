package game;

import util.Point;

import java.util.Scanner;

/**
 * Created by kdm on 02.04.16.
 */
public class SeaBattle {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Field field = new Field();

        Ship ship = new Ship(new Point(1, 1), new Point(3, 1));
        field.addShip(ship);

        System.out.println("Please input player name");
        String name = scan.nextLine();

        Player player = new Player(name);

        while (field.haveShips()) {
            System.out.println(field.toString());
            Point shootCoord = player.shoot();
            if (field.isShipThere(shootCoord)) {
                System.out.println("Hit!");
                field.updateField(shootCoord);
            } else {
                System.out.println("Miss!");
            }
        }
        System.out.println("You won!");
    }
}
