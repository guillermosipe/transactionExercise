package guillermosipe.backend.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import guillermosipe.backend.Objects.Transaction;
import guillermosipe.backend.Utils.Constants;

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
	
}
