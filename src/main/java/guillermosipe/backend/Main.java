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
    	
    	if(database.createConnection()) {
	    	switch(request.getAction()) {
		    	case "add":
		    		Transaction transaction = TransactionUtils.convertJsonToTransaction(request.getContent());
		    		transaction.setTransaction_id(TransactionUtils.generateTransactionId());
		    		transaction.setUser_id_Destiny(request.getUserId());
		    		if(database.save(transaction)) {
		    			database.closeConnection();
		    			transaction.setUser_id_Destiny(null);
		    			System.out.println(TransactionUtils.convertToJson(transaction));
		    		}
		    		else {
		    			System.out.println(Constants.ERROR_DATABASE_SAVE);
		    		}
		    		break;
		    	case "list":
	    			ArrayList<Transaction> transactions = database.list(request.getUserId());
	    			System.out.println(TransactionUtils.convertToJson(transactions));
		    		break;
		    	case "sum":
	    			SumTransaction sumTransaction = database.sum(request.getUserId());
	    			System.out.println(TransactionUtils.convertToJson(sumTransaction));
		    		break;
		    	default:
	    			Transaction transactionGet = database.getTransaccion(request.getUserId(),request.getTransaction_id());
	    			if(transactionGet != null)	{
	    				System.out.println(TransactionUtils.convertToJson(transactionGet));
	    			} 
	    			else {
	    				System.out.println(Constants.ERROR_TRANSACTION_NOT_FOUND);
	    			}
		    		break;
	    	}
	    	database.closeConnection();
    	}
    	else {
			System.out.println(Constants.ERROR_DATABASE_CONNECTION);
		}
    	return;			
    }
}
