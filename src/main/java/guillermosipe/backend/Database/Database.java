package guillermosipe.backend.Database;

import java.util.ArrayList;

import guillermosipe.backend.Objects.Transaction;

public interface Database {
	
	public boolean createConnection();
	public boolean closeConnection();
	public boolean save(Transaction transaction);
	public ArrayList<Transaction> list(Integer userId);
	public Transaction getTransaccion(Integer userId,String transactionId);
	/*
	public sum(Integer userId);*/
	
}
