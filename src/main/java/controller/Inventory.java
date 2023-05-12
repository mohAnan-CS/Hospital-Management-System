package controller;

public class Inventory {
    private int inventoryID;
    private String itemName;
    private int quantity;
    private String unit;
    private int reorderLevel;

    // Constructors
    public Inventory() {
    }

    public Inventory(int inventoryID, String itemName, int quantity, String unit, int reorderLevel) {
        this.inventoryID = inventoryID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unit = unit;
        this.reorderLevel = reorderLevel;
    }

    // Getters and Setters
    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
}
