package fitness.app;

import fitness.app.database.CalorieStore;

import java.util.Scanner;

/**
 * This class is the entry point of the whole application.
 * This class calls all other classes to store and calculate fitness data.
 */
class Application {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        CalorieStore store = new CalorieStore();
        // While true lets the application run continuously without terminating.
        while (true) {
            System.out.println("Please choose an option..");
            System.out.println("[1] Get calorie count for a given day.");
            System.out.println("[2] Enter data for new food item.");
            System.out.println("[3] Enter data for consumed item.");
            String selection = kb.nextLine();
            switch (selection) {
                case "1":
                    System.out.println("Enter the date (mm/dd/yyyy) you wish to calculate calorie intake for..");
                    String date = kb.nextLine();
                    store.calculateCalorieIntake(date);
                    break;
                case "2":
                    System.out.println("Enter new food item data (itemName<Space>itemCalories). eg: apple 100");
                    String newItemString = kb.nextLine();
                    String[] newItemData = newItemString.split(" ");
                    store.addNewFoodItem(newItemData[0], Integer.parseInt(newItemData[1]));
                    break;
                case "3":
                    System.out.println("Enter consumed food item data (itemName<Space>quantity). eg: apple 2");
                    String consumedItemString = kb.nextLine();
                    String[] consumedItemData = consumedItemString.split(" ");
                    store.addNewFoodItem(consumedItemData[0], Integer.parseInt(consumedItemData[1]));
                    break;
            }
        }
    }
}