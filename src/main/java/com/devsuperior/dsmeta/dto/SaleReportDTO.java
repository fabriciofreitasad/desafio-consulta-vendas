package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.projections.SalesReportProjection;

public class SaleReportDTO {
	
	private Long id;
	private LocalDate date;
	private Integer amount;
	private String sellerName;
	
	public SaleReportDTO() {
	}

	public SaleReportDTO(Long id, LocalDate date, Integer amount, String sellerName) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.sellerName = sellerName;
	}
	
	public SaleReportDTO(SalesReportProjection projection) {
		this.id = projection.id();
		this.date = projection.date();
		this.amount = projection.amount();
		this.sellerName = projection.sellerName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	

}
