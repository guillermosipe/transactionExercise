package guillermosipe.backend;

import java.util.ArrayList;

import guillermosipe.backend.Database.ImplDatabase;
import guillermosipe.backend.Objects.SumTransaction;
import guillermosipe.backend.Objects.Transaction;
import guillermosipe.backend.Utils.Constants;
import guillermosipe.backend.Utils.TransactionUtils;

public class Main 
{
    public static void main( String[] args ) {
    	Integer userId = 102;
    	String action = "";
    	String transaction_id = "b9fa8c76-0577-864c-f7c1-7261ffd1283f";
    	String content = "{ \"amount\": 10.23, \"description\": \"Joes Tacos\", \"date\":\"2018-12-30\", \"user_id\": 345 }";
    	ImplDatabase database = new ImplDatabase();
    	
    	switch(action) {
	    	case "add":
	    		if(database.createConnection()) {
		    		Transaction transaction = TransactionUtils.convertJsonToTransaction(content);
		    		transaction.setTransaction_id(TransactionUtils.generateTransactionId());
		    		transaction.setUser_id_Destiny(userId);
		    		if(database.save(transaction))
		    		{
		    			database.closeConnection();
		    			transaction.setUser_id_Destiny(null);
		    			System.out.println(TransactionUtils.convertToJson(transaction));
		    		}
		    		else
		    		{
		    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
		    		}
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_SAVE);
	    		}		
	    		break;
	    	case "list":
	    		if(database.createConnection()) {
	    			ArrayList<Transaction> transactions = database.list(userId);
	    			System.out.println(TransactionUtils.convertToJson(transactions));
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
	    		}
	    		break;
	    	case "sum":
	    		if(database.createConnection()) {
	    			SumTransaction sumTransaction = database.sum(userId);
	    			System.out.println(TransactionUtils.convertToJson(sumTransaction));
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
	    		}
	    		break;
	    	default:
	    		if(database.createConnection()) {
	    			Transaction transaction = database.getTransaccion(userId,transaction_id);
	    			if(transaction != null)
	    			{
	    				System.out.println(TransactionUtils.convertToJson(transaction));
	    			}
	    			else
	    			{
	    				System.out.println(Constants.ERROR_TRANSACTION_NOT_FOUND);
	    			}
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
	    		}
	    		break;
    	}
    		
    		
    }
}
