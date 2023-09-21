package ru.gb.jcore;

public class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    /**
     * Абстрактный метод расчёта среднемесячной заработной платы
     */
    public double calculateAverageSalary() {
        return 0;
    }

    public String getName() {
        return name;
    }
}
