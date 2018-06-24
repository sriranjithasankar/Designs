package fitness.app.database;

public class CalorieStore {

    /**
     * This function calculates the amount of calories consumed on the given data.
     * Example: 05/12/2018 returns 2500
     * @param date
     * @return
     */
    public int calculateCalorieIntake(String date) {
        return 0;
    }

    /**
     * This function takes in a new food item and the amount of calories it contains
     * and stores it in the database so that its calorie count can later be retrieved.
     * @param name
     * @param calorieCount
     */
    public void addNewFoodItem(String name, int calorieCount) {

    }


    /**
     * This function takes the food itm name and the quantity that the user consumed
     * and stores it in the database so that it can later be used to calculate the calories consumed by the user.
     * @param name
     * @param quantity
     */
    public void addConsumedFoodItem(String name, int quantity) {

    }
}