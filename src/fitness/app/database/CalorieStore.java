package fitness.app.database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalorieStore {

    /**
     * This function calculates the amount of calories consumed on the given data.
     * Example: 05/12/2018 returns 2500
     * @param date
     * @return
     */
    HashMap<String, ArrayList> itemNameQuantityDate = new HashMap();
    ArrayList<String> itemNameQuantity = new ArrayList<>();
    HashMap<String, Integer> itemCalories = new HashMap();
    HashMap<String, Integer> itemQuantity = new HashMap<>();

    public int calculateCalorieIntake(String date) {
        ArrayList itemNameQuantity = itemNameQuantityDate.get(date);
        for(int i = 0; i< itemNameQuantity.size(); i++){
            String itemNameQuantityPair;
            itemNameQuantityPair = itemNameQuantity.get(i).toString();
            String[] itemNameQuantityArray = itemNameQuantityPair.split(",");
            itemQuantity.put(itemNameQuantityArray[0], Integer.parseInt(itemNameQuantityArray[1]));
        }
        int calories=0;
        Integer quantity;
        String item="";
        int totalCalories=0;

        for(int i = 0; i< itemQuantity.size(); i++){

            quantity = itemQuantity.get(i);
            for(Map.Entry entry: itemQuantity.entrySet()){
                if(quantity.equals(entry.getValue())){
                    item = entry.getKey().toString();
                }
            }
            if(itemCalories.containsKey(item)){
                calories = itemCalories.get(item);
            }
            totalCalories += calories*quantity;
        }
        System.out.println(totalCalories);

//        int[] quantity = new int[itemQuantity.size()];
//        int[] calories = new int[itemCalories.size()];
//        for(int i = 0; i<itemQuantity.size(); i++){
//            quantity[i] = itemQuantity.get(i);
//        }
//
//        for(int i = 0; i< itemCalories.size(); i++){
//            calories[i] = itemCalories.get(i);
//        }
//
//        int totalCalories=0;
//        int caloriesForEachItem=0;
//        for(int i = 0; i<quantity.length; i++){
//            caloriesForEachItem = quantity[i] * calories[i];
//            totalCalories += caloriesForEachItem;
//        }
//
//        System.out.println(totalCalories);

        return 0;
    }

    /**
     * This function takes in a new food item and the amount of calories it contains
     * and stores it in the database so that its calorie count can later be retrieved.
     * @param name
     * @param calorieCount
     */

    public void addNewFoodItem(String name, int calorieCount) {

        itemCalories.put(name, calorieCount);
    }


    /**
     * This function takes the food itm name and the quantity that the user consumed on a given date
     * and stores it in the database so that it can later be used to calculate the calories consumed by the user.
     * @param name
     * @param quantity
     * @param date
     */
    public void addConsumedFoodItem(String name, int quantity, String date) {
        String  nameQuantity = name + "," + quantity;
        itemNameQuantity.add(nameQuantity);
        itemNameQuantityDate.put(date, itemNameQuantity);
    }
}