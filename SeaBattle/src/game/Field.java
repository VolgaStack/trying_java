package game;

import util.Point;

/**
 * Created by kdm on 02.04.16.
 */
public class Field {
    private boolean[][] field;

    public Field() {
        this.field = new boolean[10][10];
    }

    public void addShip(Ship ship) {
        int startX = ship.getStartPoint().getX();
        int startY = ship.getStartPoint().getY();

        int sizeX = Math.abs(ship.getStartPoint().getX() - ship.getEndPoint().getX());
        int sizeY = Math.abs(ship.getStartPoint().getY() - ship.getEndPoint().getY());

        for (int i = startX; i <= sizeX + 1; i++) {
            field[i][startY] = true;
        }

        for (int i = startY; i <= sizeY + 1; i++) {
            field[startX][i] = true;
        }
    }

    public boolean isShipThere(Point point) {
        return field[point.getX()][point.getY()];
    }

    public boolean haveShips() {
        for (boolean[] booleen : field) {
            for (boolean b : booleen) {
                if (b == true) return true;
            }
        }
        return false;
    }

    public void updateField(Point point) {
        field[point.getX()][point.getY()] = false;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("  0 1 2 3 4 5 6 7 8 9\n");
        int column = 0;
        for (boolean[] booleen : field) {
            strBuild.append(column + " ");
            for (boolean b : booleen) {
                if (b == true) {
                    strBuild.append("s ");
                } else {
                    strBuild.append(". ");
                }
            }
            column++;
            strBuild.append("\n");
        }
        return strBuild.toString();
    }
}
