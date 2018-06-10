package guillermosipe.backend.Utils;

public class Constants {
	
	/* Charset Random */
	public static final String RANDOM_ID_CHAR = "0123456789abcdef";
	
	/* Connection */
	public static final String DATABASE = "database.csv";
	
	/* CSV configuration */
	public static final String CSV_SEPARATOR = ",";
	public static final String CSV_END_LINE = "\n";
	
	/* CSV index */
	public static final Integer USER_ID_DESTINY_IDX = 0;
	public static final Integer TRANSACTION_ID_IDX = 1;
	public static final Integer AMOUNT_IDX = 2;
	public static final Integer DESCRIPTION_IDX = 3;
	public static final Integer DATE_IDX = 4;
	public static final Integer USER_ID_IDX = 5;
	
	/* Error message */
	public static final String ERROR_DATABASE_CONNECTION="Database not available";
	public static final String ERROR_DATABASE_SAVE="Transaction doesnt save";
	public static final String ERROR_TRANSACTION_NOT_FOUND="Transaction not found";
	public static final String ERROR_INVALID_REQUEST="Invalid Request";
	
	/* ARGS index */
	public static final Integer ARGS_USER_ID_IDX = 0;
	public static final Integer ARGS_ACTION_IDX = 1;
	public static final Integer ARGS_TRANSACTION_ID_IDX = 1;
	public static final Integer ARGS_CONTENT_IDX = 2;
}
