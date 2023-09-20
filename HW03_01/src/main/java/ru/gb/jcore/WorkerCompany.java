package ru.gb.jcore;

import java.util.Arrays;
import java.util.Comparator;
public class WorkerCompany {
    private Worker[] workers;

    public WorkerCompany(Worker[] workers) {
        this.workers = workers;
    }

    /** Метод для сортировки массива работников по имени
     *
     */
    public void sortByName() {
        Arrays.sort(workers, Comparator.comparing(Worker::getName));
    }

    /** Метод для сортировки массива работников по заработной плате
     *
     */
    public void sortByAverageSalary() {
        Arrays.sort(workers, Comparator.comparing(Worker::calculateAverageSalary));
    }

    /** Метод для вывода информации о работниках
     *
     */
    public void printWorkersInfo() {
        for (Worker worker : workers) {
            System.out.println("Name: " + worker.getName() + ", Average Salary: " + worker.calculateAverageSalary());
        }
    }
}
