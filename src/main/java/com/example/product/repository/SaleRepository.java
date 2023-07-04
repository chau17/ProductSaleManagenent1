package com.example.product.repository;

import com.example.product.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s WHERE MONTH(s.startDate) = MONTH(CURRENT_DATE) AND YEAR(s.startDate) = YEAR(CURRENT_DATE)")
    List<Sale> findSalesInCurrentMonth();

    @Query("SELECT s FROM Sale s WHERE s.startDate >= :startDate AND s.endDate <= :endDate")
    List<Sale> findSalesByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Sale> findBySaleName(String saleName);
}