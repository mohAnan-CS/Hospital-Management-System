package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.assignmentwebservice.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{inventoryID}")
    public ResponseEntity<Inventory> getInventory(@PathVariable int inventoryID) {
        Inventory inventory = inventoryService.getInventoryById(inventoryID);

        if (inventory != null) {
            return ResponseEntity.ok(inventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory createdInventory = inventoryService.createInventory(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInventory);
    }

    @PutMapping("/{inventoryID}")
    public ResponseEntity<Inventory> updateInventory(
            @PathVariable int inventoryID,
            @RequestBody Inventory updatedInventory
    ) {
        Inventory inventory = inventoryService.getInventoryById(inventoryID);

        if (inventory != null) {
            // Update the inventory item's information with the updatedInventory object
            inventory.setItemName(updatedInventory.getItemName());
            inventory.setQuantity(updatedInventory.getQuantity());
            inventory.setUnit(updatedInventory.getUnit());
            inventory.setReorderLevel(updatedInventory.getReorderLevel());

            updatedInventory = inventoryService.updateInventory(inventory);
            return ResponseEntity.ok(updatedInventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{inventoryID}")
    public ResponseEntity<Void> deleteInventory(@PathVariable int inventoryID) {
        inventoryService.deleteInventory(inventoryID);
        return ResponseEntity.noContent().build();
    }
}

