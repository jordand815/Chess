package com.example.chess;

import java.util.*;

public class Bishop extends ChessPiece {

    private int[][] possibleMoves = new int[28][2];

    //------------------------------------------------------------------------------------------------------------
    // constructs a bishop with no arguments
    //-------------------------------------------------------------------------------------------------------------
    public Bishop () {
        super();
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a bishop with some arguments
    //-------------------------------------------------------------------------------------------------------------
    public Bishop (int x, int y) {
        super(x, y);
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a bishop with all arguments
    //-------------------------------------------------------------------------------------------------------------
    public Bishop (int x, int y, boolean color) {
        super(x, y, color);
    }

    public String getType () {
        String returnString = new String("Bishop");
        return returnString;
    }

    private void createPositionArray () {
        int index = 0;
        for (int x=-7; x<=7; x++) {
          for (int y=-7; y<=7; y++) {
              if (Math.abs(x) == Math.abs(y) && x != 0 && y!=0) {
                  possibleMoves[index][0] = x;
                  possibleMoves[index][1] = y;
                  index++;
              }
          }
        }

    }

    public Position[] getPossibleMoves(ChessBoard board) {
        this.createPositionArray();
        Position[] positionList = new Position[0];

        for (int i = 0; i < possibleMoves.length; i++) {
            Position newPosition = new Position(possibleMoves[i][0] + this.getPosition().getX(), possibleMoves[i][1] + this.getPosition().getY());
            positionList = addToPositionList(newPosition, positionList);
        }
        return positionList;
    }

    boolean pieceBlockingPath(Position newSpace, ChessBoard board) {
        if (this.getPosition().getX() < newSpace.getX()&& this.getPosition().getY() < newSpace.getY()) {
            int j = this.getPosition().getY();
            for (int i = this.getPosition().getX(); i <= newSpace.getX(); i++) {
                Position currentSpace = new Position(i, j);
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false) {
                    return true;
                }
            }
        }
        if (this.getPosition().getX() > newSpace.getX()&& this.getPosition().getY() < newSpace.getY()) {
            int j = newSpace.getY();
            for (int i = newSpace.getX(); i <= this.getPosition().getX(); i++) {
                Position currentSpace = new Position(i, j);
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false)  {
                    return true;
                }
                j--;
            }
        }

        if (this.getPosition().getX() < newSpace.getX()&& this.getPosition().getY() > newSpace.getY()) {
            int j = this.getPosition().getY();
            for (int i = this.getPosition().getX(); i <= newSpace.getX(); i++) {
                Position currentSpace = new Position(i, j);
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false)  {
                    return true;
                }
                j--;
            }
        }
        if (this.getPosition().getX() > newSpace.getX()&& this.getPosition().getY() > newSpace.getY()) {
            int j = newSpace.getY();
            for (int i = newSpace.getX(); i <= this.getPosition().getX(); i++) {
                Position currentSpace = new Position(i, j);
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false)  {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------
    // prints a bishop piece
    //-------------------------------------------------------------------------------------------------------------
    public String toString () {
        String returnString = new String("-b- ");
        return returnString;
    }
}
