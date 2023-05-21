package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignmentwebservice.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping()
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventory();
    }

    @PostMapping()
    public Inventory addInventory(@RequestBody Inventory inventory) { return  inventoryService.addInventory(inventory); }

    @DeleteMapping("{id}")
    public Inventory deleteInventory(@PathVariable("id") Integer id){ return inventoryService.deleteInventory(id); }

    @PutMapping("{id}")
    public Inventory editInventory(@PathVariable("id") Integer id,  @RequestBody Inventory inventory){
        return inventoryService.editInventory(id, inventory);
    }
}

