package fitness.app;

import fitness.app.database.CalorieStore;
import fitness.test.TestApplication;
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
        String mode = "0";
        while (true) {
            if (mode.equals("0")) {
                System.out.println("Please choose an option..");
                System.out.println("[1] Get calorie count for a given day.");
                System.out.println("[2] Enter data for new food item.");
                System.out.println("[3] Enter data for consumed item.");
                System.out.println("[4] Run test cases.");
                mode = kb.nextLine();
                if (mode.equals("exit")) {
                    break;
                }
                if (mode.equals("4")) {
                    System.out.println("Running test cases..");
                    TestApplication testApplication = new TestApplication();
                    testApplication.executeTests();
                    break;
                }
            }
            switch (mode) {
                case "1":
                    System.out.println("Enter the date (mm/dd/yyyy) you wish to calculate calorie intake for..");
                    while (true) {
                        String date = kb.nextLine();
                        if (date.equals("exit")) {
                            mode = "0";
                            break;
                        }
                        int calories = store.calculateCalorieIntake(date);
                        System.out.println(calories);
                    }
                    break;
                case "2":
                    System.out.println("Enter new food item data (itemName<Space>itemCalories). eg: apple 100");
                    while (true) {
                        String newItemString = kb.nextLine();
                        if (newItemString.equals("exit")) {
                            mode = "0";
                            break;
                        }
                        String[] newItemData = newItemString.split(" ");
                        store.addNewFoodItem(newItemData[0], Integer.parseInt(newItemData[1]));
                    }
                    break;
                case "3":
                    System.out.println("Enter consumed food item data (itemName<Space>quantity<space>date). eg: apple 2 10/25/2018");
                    while (true) {
                        String consumedItemString = kb.nextLine();
                        if (consumedItemString.equals("exit")) {
                            mode = "0";
                            break;
                        }
                        String[] consumedItemData = consumedItemString.split(" ");
                        store.addConsumedFoodItem(consumedItemData[0], Integer.parseInt(consumedItemData[1]), consumedItemData[2]);
                    }
                    break;
            }
        }
    }
}