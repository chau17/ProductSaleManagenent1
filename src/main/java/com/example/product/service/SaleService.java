package com.example.product.service;

import com.example.product.entity.Sale;
import com.example.product.entity.SaleProduct;
import com.example.product.repository.SaleProductRepository;
import com.example.product.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final SaleProductRepository saleProductRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, SaleProductRepository saleProductRepository) {
        this.saleRepository = saleRepository;
        this.saleProductRepository = saleProductRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public List<SaleProduct> getSaleProductsBySaleId(Long saleId) {
        return saleProductRepository.findBySaleId(saleId);
    }

    public List<Sale> getSalesInCurrentMonth() {
        return saleRepository.findSalesInCurrentMonth();
    }
    public List<Sale> getSalesByDateRange(Date startDate, Date endDate) {
        return saleRepository.findSalesByDateRange(startDate, endDate);
    }

    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long saleId, Sale updatedSale) {
        Sale sale = saleRepository.findById(saleId).orElse(null);
        if (sale != null) {
            sale.setSaleName(updatedSale.getSaleName());
            sale.setStartDate(updatedSale.getStartDate());
            sale.setEndDate(updatedSale.getEndDate());
            return saleRepository.save(sale);
        }
        return null;
    }

    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }

    public List<Sale> searchSalesByName(String saleName) {
        return saleRepository.findBySaleName(saleName);
    }

}