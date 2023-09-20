package ru.gb.jcore;


public class Main {
    public static void main(String[] args) {

        }
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке", i, j);
                }
            }
        }

        return sum;
    }

    class MyArraySizeException extends RuntimeException {
        private String message;

        public MyArraySizeException(String message) {
            this.message = message;
        }

        @Override
        public void printStackTrace() {
            super.printStackTrace();
            System.out.println(message);
        }
    }

    class MyArrayDataException extends NumberFormatException {
        private int row;
        private int column;
        private String message;

        public MyArrayDataException(String message, int row, int column) {
            this.message = message;
            this.row = row;
            this.column = column;
        }
    }
}