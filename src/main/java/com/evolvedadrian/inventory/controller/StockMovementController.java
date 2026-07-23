package com.evolvedadrian.inventory.controller;

import com.evolvedadrian.inventory.entity.StockMovement;
import com.evolvedadrian.inventory.enums.MovementType;
import com.evolvedadrian.inventory.service.StockMovementService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementController {
    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService){
        this.stockMovementService = stockMovementService;
    }

    @GetMapping
    public List<StockMovement> getAllStockMovements(){
        return this.stockMovementService.getAllStockMovements();
    }

    @GetMapping("/{id}")
    public StockMovement getStockMovementById(@PathVariable Integer id){
        return this.stockMovementService.getStockMovementById(id);
    }

    @GetMapping("/type/{type}")
    public List<StockMovement> findStockMovementByType(@PathVariable MovementType type){
        return this.stockMovementService.findStockMovementsByType(type);
    }

    @GetMapping(params = {"startDate", "endDate"})
    public List<StockMovement> findStockMovementByDateBetween(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate){
        return this.stockMovementService.findStockMovementsByDateBetween(startDate, endDate);
    }

    @GetMapping("/product/{id}")
    public List<StockMovement> findStockMovementsByProduct(@PathVariable Integer id){
        return this.stockMovementService.findStockMovementsByProduct(id);
    }

    @GetMapping("/warehouse/{id}")
    public List<StockMovement> findStockMovementsByWarehouse(@PathVariable Integer id){
        return this.stockMovementService.findStockMovementsByWarehouse(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStockMovementById(@PathVariable Integer id){
        this.stockMovementService.deleteStockMovement(id);
    }

    @PostMapping
    public StockMovement createStockMovement(@RequestBody StockMovement stockMovement){
        return this.stockMovementService.createStockMovement(stockMovement);
    }

    @PutMapping("/{id}")
    public StockMovement updateStockMovement(@PathVariable Integer id, @RequestBody StockMovement stockMovement){
        stockMovement.setId(id);
        return this.stockMovementService.updateStockMovement(stockMovement);
    }
}
