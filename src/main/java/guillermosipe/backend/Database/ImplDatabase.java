package guillermosipe.backend.Database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import guillermosipe.backend.Objects.Transaction;
import guillermosipe.backend.Utils.Constants;
import guillermosipe.backend.Utils.ConvertUtils;
import guillermosipe.backend.Utils.TransactionUtils;

public class ImplDatabase implements Database{
	
	File file;
		
	@Override
	public boolean createConnection() {
		boolean flag = false;
		file = new File(Constants.DATABASE);
		flag = true;
		return flag;
	}

	@Override
	public boolean closeConnection() {
		return true;
	}
	
	@Override
	public boolean save(Transaction transaction) {
		boolean flag = false;
	    try {
	    	FileWriter fw = new FileWriter(file, true);
		    BufferedWriter bw = new BufferedWriter(fw);
			bw.write(transaction.toString());
		    bw.close();
		    flag = true;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}  
		return flag;
	}

	@Override
	public ArrayList<Transaction> list(Integer userId) {
		String line = "";
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			FileReader r = new FileReader(file);
			BufferedReader b = new BufferedReader(r);
		    
		    while( (line=b.readLine()) != null) {
		        Transaction transaction = TransactionUtils.convertCsvToTransaction(line);
		        if(transaction.getUser_id_Destiny()==userId)
		        {
		        	transaction.setUser_id_Destiny(null);
		        	transactions.add(transaction);
		        }
		    }
		    b.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return transactions;
	}
	
}
