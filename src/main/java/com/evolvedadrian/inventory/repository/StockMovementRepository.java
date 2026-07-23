package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.Product;
import com.evolvedadrian.inventory.entity.StockMovement;
import com.evolvedadrian.inventory.entity.Warehouse;
import com.evolvedadrian.inventory.enums.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {
    List<StockMovement> findByType(MovementType type);

    List<StockMovement> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<StockMovement> findByProductId(Integer productId);

    List<StockMovement> findByWarehouseId(Integer warehouseId);
}
