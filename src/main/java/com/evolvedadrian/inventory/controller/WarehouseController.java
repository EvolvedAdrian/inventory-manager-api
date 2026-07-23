package com.evolvedadrian.inventory.controller;

import com.evolvedadrian.inventory.entity.Warehouse;
import com.evolvedadrian.inventory.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class WarehouseController {
    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return this.warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Integer id) {
        return this.warehouseService.getWarehouseById(id);
    }

    @GetMapping("/name/{name}")
    public List<Warehouse> findWarehouseByName(@PathVariable String name) {
        return this.warehouseService.findWarehouseByName(name);
    }

    @GetMapping("/location/{location}")
    public List<Warehouse> findWarehouseByLocation(@PathVariable String location){
        return this.warehouseService.findWarehouseByLocation(location);
    }

    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return this.warehouseService.createWarehouse(warehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Integer id) {
        this.warehouseService.deleteWarehouse(id);
    }

    @PutMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        warehouse.setId(id);
        return this.warehouseService.updateWarehouse(warehouse);
    }
}
