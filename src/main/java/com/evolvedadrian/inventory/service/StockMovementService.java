package com.evolvedadrian.inventory.service;

import com.evolvedadrian.inventory.entity.StockMovement;
import com.evolvedadrian.inventory.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

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
        return this.stockMovementRepository.save(stockMovement);
    }

    public void deleteStockMovement(StockMovement stockMovement) {
        this.stockMovementRepository.delete(stockMovement);
    }
}