package game;

import util.Point;

import java.util.Scanner;

/**
 * Created by kdm on 02.04.16.
 */
public class Player {
    private String name;
    private Scanner scan;

    public Player(String name) {
        this.name = name;
        this.scan = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public Point shoot() {
        System.out.println("Please input coordinates like x:y");
        String[] coordinates = scan.nextLine().split(":");
        return new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }
}
