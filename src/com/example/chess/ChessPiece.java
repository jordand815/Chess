package com.example.chess;

public abstract class ChessPiece {

    protected Position position;
    protected  boolean color;
    public static final boolean BLACK = true;
    public static final boolean WHITE = false;

    public ChessPiece () {
        position = new Position(0,0);
        color = BLACK;
    }

    public ChessPiece (int x, int y) {
        this.position = new Position(x,y);
        this.color = BLACK;
    }

    public ChessPiece (int x, int y, boolean color) {
        this.position = new Position(x,y);
        this.color = color;
    }

    public Position getPosition () {
        return this.position;
    }

    public boolean getColor () {
        return this.color;
    }

    protected Position[] addToPositionList (Position newPosition, Position[] positionList) {
        Position[] returnList = new Position[positionList.length + 1];
        returnList[returnList.length-1] = newPosition;
        if (positionList.length !=0) {
            for (int i = 0; i < positionList.length; i++) {
                Position index = new Position(positionList[i].getX(), positionList[i].getY());
                returnList[i] = index;
            }
        }
        return returnList;
    }

    protected Position[] removeFromPositionList (Position oldPosition, Position[] positionList) {
        Position[] returnList = new Position[positionList.length - 1];
        for (int i = 0; i < positionList.length; i++) {
            if (positionList[i].equals(oldPosition)) {
                positionList[i] = positionList[positionList.length-1];
            }
        }
        for (int i = 0; i < positionList.length-1; i++) {
            returnList[i] = positionList[i];
        }
        return returnList;
    }

    protected boolean isMovePossible (Position space, ChessBoard board) {
        Position [] positionList = getPossibleMoves(board);
        for (int i = 0; i < positionList.length; i++) {
            if (positionList[i].equals(space)) {
                return true;
            }
        }
        return false;
    }

    abstract String getType ();

    abstract Position[] getPossibleMoves (ChessBoard board);

    abstract boolean pieceBlockingPath (Position newSpace, ChessBoard board);

    public void move (Position newSpace, ChessBoard board) {
        if (newSpace.moveOutOfBounds()) {
            throw new moveOutOfBoundsException("This move is out of bounds");
        }
        else if (this.isMovePossible(newSpace, board)==false) {
            throw new moveNotPossibleException("This move is not possible");
        }
        else if (pieceBlockingPath(newSpace, board)==true) {
            throw new PathwayException("There is another piece in the way");
        }
        else {
            this.position = newSpace;
        }
    }

}
