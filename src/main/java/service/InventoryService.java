package service;

import controller.Inventory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InventoryService {

    private List<Inventory> inventoryItems = new ArrayList<>();

    // Method to get an inventory item by ID
    public Inventory getInventoryById(int inventoryID) {
        for (Inventory inventory : inventoryItems) {
            if (inventory.getInventoryID() == inventoryID) {
                return inventory;
            }
        }
        return null;
    }

    // Method to create a new inventory item
    public Inventory createInventory(Inventory inventory) {
        // Generate a unique ID for the new inventory item (you can use a UUID or any other suitable method)
        int newInventoryID = generateNewInventoryID();

        // Set the generated ID for the inventory item
        inventory.setInventoryID(newInventoryID);

        // Add the inventory item to the list of inventory items
        inventoryItems.add(inventory);

        return inventory;
    }

    // Method to update an inventory item
    public Inventory updateInventory(Inventory updatedInventory) {
        int inventoryID = updatedInventory.getInventoryID();

        // Find the inventory item with the specified ID
        Inventory inventoryToUpdate = getInventoryById(inventoryID);

        if (inventoryToUpdate != null) {
            // Update the inventory item's information
            inventoryToUpdate.setItemName(updatedInventory.getItemName());
            inventoryToUpdate.setQuantity(updatedInventory.getQuantity());
            inventoryToUpdate.setUnit(updatedInventory.getUnit());
            inventoryToUpdate.setReorderLevel(updatedInventory.getReorderLevel());

            return inventoryToUpdate;
        }

        return null; // Inventory item not found
    }

    // Method to delete an inventory item
    public void deleteInventory(int inventoryID) {
        Inventory inventoryToRemove = getInventoryById(inventoryID);

        if (inventoryToRemove != null) {
            inventoryItems.remove(inventoryToRemove);
        }
    }

    // Method to generate a new unique inventory ID (example implementation)
    private int generateNewInventoryID() {
        // Generate a random number or use any other suitable method to generate unique IDs
        return new Random().nextInt(1000);
    }
}


