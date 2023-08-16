package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SalesReportProjection;
import com.devsuperior.dsmeta.projections.SalesSummaryProjection;


public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query(nativeQuery = true, value = "SELECT tb_seller.name, SUM(tb_sales.amount) as total "
	        + "FROM tb_sales "
	        + "INNER JOIN tb_seller "
	        + "ON tb_sales.seller_id = tb_seller.id "
	        + "WHERE tb_sales.date BETWEEN :minDate AND :maxDate "
	        + "GROUP BY tb_seller.name")
	    List<SalesSummaryProjection> summary(LocalDate minDate, LocalDate maxDate);

	    @Query(nativeQuery = true, value = "SELECT tb_sales.id, tb_sales.date, tb_sales.amount, tb_seller.name "
	            + "FROM tb_sales "
	            + "INNER JOIN tb_seller "
	            + "ON tb_seller.id = tb_sales.seller_id "
	            + "WHERE tb_sales.date BETWEEN :minDate AND :maxDate "
	            + "AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :namePart, '%'))"
	    )
	    List<SalesReportProjection> report(LocalDate minDate, LocalDate maxDate, String namePart);
	
}
