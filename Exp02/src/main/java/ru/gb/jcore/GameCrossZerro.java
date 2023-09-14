package ru.gb.jcore;

import java.util.Scanner;

//Game for you
public class GameCrossZerro {
    /** Размер игровово поля (Playing field size)
     *
     */
    public static final byte poleSize = 3;
    /** Задаем поле как (!)одномерный массив (We set the field as a (!) one-dimensional array)
     *
     */
    public static String[] pole = new String[poleSize * poleSize];

    /** Задаем текущего играка (set the current player)
     *
     */
    public static byte playerNumber = 0;

    /** The function sets the number of the next player
     *
     */
    private static void nextPlayer() {
        playerNumber = (byte) (1 == playerNumber ? 2 : 1);
    }

    /**
     * Проверяем корректность ввода.
     * Введенное число должно быть по размеру поля
     * и поле должно быть в этом месте еще не заполнено.
     */

    /*
     * We check the correctness of the input.
     * The entered number must be the size of
     * the field and the field must not yet be
     * filled in at this location
     */
    private static boolean isValidInput(int iIn) {
        if (iIn >= poleSize * poleSize) return false;
        if (iIn < 0) return false;
        switch (getX(iIn)) {
            case 'O':
            case 'X':
                return false;
        }

        return true;
    }


    /**
     * Определяем, наступил конец игры или нет
     * Условия:
     * 1) Победили крестики
     * 2) Победили нолики
     * 3) Кончились ходы
     */
    /*
     * Determining whether the game is over or not
     * Conditions:
     * 1) The crosses won
     * 2) The zeroes won
     * 3) Out of moves
     */
    private static boolean gameEnd() {
        int i, j;
        boolean rowWin = false, colWin = false;

        // Проверка победы на колонках и столбиках (Checking victory on columns and row)
        for (i = 0; i < poleSize; i++) {
            rowWin = true;
            colWin = true;
            for (j = 0; j < poleSize - 1; j++) {
                rowWin &= (getXY(i, j).charAt(0) == getXY(i, j + 1).charAt(0));
                colWin &= (getXY(j, i).charAt(0) == getXY(j + 1, i).charAt(0));
            }
            if (colWin || rowWin) {
                System.out.println("Победил игрок/The player wins" + playerNumber);
                return true;
            }
        }
        // Проверка победы по диагоналям (Checking victory by diagonals)
        rowWin = true;
        colWin = true;
        for (i=0; i<poleSize-1; i++) {
            rowWin &= (getXY(i,i).charAt(0) == getXY(i+1,i+1).charAt(0));
            colWin &= (getXY(i, poleSize-i-1).charAt(0) == getXY(i+1, poleSize-i-2).charAt(0));
        }
        if (colWin || rowWin) {
            System.out.println("Победил игрок/ The player wins" + playerNumber);
            return true;
        }
        // Проверка существования новых ходов (Checking the existence of new moves)
        for (i = 0; i < poleSize * poleSize; i++) {
            switch (getX(i)) {
                case 'O':
                case 'X':
                    break;
                default:
                    return false;
            }
        }
        if (poleSize*poleSize <= i) {
            System.out.println("Ничья. Кончились ходы./Draw. The moves are over.");
            return true;
        }

        // Продолжаем игру (Let's continue the game)
        return false;
    }


    public static void main (String[] args) throws Exception {
        int iTmp = 0;
        Scanner sc = new Scanner(System.in);

        // Инициализация поля (Field initialization)
        for (int i = 0; i < poleSize * poleSize; i++)
            pole[i] = Integer.toString(++iTmp);

        // Играем, пока не наступит конец игры (We play until the end of the game comes)
        while (gameEnd()) {
            nextPlayer();
            while (true) {
                System.out.println("\nХод игрока (player's move) " + playerNumber);
                drawPole(); // Drawing a field
                System.out.print("Наберите число, куда вы хотите вставить " + (1 == playerNumber? "крестик" : "нолик") + ": ");
                if (sc.hasNextInt()) { // проверяем, есть ли в потоке целое число
                    iTmp = sc.nextInt() - 1; // считывает целое число с потока ввода и сохраняем в переменную
                    if (isValidInput(iTmp))
                        break;
                }
                System.out.println("Вы ввели неправильное число. Повторите ввод");
                sc.next();
            }
            try {
                putX(iTmp); // Вставляем на поле крестик или нолик
            } catch (Exception e) {
                System.out.println("Что-то пошло не так ;(");
            }
        }
        drawPole();
    }

    /**
     * Вывести игровое поле (Display the playing field)
     */
    private static void drawPole() {
        for (int i = 0; i < poleSize; i++) {
            for (int j = 0; j < poleSize; j++) {
                System.out.printf("%4s", getXY(i, j));
            }
            System.out.print("\n");
        }
    }


    /**
     * Получает значение координат на поле (Gets the coordinates value on the field)
     */
    private static String getXY(int x, int y) {
        return pole[x * poleSize + y];
    }

    /**
     * Получает значение координаты на поле (Gets the coordinate value on the field)
     */
    private static char getX(int x) {
        return pole[x].charAt(0);
    }

    /**
     * Вставляет на поле крестик или нолик (Inserts a cross or zero into the field)
     */
    private static void putX(int x) {
        pole[x] = 1 == playerNumber ? "X" : "O";
    }


}