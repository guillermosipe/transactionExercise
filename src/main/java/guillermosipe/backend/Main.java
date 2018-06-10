package guillermosipe.backend;

import java.util.ArrayList;

import guillermosipe.backend.Database.ImplDatabase;
import guillermosipe.backend.Objects.Transaction;
import guillermosipe.backend.Utils.Constants;
import guillermosipe.backend.Utils.TransactionUtils;

public class Main 
{
    public static void main( String[] args ) {
    	Integer userId = 10;
    	String action = "list";
    	String content = "{ \"amount\": 1.23, \"description\": \"Joes Tacos\", \"date\":\"2018-12-30\", \"user_id\": 345 }";
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
		    			System.out.println(TransactionUtils.convertTransactionToJson(transaction));
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
	    			System.out.println(TransactionUtils.convertTransactionsToJson(transactions));
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
	    		}
	    		break;
	    	case "sum":
	    		break;
	    	default:
	    		break;
    	}
    		
    		
    }
}
