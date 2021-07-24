package com.company;

import java.util.Scanner;

import static com.company.Desc.*;
import static com.company.gameMoves.*;

public class Main {

    private static int countOfMoves = 0;

    public static void main(String[] args) {


        initDesc();
        printMap();

        do {
            try {

                if (countOfMoves % 2 == 0) {
                    System.out.println("turn white  ");

                    System.out.println("enter coordinates figures ");
                    Scanner sc = new Scanner(System.in);
                    String coordinatesFigures = sc.nextLine();

                    int indexFiguresCollum = coordinatesFigures.charAt(0) - 97;
                    int indexFiguresLines = SIZE - Integer.parseInt(String.valueOf(coordinatesFigures.charAt(1)));

                    // System.out.println(indexFiguresLines + " " + indexFiguresCollum);

                    System.out.println("enter coordinates figures move");
                    String coordinatesFiguresWill = sc.nextLine();

                    int indexFiguresCollumWill = coordinatesFiguresWill.charAt(0) - 97;
                    int indexFiguresLinesWill = SIZE - Integer.parseInt(String.valueOf(coordinatesFiguresWill.charAt(1)));

                    if (indexFiguresCollum > 7 || indexFiguresLines > 7 || indexFiguresCollumWill > 7 || indexFiguresLinesWill > 7) {
                        System.out.println("coordinates is not true");
                    }


                    if (turnWhite(indexFiguresLines, indexFiguresCollum)) {

                        if (indexFiguresCollum > -1 && indexFiguresCollum < 8 &&
                                indexFiguresLines > -1 && indexFiguresLines < 8 &&
                                indexFiguresCollumWill > -1 && indexFiguresCollumWill < 8 &&
                                indexFiguresLinesWill > -1 && indexFiguresLinesWill < 8
                            //map[coordinatesFiguresCollumWill][coordinatesFiguresLinesWill] == DOT_EMPTY &&
                            //   map[coordinatesFiguresCollum][coordinatesFiguresLines] != DOT_EMPTY )
                        ) {

                            if (canToGo(map[indexFiguresLines][indexFiguresCollum], indexFiguresLines, indexFiguresCollum,
                                    indexFiguresLinesWill, indexFiguresCollumWill)) {

                                if (!shahWhite()) {

                                    if (map[indexFiguresLines][indexFiguresCollum] == 'K') {
                                        if (indexFiguresLinesWill == 7 && indexFiguresCollumWill == 2 && !LOCATION_KING_WHITE && !LOCATION_TOUR_WHITE_LEFT &&
                                                map[7][1] == DOT_EMPTY && map[7][2] == DOT_EMPTY && map[7][3] == DOT_EMPTY ){

                                            map[indexFiguresLinesWill][indexFiguresCollumWill] = 'K';
                                            map[7][4] = DOT_EMPTY;
                                            map[7][3] = 'T';
                                            map[7][0] = DOT_EMPTY;

                                            countOfMoves++;
                                            LOCATION_KING_WHITE = true;
                                        }
                                    }else {

                                        if (map[indexFiguresLines][indexFiguresCollum] == 'K' ){
                                            LOCATION_KING_WHITE = true;
                                        }
                                        if ( map[indexFiguresLines][indexFiguresCollum] == 'T'){
                                            if (indexFiguresCollum == 2){
                                                LOCATION_TOUR_WHITE_LEFT = true;
                                            }else{
                                                LOCATION_TOUR_WHITE_RIGHT = true;
                                            }
                                        }

                                        map[indexFiguresLinesWill][indexFiguresCollumWill] = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                        countOfMoves++;

                                        if (indexFiguresLinesWill == 0 && map[indexFiguresLinesWill][indexFiguresCollumWill] == 'P') {
                                            chengFiguresForWhite(indexFiguresLinesWill, indexFiguresCollumWill);
                                        }
                                    }

                                } else {

                                    if (map[indexFiguresLines][indexFiguresCollum] == 'K') {
                                        char tWill = map[indexFiguresLinesWill][indexFiguresCollumWill];
                                        char tNow = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLinesWill][indexFiguresCollumWill] = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                        int lI = LOCATION_KING_WHITE_I;
                                        int lJ = LOCATION_KING_WHITE_J;
                                        LOCATION_KING_WHITE_I = indexFiguresLinesWill;
                                        LOCATION_KING_WHITE_J = indexFiguresCollumWill;

                                        if (!shahWhite()) {
                                            // map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                            countOfMoves++;
                                        } else {
                                            map[indexFiguresLinesWill][indexFiguresCollumWill] = tWill;
                                            map[indexFiguresLines][indexFiguresCollum] = tNow;
                                            LOCATION_KING_WHITE_I = lI;
                                            LOCATION_KING_WHITE_J = lJ;
                                        }
                                    } else {
                                        char tWill = map[indexFiguresLinesWill][indexFiguresCollumWill];
                                        char tNow = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLinesWill][indexFiguresCollumWill] = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;

                                        if(indexFiguresLinesWill == 0){
                                            chengFiguresForWhite(indexFiguresLinesWill, indexFiguresCollumWill);
                                        }

                                        if (!shahWhite()) {
                                            // map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                            countOfMoves++;
                                        } else {
                                            map[indexFiguresLinesWill][indexFiguresCollumWill] = tWill;
                                            map[indexFiguresLines][indexFiguresCollum] = tNow;
                                        }
                                    }
                                }

                                if (indexFiguresLinesWill == 0 && map[indexFiguresLinesWill][indexFiguresCollumWill] == 'P') {
                                    chengFiguresForWhite(indexFiguresLinesWill, indexFiguresCollumWill);
                                }

                                printMap();

                                if (shahBleak()) {
                                    System.out.println("\n SHAH TO BLEAK \n");
                                }

                            }
                        }

                    } else {
                        System.out.println(" is not true coordinates for white");
                    }
                } else {

                    System.out.println("turn bleak  ");

                    System.out.println("enter coordinates figures ");
                    Scanner sc = new Scanner(System.in);
                    String coordinatesFigures = sc.nextLine();

                    int indexFiguresCollum = coordinatesFigures.charAt(0) - 97;
                    int indexFiguresLines = SIZE - Integer.parseInt(String.valueOf(coordinatesFigures.charAt(1)));

                    // System.out.println(indexFiguresLines + " " + indexFiguresCollum);

                    System.out.println("enter coordinates figures move");
                    String coordinatesFiguresWill = sc.nextLine();

                    int indexFiguresCollumWill = coordinatesFiguresWill.charAt(0) - 97;
                    int indexFiguresLinesWill = SIZE - Integer.parseInt(String.valueOf(coordinatesFiguresWill.charAt(1)));

                    if (indexFiguresCollum > 7 || indexFiguresLines > 7 || indexFiguresCollumWill > 7 || indexFiguresLinesWill > 7) {
                        System.out.println("coordinates is not true");
                    }

                    if (turnBleak(indexFiguresLines, indexFiguresCollum)) {

                        if (indexFiguresCollum > -1 && indexFiguresCollum < 8 &&
                                indexFiguresLines > -1 && indexFiguresLines < 8 &&
                                indexFiguresCollumWill > -1 && indexFiguresCollumWill < 8 &&
                                indexFiguresLinesWill > -1 && indexFiguresLinesWill < 8
                            //map[coordinatesFiguresCollumWill][coordinatesFiguresLinesWill] == DOT_EMPTY &&
                            //   map[coordinatesFiguresCollum][coordinatesFiguresLines] != DOT_EMPTY )
                        ) {

                            if (canToGo(map[indexFiguresLines][indexFiguresCollum], indexFiguresLines, indexFiguresCollum,
                                    indexFiguresLinesWill, indexFiguresCollumWill)) {
                                if (!shahBleak()) {
                                    if (map[indexFiguresLines][indexFiguresCollum] == 'k') {

                                        LOCATION_KING_BLEAK_I = indexFiguresLinesWill;
                                        LOCATION_KING_BLEAK_J = indexFiguresCollumWill;
                                    }
                                    map[indexFiguresLinesWill][indexFiguresCollumWill] = map[indexFiguresLines][indexFiguresCollum];
                                    map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                    countOfMoves++;


                                } else {

                                    if (map[indexFiguresLines][indexFiguresCollum] == 'k') {
                                        char tWill = map[indexFiguresLinesWill][indexFiguresCollumWill];
                                        char tNow = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLinesWill][indexFiguresCollumWill] = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                        int lI = LOCATION_KING_BLEAK_I;
                                        int lJ = LOCATION_KING_BLEAK_J;
                                        LOCATION_KING_BLEAK_I = indexFiguresLinesWill;
                                        LOCATION_KING_BLEAK_J = indexFiguresCollumWill;

                                        if (!shahBleak()) {
                                            // map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                            countOfMoves++;
                                        } else {
                                            map[indexFiguresLinesWill][indexFiguresCollumWill] = tWill;
                                            map[indexFiguresLines][indexFiguresCollum] = tNow;
                                            LOCATION_KING_BLEAK_I = lI;
                                            LOCATION_KING_BLEAK_J = lJ;
                                        }
                                    } else {
                                        char tWill = map[indexFiguresLinesWill][indexFiguresCollumWill];
                                        char tNow = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLinesWill][indexFiguresCollumWill] = map[indexFiguresLines][indexFiguresCollum];
                                        map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;

                                        if(indexFiguresLinesWill == 0){
                                            chengFiguresForBleak(indexFiguresLinesWill, indexFiguresCollumWill);
                                        }

                                        if (!shahBleak()) {
                                            // map[indexFiguresLines][indexFiguresCollum] = DOT_EMPTY;
                                            countOfMoves++;
                                        } else {
                                            map[indexFiguresLinesWill][indexFiguresCollumWill] = tWill;
                                            map[indexFiguresLines][indexFiguresCollum] = tNow;
                                        }
                                    }
                                }

                                if (indexFiguresLinesWill == 0 && map[indexFiguresLinesWill][indexFiguresCollumWill] == 'p') {
                                    chengFiguresForBleak(indexFiguresLinesWill, indexFiguresCollumWill);
                                }

                                printMap();

                                if (shahWhite()) {
                                    System.out.println("\n SHAH TO WHITE \n");
                                }

                            }
                        }

                    } else {
                        System.out.println(" is not true coordinates for bleak");
                    }
                }
            } catch (Exception e) {
                System.out.println("coordinates is not true, try again");
            }

        } while (!matBleak() && !matWhite());

    }
}

