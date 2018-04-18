package com.example.chess;

public class Pawn extends ChessPiece {

    private boolean firstMove = true;
    private int[][] possibleMoves = {{0, 1}, {0,-1}};
    private int[][] possibleMovesFirstTurn = {{0, 1}, {0,-1}, {0, -2}, {0, 2}};

    //------------------------------------------------------------------------------------------------------------
    // constructs a pawn with no arguments
    //-------------------------------------------------------------------------------------------------------------
    public Pawn () {
        super();
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a pawn with some arguments
    //-------------------------------------------------------------------------------------------------------------
    public Pawn (int x, int y) {
        super(x, y);
    }

    //------------------------------------------------------------------------------------------------------------
    // costructs a pawn with all arguments
    //-------------------------------------------------------------------------------------------------------------
    public Pawn (int x, int y, boolean color) {
        super(x, y, color);
    }


    public Position[] getPossibleMoves (ChessBoard board) {
        Position[] positionList = new Position[0];

        if (this.firstMove == true) {
            for (int i = 0; i < possibleMovesFirstTurn.length; i++) {
                Position newPosition = new Position(possibleMovesFirstTurn[i][0] + this.getPosition().getX(), possibleMovesFirstTurn[i][1] + this.getPosition().getY());
                positionList = addToPositionList(newPosition, positionList);
            }
        } else {
            for (int i = 0; i < possibleMoves.length; i++) {
                Position newPosition = new Position(possibleMoves[i][0] + this.getPosition().getX(), possibleMoves[i][1] + this.getPosition().getY());
                positionList = addToPositionList(newPosition, positionList);
                positionList = addToPositionList(newPosition, positionList);
            }
        }
        return positionList;
    }

    public boolean pieceBlockingPath (Position newSpace, ChessBoard board) {
        Position moveSpace= new Position(this.position.getX(), this.position.getY());
        if (newSpace.getX() < this.getPosition().getX()) {
            for (int i = newSpace.getX(); i < this.getPosition().getX(); i++) {
                moveSpace.setX(i);
                if (board.spaceOccupied(newSpace) == true) {
                    return true;
                }
            }
        }
        else if (newSpace.getX() > this.getPosition().getX()) {
            for (int i = this.getPosition().getX(); i < newSpace.getX(); i++) {
                moveSpace.setX(i);
                if (board.spaceOccupied(newSpace) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public void move (Position newSpace, ChessBoard board) {
        super.move(newSpace, board);
        firstMove = false;
    }

    public String getType() {
        String pawnString = new String("Pawn");
        return pawnString;
    }

    //------------------------------------------------------------------------------------------------------------
    // prints a pawn piece
    //-------------------------------------------------------------------------------------------------------------
    public String toString () {
        String returnString = new String("-p- ");
        return returnString;
    }

}
