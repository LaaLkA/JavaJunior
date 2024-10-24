package ru.laalka.Task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        foodstuffs = new ArrayList<>();
        this.market = market;
        this.clazz = clazz;
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing() {
        boolean proteins = foodstuffs.stream().anyMatch(Food::getProteins);
        boolean fats = foodstuffs.stream().anyMatch(Food::getFats);
        boolean carbohydrates = foodstuffs.stream().anyMatch(Food::getCarbohydrates);

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ");
            return;
        }

        proteins = needAdd(proteins, Food::getProteins);
        fats = needAdd(fats, Food::getFats);
        carbohydrates = needAdd(carbohydrates, Food::getCarbohydrates);

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ");
        else
            System.out.println("Корзину невозможно сбалансировать по БЖУ");
    }

    /*private void isBalanced(boolean proteins, boolean fats, boolean carbohydrates) {
        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ");
    }*/

    private boolean needAdd(boolean hasElement, Predicate<Food> predicate){
        if(!hasElement)
            market.getThings(Food.class).stream()
                    .filter(predicate)
                    .findFirst()
                    .ifPresent(food -> foodstuffs.add((T) food));
        return false;
    }


}
