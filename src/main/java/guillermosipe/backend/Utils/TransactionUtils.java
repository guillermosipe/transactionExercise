package guillermosipe.backend.Utils;

import java.security.SecureRandom;

public class TransactionUtils {
	
	private static final String symbols = "0123456789abcdef";
	
	public static String generateTransactionId() {
		return generateRandomString(8)+"-"+generateRandomString(4)+"-"+generateRandomString(4)+"-"+generateRandomString(4)+"-"+generateRandomString(12);
	}
	
	private static String generateRandomString(Integer size) {
		
		SecureRandom secureRandom = new SecureRandom();
		char randomString[] = new char[size];
		for(int x = 0; x < size;x++) {
			randomString[x] = symbols.charAt(secureRandom.nextInt(symbols.length()));
		}
		return new String(randomString);
	}
}
