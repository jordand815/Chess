package com.example.chess;

public class ChessBoard {

    ChessPiece[] gamepieces =  new ChessPiece[0];

    public ChessPiece[] getPiecesList() {
        return this.gamepieces;
    }

    //-----------------------------------------------------------------------------------------------------------
    // Determines if a specific space is occupied
    //-----------------------------------------------------------------------------------------------------------
    public boolean spaceOccupied (Position space) {
        boolean returnBoolean = false;
        try {
            for (int i = 0; i < this.gamepieces.length; i++) {
                if (this.gamepieces[i].getPosition().equals(space)) {
                    returnBoolean = true;
                }
            }
        }
        catch (NullPointerException x) {
            returnBoolean = false;
        }
        return returnBoolean;
    }

    //---------------------------------------------------------------------------------------------------------
    // returns the piece at a specific space
    //---------------------------------------------------------------------------------------------------------
    public int returnPieceAt(Position position) {
        int returnInt = 0;
        for (int i=0; i < gamepieces.length; i++) {
            if (gamepieces[i].getPosition().equals(position)) {
                returnInt = i;
            }
        }
        return returnInt;
    }
    //-------------------------------------------------------------------------------------------------------------
    // adds a new chess piece to the board
    //-------------------------------------------------------------------------------------------------------------
    public void addNewPiece (String type, int x, int y) {

        ChessPiece[] newGamePieces= new ChessPiece[gamepieces.length+1];

        for (int i = 0; i < gamepieces.length; i++) {
            newGamePieces[i] = gamepieces[i];
        }

        if (type.equalsIgnoreCase("pawn")) {
            Pawn newPawn = new Pawn (x, y);
            newGamePieces[newGamePieces.length-1]=newPawn;
            this.gamepieces = newGamePieces;
            System.out.println("Pawn piece created at " + x + ", " + y + "!");
        }

        else if (type.equalsIgnoreCase("rook")) {
            Rook newRook = new Rook (x, y);
            newGamePieces[newGamePieces.length-1]=newRook;
            this.gamepieces = newGamePieces;
            System.out.println("Rook piece created at " + x + ", " + y + "!");
        }

        else if (type.equalsIgnoreCase("knight")) {
            Knight newKnight = new Knight (x, y);
            newGamePieces[newGamePieces.length-1]=newKnight;
            this.gamepieces = newGamePieces;
            System.out.println("Knight piece created at " + x + ", " + y + "!");
        }

        else if (type.equalsIgnoreCase("bishop")) {
            Bishop newBishop = new Bishop (x, y);
            newGamePieces[newGamePieces.length-1]=newBishop;
            this.gamepieces = newGamePieces;
            System.out.println("Bishop piece created at " + x + ", " + y + "!");
        }
    }

    public void movePieceAt (Position space, Position newSpace) {
        this.gamepieces[this.returnPieceAt(space)].move(newSpace, this);
    }
    //--------------------------------------------------------------------------------------------------------------
    // Used to print the chess board
    //--------------------------------------------------------------------------------------------------------------
    public String toString () {
        String returnString = "";
        Position currentSpace = new Position(0,0);
        for (int i = 7; i >= 0; i--) {
            currentSpace.setY(i);
            returnString += "=";
            returnString += i;
            returnString += "= ";
            for (int j = 0; j <= 7; j++) {
                currentSpace.setX(j);
                // Checks if a space is occupied and returns a gamepiece instead of a blank space if it is
                if (this.spaceOccupied(currentSpace) == false) {
                    returnString += "--- ";
                }
                else {
                    returnString += gamepieces[returnPieceAt(currentSpace)].toString();
                }
            }
            returnString += "\n";
        }
        returnString += "    =0= =1= =2= =3= =4= =5= =6= =7=";
        return returnString;
    }
}
