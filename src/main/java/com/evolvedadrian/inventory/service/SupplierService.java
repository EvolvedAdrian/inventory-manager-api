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

    public Optional<Supplier> getSupplierById(Integer id) {
        return this.supplierRepository.findById(id);
    }

    public Supplier createSupplier(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    public void deleteSupplier(Supplier supplier) {
        this.supplierRepository.delete(supplier);
    }
}
