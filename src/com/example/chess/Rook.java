package com.example.chess;

public class Rook extends ChessPiece {

    private int[][] possibleMoves = new int[28][2];

    //------------------------------------------------------------------------------------------------------------
    // constructs a rook with no arguments
    //-------------------------------------------------------------------------------------------------------------
    public Rook () {
        super();
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a rook with some arguments
    //-------------------------------------------------------------------------------------------------------------
    public Rook (int x, int y) {
        super(x, y);
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a rook with all arguments
    //-------------------------------------------------------------------------------------------------------------
    public Rook (int x, int y, boolean color) {
        super(x, y, color);
    }

    String getType() {
        return null;
    }

    private void createPositionArray () {
        for (int i = 0; i < 14; i++) {
            this.possibleMoves[i][0] = 7-i;
            this.possibleMoves[i][1] = 0;
        }
        for (int i = 14; i < possibleMoves.length; i++) {
            this.possibleMoves[i][0] = 0;
            this.possibleMoves[i][1] = 21-i;
        }
    }

    Position[] getPossibleMoves(ChessBoard board) {
        this.createPositionArray();
        Position[] positionList = new Position[0];

        for (int i = 0; i < possibleMoves.length; i++) {
            Position newPosition = new Position(possibleMoves[i][0] + this.getPosition().getX(), possibleMoves[i][1] + this.getPosition().getY());
            positionList = addToPositionList(newPosition, positionList);
        }
        return positionList;
    }

    boolean pieceBlockingPath(Position newSpace, ChessBoard board) {
        if (this.getPosition().getX()<newSpace.getX()) {
            for (int i= this.getPosition().getX(); i <= newSpace.getX(); i++) {
                Position currentSpace = new Position(i, this.getPosition().getY());
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false) {
                    return true;
                }
            }
        }
        if (this.getPosition().getX()>newSpace.getX()) {
            for (int i= newSpace.getX(); i <= this.getPosition().getX(); i++) {
                Position currentSpace = new Position(i, this.getPosition().getY());
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false) {
                    return true;
                }
            }
        }

        if (this.getPosition().getY() < newSpace.getY()) {
            for (int i= this.getPosition().getY(); i <= newSpace.getY(); i++){
                Position currentSpace = new Position(this.getPosition().getX(), i);
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false) {
                    return true;
                }
            }
        }
        if (this.getPosition().getY()>newSpace.getY()) {
            for (int i= newSpace.getY(); i <= this.getPosition().getY(); i++) {
                Position currentSpace = new Position(this.getPosition().getX(), i);
                if (board.spaceOccupied(currentSpace)==true && this.getPosition().equals(currentSpace)==false) {
                    return true;
                }
            }
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------
    // prints a rook piece
    //-------------------------------------------------------------------------------------------------------------
    public String toString () {
        String returnString = new String("-r- ");
        return returnString;
    }
}
