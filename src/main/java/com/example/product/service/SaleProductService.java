package com.example.product.service;

import com.example.product.entity.SaleProduct;
import com.example.product.repository.SaleProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleProductService {

    private final SaleProductRepository saleProductRepository;

    public SaleProductService(SaleProductRepository saleProductRepository) {
        this.saleProductRepository = saleProductRepository;
    }



    public List<SaleProduct> getSaleProductsBySaleId(Long saleId) {
        return saleProductRepository.findBySaleId(saleId);
    }
}