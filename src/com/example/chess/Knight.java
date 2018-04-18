package com.example.chess;

public class Knight extends ChessPiece {

    private int[][] possibleMoves = {{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    //------------------------------------------------------------------------------------------------------------
    // constructs a pawn with no arguments
    //-------------------------------------------------------------------------------------------------------------
    public Knight () {
        super();
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a knight with some arguments
    //-------------------------------------------------------------------------------------------------------------
    public Knight (int x, int y) {
        super(x, y);
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a knight with all arguments
    //-------------------------------------------------------------------------------------------------------------
    public Knight (int x, int y, boolean color) {
        super(x, y, color);
    }

    public String getType () {
        String returnString = new String("Knight");
        return returnString;
    }

    Position[] getPossibleMoves(ChessBoard board) {
        Position[] positionList = new Position[0];

        for (int i = 0; i < possibleMoves.length; i++) {
            Position newPosition = new Position(possibleMoves[i][0] + this.getPosition().getX(), possibleMoves[i][1] + this.getPosition().getY());
            positionList = addToPositionList(newPosition, positionList);
        }
        return positionList;
    }

    boolean pieceBlockingPath(Position newSpace, ChessBoard board) {
        if (board.spaceOccupied(newSpace)==true) {
            return true;
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------
    // returns a list of all possible moves
    //-------------------------------------------------------------------------------------------------------------
    public Position[] getPossibleMoves () {
        Position[] positionList = new Position[0];
        return positionList;
    }

    //------------------------------------------------------------------------------------------------------------
    // prints a knight piece
    //-------------------------------------------------------------------------------------------------------------
    public String toString () {
        String returnString = new String("-h- ");
        return returnString;
    }
}
