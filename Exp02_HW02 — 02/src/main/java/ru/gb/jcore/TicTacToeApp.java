package ru.gb.jcore;
import java.util.Scanner;


// Игра "Крестики-нолики" /TicTacToe
public class TicTacToeApp {
    static Scanner scanner;
    static char [][]map;
    static final int MAP_SIZE=3;
    static final char EMPTY_FILED='*';
    static final char X_FILED='X';
    static final char O_FILED='0';
    public static void main(String[] args) {
        initGame();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_FILED)){
                System.out.println("Игра завершина. Победил игрок");
                break;
            }
            if (checkDraft()){
                System.out.println("Игра окончена. Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(X_FILED)){
                System.out.println("Игра завершина. Победил игрок");
                break;
            }
            if (checkDraft()){
                System.out.println("Игра окончена. Ничья");
                break;
            }
        }
        }

        //Проверка на победу
        public static boolean checkWin(char playerField) {

        }
    /**
    public static boolean checkWin(char playerField){
        // Проверка по трем горизонталям
        if (map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
        if (map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) return true;
        if (map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) return true;

        // Проверка по трем вертикалям
        if (map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
        if (map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
        if (map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;

        // Проверка по диагоналям
        if (map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
        if (map[0][2] == playerField && map[1][1] == playerField && map[2][0] == playerField) return true;

        return false;
    }
     */

        //Проверка на ничью
    public  static boolean checkDraft(){
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map [i][j] == EMPTY_FILED){
                    return false;
                }

            }

        }
        return  true;
    }

    // Метод проверки координат
    public static boolean isCellValid(int x, int y) {
        if (x<0 || y<0 || x>=MAP_SIZE || y>=MAP_SIZE){
            return false;
        }
        if (map[y][x] !=EMPTY_FILED){
            return false;
        }
        return true;
    }

    //Метод, реализующий ход человека
    public static void humanTurn(){

       int x,y;
       do {
           System.out.println("Ход игрока. Введите координаты (x,y) вашего хода");
           x= scanner.nextInt()-1;
           y= scanner.nextInt()-1;
       } while (!isCellValid(x,y));

       map[y][x]=X_FILED;
      // System.out.println("Вы ввели" +x+ " "+y);
    }

    //Метод, реализующий ход ИИ
    public static void aiTurn(){

        int x,y;
        do {
            System.out.println("Ход компьютера");
            x= (int) (Math.random()*MAP_SIZE);
            y= (int) (Math.random()*MAP_SIZE);
        } while (!isCellValid(x,y));
        map[y][x]=O_FILED;
        // System.out.println("Вы ввели" +x+ " "+y);
    }
    /**
     * Print map
     * 0 1 2 3
     * 1 * * *
     * 2 * * *
     * 3 * * *
     */
    public static void printMap(){
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print ((i+1)+" ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print((map[i][j])+ " ");
            }
            System.out.println();
        }
        System.out.println();
        }

        public static void initGame(){
        map=new char [MAP_SIZE][MAP_SIZE];
        for (int i=0; i<MAP_SIZE; i++){
            for (int j = 0; j < MAP_SIZE; j++) {
                map [i][j]=EMPTY_FILED;

            }
        }
        scanner =new Scanner(System.in);
        }


    }
