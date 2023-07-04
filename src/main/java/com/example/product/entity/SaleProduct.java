package com.example.product.entity;

import jakarta.persistence.*;

@Entity
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_product_id")
    private Long saleProductId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "sale_percent")
    private double salePercent;

    @Column(name = "sale_id")
    private Long saleId;

    public Long getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(Long saleProductId) {
        this.saleProductId = saleProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(double salePercent) {
        this.salePercent = salePercent;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
