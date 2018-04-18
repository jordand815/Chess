package com.example.chess;

public class Position {

    private int positionX;
    private int positionY;
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 7;

    public Position () {
        positionX = 0;
        positionY = 0;
    }

    public Position (int x, int y) {
        positionX = x;
        positionY = y;
    }

    public int getX () {
        return this.positionX;
    }

    public int getY () {
        return this.positionY;
    }

    public void setX (int newX) {
        this.positionX = newX;
    }

    public void setY (int newY) {
        this.positionY = newY;
    }

    public boolean moveOutOfBounds () {
        if (this.positionX > MAX_POSITION || this.positionX < MIN_POSITION||this.positionY > MAX_POSITION || this.positionY < MIN_POSITION) {
            return true;
        }
        return false;
    }

    public String toString () {
        String returnString ="(" + positionX + ", " + positionY + ")";
        return returnString;
    }

    public boolean equals (Position position2) {
        if (this.getX()==position2.getX() && this.getY()==position2.getY()) {
            return true;
        }
        return false;
    }

}
