package guillermosipe.backend.Utils;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.Gson;

import guillermosipe.backend.Objects.Transaction;

public class TransactionUtils {
	
	
	public static String generateTransactionId() {
		return generateRandomString(8)+"-"+generateRandomString(4)+"-"+generateRandomString(4)+"-"+generateRandomString(4)+"-"+generateRandomString(12);
	}
	
	private static String generateRandomString(Integer size) {
		
		SecureRandom secureRandom = new SecureRandom();
		char randomString[] = new char[size];
		for(int x = 0; x < size;x++) {
			randomString[x] = Constants.RANDOM_ID_CHAR.charAt(secureRandom.nextInt(Constants.RANDOM_ID_CHAR.length()));
		}
		return new String(randomString);
	}
	
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
	
	public static String convertTransactionsToJson(ArrayList<Transaction> transactions) {
		Gson gson = new Gson();
		String json = gson.toJson(transactions);
		return json;
	}
	
	public static Transaction convertCsvToTransaction(String csvLine) {
		String [] data = csvLine.split(Constants.CSV_SEPARATOR);
		return new Transaction(Integer.parseInt(data[Constants.USER_ID_DESTINY_IDX]),data[Constants.TRANSACTION_ID_IDX], ConvertUtils.convertStringToBigDecimal(data[Constants.AMOUNT_IDX]), data[Constants.DESCRIPTION_IDX], data[Constants.DATE_IDX], Integer.parseInt(data[Constants.USER_ID_IDX]));
	}
}
