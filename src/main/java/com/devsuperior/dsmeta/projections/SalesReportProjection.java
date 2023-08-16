package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface SalesReportProjection {
	
	Long id();
	LocalDate date();
	Integer amount();
	String sellerName();

}
