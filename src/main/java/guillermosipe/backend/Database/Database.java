package guillermosipe.backend.Database;

import java.util.ArrayList;

import guillermosipe.backend.Objects.Transaction;

public interface Database {
	
	public boolean createConnection();
	public boolean closeConnection();
	public boolean save(Transaction transaction);
	public ArrayList<Transaction> list(Integer userId);
	/*public boolean show(String transactionId);
	public list(Integer userId);
	public sum(Integer userId);*/
	
}
