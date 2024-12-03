package org.cap.bim.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "bookcondition")
public class BookCondition {
	@Id
	@Column(name = "Ranks")
	private int ranks;
	
	@Column(name = "Description",length = 50)
	private String description;
	
	@Column(name = "full_description",length = 255)
	private String fullDescription;
	
	@Column(name = "Price",precision = 12, scale = 2, columnDefinition = "decimal(12,2) default 30.00")
	private BigDecimal price;

	public BookCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRanks() {
		return ranks;
	}

	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
}