package ru.laalka.Task2;

/**
 * Еда
 */
public interface Food extends Thing {
    /**
     * Получить наличие белков в еде
     * @return наличие белков
     */
    boolean getProteins();
    /**
     * Получить наличие жиров в еде
     * @return наличие жиров
     */
    boolean getFats();
    /**
     * Получить наличие углеводов в еде
     * @return наличие углеводов
     */
    boolean getCarbohydrates();

    /*default String toString() {
        return
    }*/
}
