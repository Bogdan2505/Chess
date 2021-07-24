package com.company;

import java.util.Scanner;

import static com.company.Desc.*;

public class gameMoves {

    public static boolean turnWhite(int iNow, int jNow) {    // белые большие
        return WHITE.indexOf(map[iNow][jNow]) != -1;
    }

    public static boolean turnBleak(int iNow, int jNow) {    // белые большие
        return BLAKE.indexOf(map[iNow][jNow]) != -1;
    }

    public static boolean canToGo(char ch, int iNow, int jNow, int iWil, int jWil) {

        if (map[iNow][jNow] != DOT_EMPTY) {

            switch (ch) {

                case 'P':
                    if (pawnWhite(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'p':
                    if (pawnBleak(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'T':
                    if (tourWhite(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 't':
                    if (tourBleak(iNow, jNow, iWil, jWil)) {

                        if (jNow == 0) {
                            LOCATION_TOUR_BLEAK_LEFT = true;
                        } else {
                            LOCATION_TOUR_BLEAK_RIGHT = true;
                        }

                        return true;
                    }
                    break;

                case 'H':
                    if (horseWhite(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'h':
                    if (horseBleak(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'B':
                    if (bishopWhite(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'b':
                    if (bishopBleak(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'K':
                    if (kingWhite(iNow, jNow, iWil, jWil)) {
                        return true;
                    } else if (rockerWhite(iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'k':
                    if (kingBleak(iNow, jNow, iWil, jWil)) {
                        return true;
                    } /*else if (rockerWhite(iWil, jWil)) { //todo White
                        return true;
                    }*/

                    break;

                case 'Q':
                    if (queenWhite(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                case 'q':
                    if (queenBleak(iNow, jNow, iWil, jWil)) {
                        return true;
                    }
                    break;

                default: {
                    return false;
                }

            }
        }/* else {
            System.out.println("it is dot empty");
            return false;
        }*/
        return false;
    }

    private static boolean pawnWhite(int iNow, int jNow, int iWil, int jWil) {
        if (iNow == 6) {
            if (iWil == iNow - 1 && jWil == jNow
                    || (iWil == iNow - 2 && jWil == jNow && DOT_EMPTY == map[iNow - 1][jNow])) {
                return true;
            }
            return iWil == iNow - 1 && (jWil == jNow - 1 && (BLAKE.indexOf(map[iWil][jWil]) != -1)
                    || jWil == jNow + 1 && (BLAKE.indexOf(map[iWil][jWil]) != -1));
        } else {

            if (iWil == iNow - 1 && jWil == jNow && map[iWil][jWil] == DOT_EMPTY) {
                return true;
            }

            if (iWil == iNow - 1 && (jWil == jNow - 1 && (BLAKE.indexOf(map[iWil][jWil]) != -1)
                    || jWil == jNow + 1 && (BLAKE.indexOf(map[iWil][jWil]) != -1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean pawnBleak(int iNow, int jNow, int iWil, int jWil) {
        if (iNow == 1) {
            if (iWil == iNow + 1 && jWil == jNow
                    || (iWil == iNow + 2 && jWil == jNow && DOT_EMPTY == map[iNow + 1][jNow])) {
                return true;
            }
            return iWil == iNow + 1 && (jWil == jNow + 1 && (WHITE.indexOf(map[iWil][jWil]) != -1)
                    || jWil == jNow - 1 && (WHITE.indexOf(map[iWil][jWil]) != -1));
        } else {

            if (iWil == iNow + 1 && jWil == jNow && map[iWil][jWil] == DOT_EMPTY) {
                return true;
            }

            if (iWil == iNow + 1 && (jWil == jNow + 1 && (WHITE.indexOf(map[iWil][jWil]) != -1)
                    || jWil == jNow - 1 && (WHITE.indexOf(map[iWil][jWil]) != -1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean tourWhite(int iNow, int jNow, int iWil, int jWil) {


        if (iNow != iWil && jNow != jWil) {
            return false;
        }
        if (WHITE.contains(String.valueOf(map[iWil][jWil]))) {
            return false;
        }

        if (iNow == iWil) {

            if (jNow < jWil && (map[iWil][jWil] == DOT_EMPTY || BLAKE.contains(String.valueOf(map[iWil][jWil])))) {
                for (int i = jNow + 1; i < jWil; i++) {
                    if (map[iWil][i] != DOT_EMPTY) {
                        return false;
                    }
                }
            } else if (jNow > jWil && (map[iWil][jWil] == DOT_EMPTY || BLAKE.contains(String.valueOf(map[iWil][jWil])))) {
                //BLAKE.indexOf(map[iWil][jWil]) != -1
                for (int i = jNow - 1; i > jWil; i--) {
                    if (map[iWil][i] != DOT_EMPTY) {
                        return false;
                    }
                }
            }
        } else {
            if (iNow < iWil && (map[iWil][jWil] == DOT_EMPTY || BLAKE.contains(String.valueOf(map[iWil][jWil])))) {
                for (int i = iNow + 1; i < iWil; i++) {
                    if (map[i][jWil] != DOT_EMPTY) {
                        return false;
                    }
                }
            } else if (iNow > iWil && (map[iWil][jWil] == DOT_EMPTY || BLAKE.contains(String.valueOf(map[iWil][jWil])))) {
                for (int i = iNow - 1; i > iWil; i--) {
                    if (map[i][jWil] != DOT_EMPTY) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean tourBleak(int iNow, int jNow, int iWil, int jWil) {

        if (iNow != iWil && jNow != jWil) {
            return false;
        }

        if (BLAKE.contains(String.valueOf(map[iWil][jWil]))) {
            return false;
        }

        if (iNow == iWil) {

            if (jNow < jWil && (map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1)) {
                for (int i = jNow + 1; i < jWil; i++) {
                    if (map[iWil][i] != DOT_EMPTY) {
                        return false;
                    }
                }
            } else if (jNow > jWil && (map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1)) {
                for (int i = jNow - 1; i > jWil; i--) {
                    if (map[iWil][i] != DOT_EMPTY) {
                        return false;
                    }
                }
            }
        } else if (jNow == jWil) {
            if (iNow < iWil && (map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1)) {
                for (int i = iNow + 1; i < iWil; i++) {
                    if (map[i][jWil] != DOT_EMPTY) {
                        return false;
                    }
                }
            } else if (iNow > iWil && (map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1)) {
                for (int i = iNow - 1; i > iWil; i--) {
                    if (map[i][jWil] != DOT_EMPTY) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean horseWhite(int iNow, int jNow, int iWil, int jWil) {

        if ((map[iWil][jWil] == DOT_EMPTY || BLAKE.indexOf(map[iWil][jWil]) != -1) &&
                ((iWil == iNow + 2 || iWil == iNow - 2) && (jWil == jNow + 1 || jWil == jNow - 1))) {
            return true;
        }
        if ((map[iWil][jWil] == DOT_EMPTY || BLAKE.indexOf(map[iWil][jWil]) != -1) &&
                ((iWil == iNow + 1 || iWil == iNow - 1) && (jWil == jNow + 2 || jWil == jNow - 2))) {
            return true;
        }
        return false;
    }

    public static boolean horseBleak(int iNow, int jNow, int iWil, int jWil) {

        if ((map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1) &&
                ((iWil == iNow + 2 || iWil == iNow - 2) && (jWil == jNow + 1 || jWil == jNow - 1))) {
            return true;
        }
        if ((map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1) &&
                ((iWil == iNow + 1 || iWil == iNow - 1) && (jWil == jNow + 2 || jWil == jNow - 2))) {
            return true;
        }
        return false;
    }

    public static boolean bishopWhite(int iNow, int jNow, int iWil, int jWil) {

        if (Math.abs(iNow - iWil) == Math.abs(jNow - jWil)) {
            if (map[iWil][jWil] == DOT_EMPTY || BLAKE.indexOf(map[iWil][jWil]) != -1) {

                if (jNow < jWil && iNow > iWil) {
                    for (int i = 1; i < iNow - i; i++) {
                        if (map[iNow - i][jNow + i] != DOT_EMPTY) {
                            return false;
                        }
                    }
                   /* for (int i = iNow - 1; i > iWil; i--) {
                        for (int j = jNow + 1; j < jWil; j++) {
                            if (map[i][j] != DOT_EMPTY) {
                                return false;
                            }
                        }
                    }*/
                }

                if (jNow > jWil && iNow > iWil) {
                    for (int i = 1; i < iNow - i; i++) {
                        if (map[iNow - i][jNow - i] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }

                if (jNow < jWil && iNow < iWil) {
                    for (int i = 1; i < iWil - i; i++) {
                        if (map[iNow + i][jNow + i] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }

                if (jNow > jWil && iNow < iWil) {

                    for (int i = 1; i < jWil - i; i++) {
                        if (map[iNow - i][jNow + i] != DOT_EMPTY) {
                            return false;
                        }
                    }
                    /*for (int i = iNow + 1; i < iWil; i++) {
                        for (int j = jNow - 1; j > jWil; j--) {
                            if (map[i][j] != DOT_EMPTY) {
                                return false;
                            }
                        }
                    }*/
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean bishopBleak(int iNow, int jNow, int iWil, int jWil) {

        if (iWil == iNow || jWil == jNow || BLAKE.indexOf(map[iWil][jWil]) != -1 ||
                Math.abs(iNow - iWil) != Math.abs(jNow - jWil)) {
            return false;
        }

        if (map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1) {

            if (jNow < jWil && iWil > iNow) {
                for (int i = iNow + 1; i < iWil; i++) {
                    for (int j = jNow + 1; j < jWil; j++) {
                        if (map[i][j] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }
            }
            if (jNow < jWil && iWil > iNow) {
                for (int i = iNow - 1; i > iWil; i--) {
                    for (int j = jNow - 1; j > jWil; j--) {
                        if (map[i][j] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }
            }

            if (jNow > jWil) {
                for (int i = iNow - 1; i > iWil; i--) {
                    for (int j = jNow - 1; j > jWil; j--) {
                        if (map[i][j] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }
            }
            if (jNow > jWil) {
                for (int i = iNow + 1; i < iWil; i++) {
                    for (int j = jNow + 1; j < jWil; j++) {
                        if (map[i][j] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }
            }

            if (jNow > jWil && iNow < iWil) {
                for (int i = iNow - 1; i > iWil; i--) {
                    for (int j = jNow - 1; j > jWil; j--) {
                        if (map[i][j] != DOT_EMPTY) {
                            return false;
                        }
                    }
                }
            }


        }
        return true;
    }

    public static boolean kingWhite(int iNow, int jNow, int iWil, int jWil) {

        return (map[iWil][jWil] == DOT_EMPTY || BLAKE.indexOf(map[iWil][jWil]) != -1) &&
                (iWil == iNow + 1 && jNow == jWil || iWil == iNow + 1 && jNow + 1 == jWil ||
                        iWil == iNow && jNow + 1 == jWil || iWil == iNow - 1 && jNow + 1 == jWil ||
                        iWil == iNow - 1 && jNow == jWil || iWil == iNow - 1 && jNow - 1 == jWil ||
                        iWil == iNow && jNow - 1 == jWil || iWil == iNow + 1 && jNow - 1 == jWil);
    }

    public static boolean kingBleak(int iNow, int jNow, int iWil, int jWil) {

        return (map[iWil][jWil] == DOT_EMPTY || WHITE.indexOf(map[iWil][jWil]) != -1) &&
                (iWil == iNow + 1 && jNow == jWil || iWil == iNow + 1 && jNow + 1 == jWil ||
                        iWil == iNow && jNow + 1 == jWil || iWil == iNow - 1 && jNow + 1 == jWil ||
                        iWil == iNow - 1 && jNow == jWil || iWil == iNow - 1 && jNow - 1 == jWil ||
                        iWil == iNow && jNow - 1 == jWil || iWil == iNow + 1 && jNow - 1 == jWil);
    }

    public static boolean queenWhite(int iNow, int jNow, int iWil, int jWil) {

        return (bishopWhite(iNow, jNow, iWil, jWil) || tourWhite(iNow, jNow, iWil, jWil));
    }

    public static boolean queenBleak(int iNow, int jNow, int iWil, int jWil) {

        return (bishopBleak(iNow, jNow, iWil, jWil) || tourBleak(iNow, jNow, iWil, jWil));
    }

    public static boolean shahBleak() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (canToGo(map[i][j], i, j, LOCATION_KING_BLEAK_I, LOCATION_KING_BLEAK_J) &&
                        WHITE.indexOf(map[i][j]) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean shahWhite() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (canToGo(map[i][j], i, j, LOCATION_KING_WHITE_I, LOCATION_KING_WHITE_J) &&
                        BLAKE.indexOf(map[i][j]) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean matBleak() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (BLAKE.indexOf(map[i][j]) != -1 && canToGoWhenShahBleak(map[i][j], i, j)) {
                    return false;
                }
            }
        }
        System.out.println("Win white, mat");

        return true;
    }

    public static boolean matWhite() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (WHITE.indexOf(map[i][j]) != -1 && canToGoWhenShahWhite(map[i][j], i, j)) {
                    return false;
                }
            }
        }
        System.out.println("Win bleak, mat");

        return true;
    }

    public static boolean canToGoWhenShahWhite(char ch, int iNow, int jNow) {

        if (shahWhite()) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (canToGo(ch, iNow, jNow, i, j)) {
                        char ti = map[iNow][jNow];
                        char tj = map[i][j];
                        map[i][j] = map[iNow][jNow];
                        map[iNow][jNow] = DOT_EMPTY;
                        if (!shahWhite()) {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                            return true;
                        } else {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (canToGo(ch, iNow, jNow, i, j)) {
                        char ti = map[iNow][jNow];
                        char tj = map[i][j];
                        map[i][j] = map[iNow][jNow];
                        map[iNow][jNow] = DOT_EMPTY;
                        if (!shahWhite()) {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                            return true;
                        } else {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean canToGoWhenShahBleak(char ch, int iNow, int jNow) {

        if (shahBleak()) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (canToGo(ch, iNow, jNow, i, j)) {
                        char ti = map[iNow][jNow];
                        char tj = map[i][j];
                        map[i][j] = map[iNow][jNow];
                        map[iNow][jNow] = DOT_EMPTY;
                        if (!shahBleak()) {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                            return true;
                        } else {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (canToGo(ch, iNow, jNow, i, j)) {
                        char ti = map[iNow][jNow];
                        char tj = map[i][j];
                        map[i][j] = map[iNow][jNow];
                        map[iNow][jNow] = DOT_EMPTY;
                        if (!shahBleak()) {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                            return true;
                        } else {
                            map[iNow][jNow] = ti;
                            map[i][j] = tj;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void chengFiguresForWhite(int iWil, int jWil) {
        System.out.println("cheng figure\n" +
                "1. Queen\n" +
                "2. Tour\n" +
                "3. Bishop\n" +
                "4. Hours");

        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        switch (ans) {

            case 1: {
                map[iWil][jWil] = 'Q';
                break;
            }

            case 2: {
                map[iWil][jWil] = 'T';
                break;
            }

            case 3: {
                map[iWil][jWil] = 'B';
                break;
            }

            case 4: {
                map[iWil][jWil] = 'H';
                break;
            }

            default: {
                break;
            }
        }
    }

    public static void chengFiguresForBleak(int iWil, int jWil) {
        System.out.println("cheng figure\n" +
                "1. queen\n" +
                "2. tour\n" +
                "3. bishop\n" +
                "4. hours");

        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        switch (ans) {

            case 1: {
                map[iWil][jWil] = 'q';
                break;
            }

            case 2: {
                map[iWil][jWil] = 't';
                break;
            }

            case 3: {
                map[iWil][jWil] = 'b';
                break;
            }

            case 4: {
                map[iWil][jWil] = 'h';
                break;
            }

            default: {
                break;
            }
        }
    }

    public static boolean rockerWhite(int iWil, int jWil) {

        if (iWil == 7 && jWil == 2 && !LOCATION_KING_WHITE && !LOCATION_TOUR_WHITE_LEFT &&
                map[7][1] == DOT_EMPTY && map[7][2] == DOT_EMPTY && map[7][3] == DOT_EMPTY) {
            return true;
        }

        if (iWil == 7 && jWil == 6 && !LOCATION_KING_WHITE && !LOCATION_TOUR_WHITE_RIGHT
                && map[7][5] == DOT_EMPTY && map[7][6] == DOT_EMPTY) {
            return true;
        }

        return false;
    }

    public static void rockerBleak(int iWil, int jWil) {

        if (iWil == 7 && jWil == 2 && !LOCATION_KING_BLEAK && !LOCATION_TOUR_BLEAK_LEFT &&
                map[7][1] == DOT_EMPTY && map[7][2] == DOT_EMPTY && map[7][3] == DOT_EMPTY &&
                !shahBleak()) {

            map[iWil][jWil] = 'k';
            map[7][4] = DOT_EMPTY;
            map[7][3] = 't';
            map[7][0] = DOT_EMPTY;

            printMap();
        }

        if (iWil == 7 && jWil == 6 && !LOCATION_KING_BLEAK && !LOCATION_TOUR_BLEAK_RIGHT
                && map[7][5] == DOT_EMPTY && map[7][6] == DOT_EMPTY &&
                !shahBleak()) {

            map[iWil][jWil] = 'k';
            map[7][4] = DOT_EMPTY;
            map[7][5] = 't';
            map[7][6] = DOT_EMPTY;

            printMap();
        }
    }

}
