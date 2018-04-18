package com.example.chess;

import java.io.*;
import java.util.*;

public class Chess {

    public static void main(String[] args) throws IOException {

        // constructs the chess board
        ChessBoard board = new ChessBoard();
        System.out.println(board.toString());

        File inputFile = new File("src/input.txt");
        Scanner in = new Scanner(inputFile);
        String[] info = new String[0];
        String nextLine = "";
        String type = "";
        int xCoord = 0;
        int yCoord = 0;
        int xCoord1 = 0;
        int yCoord1 = 0;
        int xCoord2 = 0;
        int yCoord2 = 0;

        while(in.hasNextLine()) {
            info = in.nextLine().split(" ");
            if (info.length == 3) {
                type = info[0];
                xCoord = Integer.parseInt(info[1]);
                yCoord = Integer.parseInt(info[2]);
                board.addNewPiece(type, xCoord, yCoord);
                System.out.println(board.toString());
            }
            if (info.length == 5) {
                type = info[0];
                xCoord1 = Integer.parseInt(info[1]);
                yCoord1 = Integer.parseInt(info[2]);
                xCoord2 = Integer.parseInt(info[3]);
                yCoord2 = Integer.parseInt(info[4]);
                Position fromSpace = new Position(xCoord1, yCoord1);
                Position toSpace = new Position(xCoord2, yCoord2);
                try {
                    board.movePieceAt(fromSpace, toSpace);
                    System.out.println("Piece moved sucessfully!");
                }
                catch (moveOutOfBoundsException x) {
                    System.out.println("That move is out of bounds");
                }
                catch (moveNotPossibleException x) {
                    System.out.println("That move is not possible for this piece");
                }
               catch (PathwayException x) {
                   System.out.println("There is another piece in the way");
               }
               finally {
                        System.out.println(board.toString());
                }
            }
        }
    }
}
