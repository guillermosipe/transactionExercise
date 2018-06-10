package guillermosipe.backend.Objects;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
	String transaction_id;
	BigDecimal amount;
	String description;
	String date;
	Integer user_id;
	
	public Transaction() {
	}
	
	public Transaction(String transaction_id, BigDecimal amount, String description, String date, Integer user_id) {
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.user_id = user_id;
	}
	
	public Transaction(BigDecimal amount, String description, String date, Integer user_Id) {
		this("",amount,description,date,user_Id);
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public String getDate() {
		return date;
	}
	public Integer getUser_Id() {
		return user_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setUser_Id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return transaction_id + "," + amount + "," + description + "," + date + "," + user_id + "\n";
	}
	
	
	
	
}
