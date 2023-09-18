package ru.gb.jcore;

public class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    /** Абстрактный метод расчёта среднемесячной заработной платы
     *
     */
    public abstract double calculateAverageSalary(){
        return x;
    };

    public String getName() {
        return name;
    }
}
