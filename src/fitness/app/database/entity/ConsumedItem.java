package fitness.app.database.entity;

/**
 * This class represents a single food item that user consumed at a given time.
 * Eg: 2 Apples at 11:30PM
 */
public class ConsumedItem {
    private String name;
    private int quantity;
    private String date;

    public ConsumedItem(String name, int quantity, String date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
