package com.sql.pdf.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "demo")
public class SqlPdf {
	
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Date date;
	private String pay_type;
	private String pay_details;
	private Long paid_out;
	private Long paid_in;
	private Long balance;
	private Long id;
	public SqlPdf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SqlPdf(Date date, String pay_type, String pay_details, Long paid_out, Long paid_in, Long balance, Long id) {
		super();
		this.date = date;
		this.pay_type = pay_type;
		this.pay_details = pay_details;
		this.paid_out = paid_out;
		this.paid_in = paid_in;
		this.balance = balance;
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getPay_details() {
		return pay_details;
	}
	public void setPay_details(String pay_details) {
		this.pay_details = pay_details;
	}
	public Long getPaid_out() {
		return paid_out;
	}
	public void setPaid_out(Long paid_out) {
		this.paid_out = paid_out;
	}
	public Long getPaid_in() {
		return paid_in;
	}
	public void setPaid_in(Long paid_in) {
		this.paid_in = paid_in;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SqlPdf [date=" + date + ", paid_out=" + paid_out + ", paid_in=" + paid_in + ", balance=" + balance
				+ "]";
	}
	
	
	
	
	

}
