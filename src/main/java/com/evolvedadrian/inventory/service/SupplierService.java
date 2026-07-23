package com.evolvedadrian.inventory.service;

import com.evolvedadrian.inventory.entity.Supplier;
import com.evolvedadrian.inventory.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return this.supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id) {
        return this.supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found."));
    }

    public Supplier createSupplier(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        if (!this.supplierRepository.existsById(supplier.getId())) {
            throw new RuntimeException("Supplier does not exist.");
        }
        return this.supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer id) {
        Supplier supplier = getSupplierById(id);
        this.supplierRepository.delete(supplier);
    }

    public List<Supplier> findSupplierByName(String name) {
        return this.supplierRepository.findByName(name);
    }
}
