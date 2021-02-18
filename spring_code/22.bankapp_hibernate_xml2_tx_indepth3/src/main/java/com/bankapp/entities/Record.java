package com.bankapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "record")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int fromAccId;
	private int toAccId;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private TxStatus status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	private String clearkName;
	
	@Enumerated(EnumType.STRING)
	private TxType  txType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromAccId() {
		return fromAccId;
	}
	public void setFromAccId(int fromAccId) {
		this.fromAccId = fromAccId;
	}
	public int getToAccId() {
		return toAccId;
	}
	public void setToAccId(int toAccId) {
		this.toAccId = toAccId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getClearkName() {
		return clearkName;
	}
	public void setClearkName(String clearkName) {
		this.clearkName = clearkName;
	}
	
	

	
	public TxStatus getStatus() {
		return status;
	}
	public void setStatus(TxStatus status) {
		this.status = status;
	}
	public TxType getTxType() {
		return txType;
	}
	public void setTxType(TxType txType) {
		this.txType = txType;
	}
	public Record() {}
	public Record(int fromAccId, int toAccId, double amount, TxStatus status, String clearkName,
			TxType txType) {
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
		this.status = status;
		this.clearkName = clearkName;
		this.txType = txType;
		this.timeStamp=new Date();
	}
	
	
	
	
}
