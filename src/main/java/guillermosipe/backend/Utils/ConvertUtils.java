package guillermosipe.backend.Utils;

import com.google.gson.Gson;

import guillermosipe.backend.Objects.Transaction;

public class ConvertUtils {

	public static Transaction convertJsonToTransaction(String json) {
		Gson gson = new Gson();
		Transaction transaction = gson.fromJson(json, Transaction.class);
		return transaction;
	}
	
	public static String convertTransactionToJson(Transaction transaction) {
		Gson gson = new Gson();
		String json = gson.toJson(transaction);
		return json;
	}
	
}
