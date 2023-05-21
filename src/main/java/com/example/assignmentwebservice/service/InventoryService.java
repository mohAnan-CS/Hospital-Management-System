package com.example.assignmentwebservice.service;

import com.example.assignmentwebservice.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InventoryService {

    private List<Inventory> inventoryList = new ArrayList<>();

    public List<Inventory> getAllInventory() {
        return inventoryList;
    }

    public Inventory addInventory(Inventory inventory) {
        if (!inventoryList.isEmpty()) {
            int lastIndex = inventoryList.size() - 1;
            int id = inventoryList.get(lastIndex).getInventoryID();
            id += 1;
            inventory.setInventoryID(id);
            inventoryList.add(inventory);
            return inventory;
        } else {
            inventory.setInventoryID(1);
            inventoryList.add(inventory);
        }
        return inventory;
    }

    public Inventory deleteInventory(int id) {
        Inventory deletedInventory = new Inventory(0, "", 0, "", 0);
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getInventoryID() == id) {
                deletedInventory = inventoryList.get(i);
                inventoryList.remove(i);
                return deletedInventory;
            }
        }
        return deletedInventory;
    }

    public Inventory editInventory(int id, Inventory updatedInventory) {
        for (Inventory inventory : inventoryList) {
            if (inventory.getInventoryID() == id) {
                if (updatedInventory.getItemName() != null) {
                    inventory.setItemName(updatedInventory.getItemName());
                }
                if (updatedInventory.getQuantity() > 0) {
                    inventory.setQuantity(updatedInventory.getQuantity());
                }
                if (updatedInventory.getUnit() != null) {
                    inventory.setUnit(updatedInventory.getUnit());
                }
                if (updatedInventory.getReorderLevel() > 0) {
                    inventory.setReorderLevel(updatedInventory.getReorderLevel());
                }
                return inventory;
            }
        }
        return new Inventory(0, "", 0, "", 0);
    }
}


