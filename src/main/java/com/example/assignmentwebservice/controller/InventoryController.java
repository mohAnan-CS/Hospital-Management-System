package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Inventory;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Get Inventories", notes = "Retrieve all inventory record")
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventory();
    }

    @PostMapping()
    @ApiOperation(value = "Post Inventory", notes = "Add inventory record")
    public Inventory addInventory(@RequestBody Inventory inventory) { return  inventoryService.addInventory(inventory); }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Inventory", notes = "Delete inventory record by inventory id")
    public Inventory deleteInventory(@PathVariable("id") Integer id){ return inventoryService.deleteInventory(id); }

    @PutMapping("{id}")
    @ApiOperation(value = "Put Inventory", notes = "Edit inventory record by inventory id")
    public Inventory editInventory(@PathVariable("id") Integer id,  @RequestBody Inventory inventory){
        return inventoryService.editInventory(id, inventory);
    }
}

