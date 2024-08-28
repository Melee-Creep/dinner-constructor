package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> foodList = new HashMap<>();
    Random random = new Random();

    void addNewDish(String dishType, String dishName) {
        if (checkType(dishType)) {
            foodList.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>(10);
            dishes.add(dishName);
            foodList.put(dishType, dishes);
        }
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> types) {
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combos = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (String type : types) {
                int randomDish = random.nextInt(foodList.get(type).size());
                String dish = foodList.get(type).get(randomDish);
                combos.add(dish);
            }
            System.out.println(combos);
        }
    }

    boolean checkType(String dishType) {
       return foodList.containsKey(dishType);
    }
}

