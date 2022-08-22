package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="travels")
public class Travels {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=2, max=200, message="Expense name must be at least 2 charecters long")
	private String expense;
  
	@NotNull
	@Size(min=3, max=200,  message="Vendor name must be at least 3 charecters long")
	private String vendor;
	
	@NotNull
	@Size(min=1, max=200,  message="Description must not be blank")
	private String description;
  
	@NotNull
	@Min(0)
	private Double amount;
	

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	    
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//Constructors
	public Travels() {
		
	}
	

	public Travels(String expense, String vendor, Double amount, String description) {
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getExpense() {
		return expense;
	}


	public void setExpense(String expense) {
		this.expense = expense;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
