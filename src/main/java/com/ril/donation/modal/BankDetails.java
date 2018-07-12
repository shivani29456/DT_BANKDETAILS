package com.ril.donation.modal;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="DT_BankDetails")
@EntityListeners(AuditingEntityListener.class)

public class BankDetails 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,length=11,name="serialNo")
	private Integer serialNo;
	
	@Column(name="EntityID",nullable=false,length=4)
	private Character entityID;
	
	@Column(name="BankAccountNumber",nullable=false,length=25)
	private String bankAccountNumber;
	
	@Column(name="BankName",nullable=false,length=25)
	private String bankName;
	
	@Column(name="IFSC",nullable=false,length=4)
	private Character ifsc;

	@Column(name="Address",nullable=false,length=60)
	private String address;
	
	@Column(name="OpeningBalanceExist",nullable=false,length=4)
	private Character openingBalanceExist;

	@Column(name="ClosingBalanceExist",nullable=false,length=4)
	private Character closingBalanceExist;
	
	@Column(name="TransactionsYearExist",nullable=false,length=4)
	private Character transactionsYearExist;

	@Column(name="Status",nullable=false,length=4)
	private Character status;

	@Column(name="refundAccount",nullable=false,length=4)
	private Character refundAccount;

	@Column(name="IsActive",nullable=false,length=1)
	private boolean isActive;
	
	@Column(name="CreatedBy",nullable=false,length=50)
    private String createdBy;
	
	@CreationTimestamp
	@Column(name="CreatedOn",nullable=false)
    private Date createdOn;
	
	@Column(name="UpdatedBy",nullable=false,length=50)
    private String updatedBy;
	
	@UpdateTimestamp
	@Column(name="UpdatedOn",nullable=false)
    private Date updatedOn;
	
	@CreationTimestamp
	@Column(name="Timestamp",nullable=false)
	private Timestamp  timestamp;

	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Character getEntityID() {
		return entityID;
	}

	public void setEntityID(Character entityID) {
		this.entityID = entityID;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Character getIfsc() {
		return ifsc;
	}

	public void setIfsc(Character ifsc) {
		this.ifsc = ifsc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Character getOpeningBalanceExist() {
		return openingBalanceExist;
	}

	public void setOpeningBalanceExist(Character openingBalanceExist) {
		this.openingBalanceExist = openingBalanceExist;
	}

	public Character getClosingBalanceExist() {
		return closingBalanceExist;
	}

	public void setClosingBalanceExist(Character closingBalanceExist) {
		this.closingBalanceExist = closingBalanceExist;
	}

	public Character getTransactionsYearExist() {
		return transactionsYearExist;
	}

	public void setTransactionsYearExist(Character transactionsYearExist) {
		this.transactionsYearExist = transactionsYearExist;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Character getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(Character refundAccount) {
		this.refundAccount = refundAccount;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
	
}
