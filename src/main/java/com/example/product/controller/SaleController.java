package com.example.product.controller;

import com.example.product.entity.Sale;
import com.example.product.entity.SaleProduct;
import com.example.product.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/allSales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{saleId}/products")
    public List<SaleProduct> getSaleProductsBySaleId(@PathVariable Long saleId) {
        return saleService.getSaleProductsBySaleId(saleId);
    }

    @GetMapping("/current-month")
    public List<Sale> getSalesForCurrentMonth() {
        return saleService.getSalesInCurrentMonth();
    }

    @GetMapping("/date-range")
    public List<Sale> getSalesByDateRange(
            @RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return saleService.getSalesByDateRange(startDate, endDate);
    }

    @PostMapping
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.addSale(sale);
    }


    @PutMapping("/{saleId}")
    public Sale updateSale(@PathVariable Long saleId, @RequestBody Sale updatedSale) {
        return saleService.updateSale(saleId, updatedSale);
    }


    @DeleteMapping("/{saleId}")
    public void deleteSale(@PathVariable Long saleId) {
        saleService.deleteSale(saleId);
    }


    @GetMapping("/search")
    public List<Sale> searchSalesByName(@RequestParam("saleName") String saleName) {
        return saleService.searchSalesByName(saleName);
    }
}