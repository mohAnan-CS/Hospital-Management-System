package com.example.assignmentwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Inventory {
    private int inventoryID;
    private String itemName;
    private int quantity;
    private String unit;
    private int reorderLevel;


    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", reorderLevel=" + reorderLevel +
                '}';
    }

}
