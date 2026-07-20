package com.evolvedadrian.inventory.service;

import com.evolvedadrian.inventory.entity.Warehouse;
import com.evolvedadrian.inventory.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAllWarehouses() {
        return this.warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(Integer id) {
        return this.warehouseRepository.findById(id);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return this.warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Warehouse warehouse) {
        if (getWarehouseById(warehouse.getId()).isEmpty()) {
            throw new RuntimeException("Warehouse does not exist.");
        }
        return this.warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Warehouse warehouse) {
        this.warehouseRepository.delete(warehouse);
    }

    public List<Warehouse> findWarehouseByName(String name) {
        return this.warehouseRepository.findByName(name);
    }

    public List<Warehouse> findWarehouseByLocation(String location) {
        return this.warehouseRepository.findByLocation(location);
    }
}