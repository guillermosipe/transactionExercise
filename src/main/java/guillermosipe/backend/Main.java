package guillermosipe.backend;

import guillermosipe.backend.Database.Database;
import guillermosipe.backend.Database.ImplDatabase;
import guillermosipe.backend.Objects.Transaction;
import guillermosipe.backend.Utils.ConvertUtils;
import guillermosipe.backend.Utils.TransactionUtils;

public class Main 
{
    public static void main( String[] args ) {
    	Integer userId = 0;
    	String action = "add";
    	String content = "{ \"amount\": 1.23, \"description\": \"Joes Tacos\", \"date\":\"2018-12-30\", \"user_id\": 345 }";
    	ImplDatabase database = new ImplDatabase();
    	
    	switch(action) {
	    	case "add":
	    		if(database.createConnection()) {
		    		Transaction transaction = ConvertUtils.convertJsonToTransaction(content);
		    		transaction.setTransaction_id(TransactionUtils.generateTransactionId());
		    		if(database.save(transaction))
		    		{
		    			database.closeConnection();
		    			System.out.println(ConvertUtils.convertTransactionToJson(transaction));
		    		}
		    		else
		    		{
		    			System.out.println("ERROR: Transaction doesnt save");
		    		}
	    		}
	    		else {
	    			System.out.println("ERROR: Database not available");
	    		}
	    			
	    		break;
	    	case "list":
	    		break;
	    	case "sum":
	    		break;
	    	default:
	    		break;
    	}
    		
    		
    }
}
