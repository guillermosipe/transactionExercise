package guillermosipe.backend;

import java.util.ArrayList;

import guillermosipe.backend.Database.ImplDatabase;
import guillermosipe.backend.Objects.Request;
import guillermosipe.backend.Objects.SumTransaction;
import guillermosipe.backend.Objects.Transaction;
import guillermosipe.backend.Utils.Constants;
import guillermosipe.backend.Utils.TransactionUtils;

public class Main 
{
    public static void main( String[] args ) {

    	Request request = new Request(args);    	
    	ImplDatabase database = new ImplDatabase();
    	
    	if(request.getAction().compareTo("") == 0 && request.getTransaction_id().compareTo("") == 0)
    	{
    		System.out.println(Constants.ERROR_DATABASE_CONNECTION);
    		return;
    	}
    	
    	switch(request.getAction()) {
	    	case "add":
	    		if(database.createConnection()) {
		    		Transaction transaction = TransactionUtils.convertJsonToTransaction(request.getContent());
		    		transaction.setTransaction_id(TransactionUtils.generateTransactionId());
		    		transaction.setUser_id_Destiny(request.getUserId());
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
	    			ArrayList<Transaction> transactions = database.list(request.getUserId());
	    			System.out.println(TransactionUtils.convertToJson(transactions));
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
	    		}
	    		break;
	    	case "sum":
	    		if(database.createConnection()) {
	    			SumTransaction sumTransaction = database.sum(request.getUserId());
	    			System.out.println(TransactionUtils.convertToJson(sumTransaction));
	    		}
	    		else {
	    			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
	    		}
	    		break;
	    	default:
	    		if(database.createConnection()) {
	    			Transaction transaction = database.getTransaccion(request.getUserId(),request.getTransaction_id());
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
    	return;			
    }
}
