package com.evolvedadrian.inventory.controller;

import com.evolvedadrian.inventory.entity.Supplier;
import com.evolvedadrian.inventory.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return this.supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Integer id) {
        return this.supplierService.getSupplierById(id);
    }

    @GetMapping("/name/{name}")
    public List<Supplier> findSupplierByName(@PathVariable String name) {
        return this.supplierService.findSupplierByName(name);
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return this.supplierService.createSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Integer id) {
        this.supplierService.deleteSupplier(id);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier) {
        supplier.setId(id);
        return this.supplierService.updateSupplier(supplier);
    }
}
