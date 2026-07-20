package com.evolvedadrian.inventory.service;

import com.evolvedadrian.inventory.entity.Product;
import com.evolvedadrian.inventory.entity.StockMovement;
import com.evolvedadrian.inventory.entity.Warehouse;
import com.evolvedadrian.inventory.enums.MovementType;
import com.evolvedadrian.inventory.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockMovementService {
    private final StockMovementRepository stockMovementRepository;

    public StockMovementService(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    public List<StockMovement> getAllStockMovements() {
        return this.stockMovementRepository.findAll();
    }

    public Optional<StockMovement> getStockMovementById(Integer id) {
        return this.stockMovementRepository.findById(id);
    }

    public StockMovement createStockMovement(StockMovement stockMovement) {
        return this.stockMovementRepository.save(stockMovement);
    }

    public StockMovement updateStockMovement(StockMovement stockMovement) {
        if (getStockMovementById(stockMovement.getId()).isEmpty()) {
            throw new RuntimeException("Stock movement does not exist.");
        }
        return this.stockMovementRepository.save(stockMovement);
    }

    public void deleteStockMovement(StockMovement stockMovement) {
        this.stockMovementRepository.delete(stockMovement);
    }

    public List<StockMovement> findStockMovementsByType(MovementType type) {
        return this.stockMovementRepository.findByType(type);
    }

    public List<StockMovement> findStockMovementsByDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return this.stockMovementRepository.findByDateBetween(startDate, endDate);
    }

    public List<StockMovement> findStockMovementsByProduct(Product product) {
        return this.stockMovementRepository.findByProduct(product);
    }

    public List<StockMovement> findStockMovementsByWarehouse(Warehouse warehouse) {
        return this.stockMovementRepository.findByWarehouse(warehouse);
    }
}