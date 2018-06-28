package fitness.app.database;

import java.util.*;
import fitness.app.database.entity.ConsumedItem;

public class CalorieStore {
    private HashMap<String, Integer> itemToCalorieMap = new HashMap<>();
    private HashMap<String, ArrayList<ConsumedItem>> dateToConsumedItemMap = new HashMap<>();

    /**
     * This function calculates the amount of calories consumed on the given data.
     * Example: 05/12/2018 returns 2500
     * @param date
     * @return
     */
    public int calculateCalorieIntake(String date) {
        if (!dateToConsumedItemMap.containsKey(date)) {
            return 0;
        }
        ArrayList<ConsumedItem> consumedItems = dateToConsumedItemMap.get(date);
        int totalCalories = 0;
        for (ConsumedItem item : consumedItems) {
            int caloriesForItem = itemToCalorieMap.get(item.getName());
            int consumedCalories = item.getQuantity() * caloriesForItem;
            totalCalories += consumedCalories;
        }
        return totalCalories;
    }

    /**
     * This function takes in a new food item and the amount of calories it contains
     * and stores it in the database so that its calorie count can later be retrieved.
     * @param name
     * @param calorieCount
     */
    public void addNewFoodItem(String name, int calorieCount) {
        itemToCalorieMap.put(name, calorieCount);
    }


    /**
     * This function takes the food itm name and the quantity that the user consumed on a given date
     * and stores it in the database so that it can later be used to calculate the calories consumed by the user.
     * @param name
     * @param quantity
     * @param date
     */
    public void addConsumedFoodItem(String name, int quantity, String date) {
        ConsumedItem newlyConsumedItem = new ConsumedItem(name, quantity, date);
        ArrayList<ConsumedItem> consumedItems;
        if (dateToConsumedItemMap.containsKey(date)) { // ie, user ate something previously on the same date
            consumedItems = dateToConsumedItemMap.get(date);
            consumedItems.add(newlyConsumedItem);
        } else {
            consumedItems = new ArrayList<>();
            consumedItems.add(newlyConsumedItem);
        }
        dateToConsumedItemMap.put(date, consumedItems); // Update the map with newly consumed items.
    }
}