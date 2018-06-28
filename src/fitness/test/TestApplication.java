package fitness.test;

import fitness.app.database.CalorieStore;

public class TestApplication {

    private String apple = "apple";
    private String banana = "banana";
    private String chips = "chips";
    private String donuts = "donuts";

    private String date_10_25_2018 = "10/25/2018";
    private String date_10_20_2018 = "10/20/2018";

    public int singleTestNumber = 0;

    public void executeTests() {
        // TEST CASE 1
        try {
            testCase1();
        } catch (Exception e) {
            System.out.println("TestCase 1 - FAIL (Exception)");
        }

        // TEST CASE 2
        try {
            testCase2();
        } catch (Exception e) {
            System.out.println("TestCase 2 - FAIL (Exception)");
        }

        // TEST CASE 3
        try {
            testCase3();
        } catch (Exception e) {
            System.out.println("TestCase 3 - FAIL (Exception)");
        }
    }

    /**
     * This test case verifies that the calorie store returns 0, when there is no calorie intake for a given date.
     */
    public void testCase1() {
        if (singleTestNumber != 0 && singleTestNumber != 1) {
            return;
        }

        CalorieStore store = new CalorieStore();
        int calories = store.calculateCalorieIntake(date_10_25_2018);
        if (calories == 0) {
            System.out.println("TestCase 1 - PASS");
        } else {
            System.out.println("TestCase 1 - FAIL");
        }
    }

    /**
     * This test case verifies that the calorie store returns right result when it contains data for just a single date.
     */
    public void testCase2() {
        if (singleTestNumber != 0 && singleTestNumber != 2) {
            return;
        }

        CalorieStore store = new CalorieStore();

        store.addNewFoodItem(apple, 100);
        store.addNewFoodItem(banana, 300);
        store.addNewFoodItem(chips, 450);
        store.addNewFoodItem(donuts, 800);

        store.addConsumedFoodItem(apple, 2, date_10_25_2018);
        store.addConsumedFoodItem(banana, 1, date_10_25_2018);
        store.addConsumedFoodItem(chips, 1, date_10_25_2018);

        int calories = store.calculateCalorieIntake(date_10_25_2018);
        if (calories == 950) {
            System.out.println("TestCase 2 - PASS");
        } else {
            System.out.println("TestCase 2 - FAIL");
        }
    }

    /**
     * This test case verifies that the calorie store returns right result when it contains data for multiple dates.
     */
    public void testCase3() {
        if (singleTestNumber != 0 && singleTestNumber != 3) {
            return;
        }

        CalorieStore store = new CalorieStore();

        store.addNewFoodItem(apple, 100);
        store.addNewFoodItem(banana, 300);
        store.addNewFoodItem(chips, 450);
        store.addNewFoodItem(donuts, 800);

        store.addConsumedFoodItem(apple, 2, date_10_25_2018);
        store.addConsumedFoodItem(banana, 1, date_10_25_2018);
        store.addConsumedFoodItem(chips, 1, date_10_25_2018);

        store.addConsumedFoodItem(chips, 2, date_10_20_2018);
        store.addConsumedFoodItem(banana, 1, date_10_20_2018);
        store.addConsumedFoodItem(donuts, 1, date_10_20_2018);

        int calories = store.calculateCalorieIntake(date_10_25_2018);
        if (calories != 950) {
            System.out.println("TestCase 3A - FAIL");
            return;
        }

        calories = store.calculateCalorieIntake(date_10_20_2018);
        if (calories != 2000) {
            System.out.println("TestCase 3B - FAIL");
            return;
        }
        System.out.println("TestCase 3 - PASS");
    }
}
