package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Desc {
    public static int SIZE = 8;
    public static char[][] map;
    public static final char DOT_EMPTY = '•';
    public static String BLAKE = "prhbqkt";
    public static String WHITE = "PRHQBKT";

    public static int LOCATION_KING_WHITE_I = 7;
    public static int LOCATION_KING_WHITE_J = 4;
    public static int LOCATION_KING_BLEAK_I = 0;
    public static int LOCATION_KING_BLEAK_J = 4;


    public static boolean LOCATION_TOUR_WHITE_LEFT ;
    public static boolean LOCATION_TOUR_WHITE_RIGHT ;
    public static boolean LOCATION_TOUR_BLEAK_LEFT ;
    public static boolean LOCATION_TOUR_BLEAK_RIGHT ;
    public static boolean LOCATION_KING_BLEAK ;
    public static boolean LOCATION_KING_WHITE ;

    public static void initDesc() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

      /* for (int i = 0; i < SIZE; i++) {
            map[1][i] = 'p';
            map[6][i] = 'P';
        }

        map[0][0] = 't';
        map[0][7] = 't';
        map[7][0] = 'T';
        map[7][7] = 'T';

        map[0][1] = 'h';
        map[0][6] = 'h';
        map[7][6] = 'H';
        map[7][1] = 'H';

        map[0][2] = 'b';
        map[0][5] = 'b';
        map[7][5] = 'B';
        map[7][2] = 'B';

        map[0][3] = 'q';
        map[0][4] = 'k';
        map[7][3] = 'Q';
        map[7][4] = 'K';*/

        map[1][5] = 't'; // todo for mat bleak

        map[0][0] = 't';
        map[0][7] = 't';
        map[7][0] = 'T';
        map[7][7] = 'T';

        map[0][1] = 'h';
        map[0][6] = 'h';
        map[7][6] = 'H';
        map[7][1] = 'H';

        map[0][2] = 'b';
        map[0][5] = 'b';
        map[7][5] = 'B';
        map[4][2] = 'B';

        map[0][3] = 'q';
        map[0][4] = 'k';
        map[3][7] = 'Q';
        map[7][4] = 'K';


    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print("    ");
            } else {
                System.out.print((char) (96 + i) + "   ");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((8 - i) + "   ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isDotEmpty(int i, int j) {
        return map[i][j] == DOT_EMPTY;
    }

}


//TODO  роккер

//3. пешка доходит до конца и не становится ферзем



// 1 .  детский мат не работает

// 2.