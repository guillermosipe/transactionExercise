package guillermosipe.backend.Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class ConvertUtils {

	public static BigDecimal convertStringToBigDecimal(String bigDecimalString){
		BigDecimal bigDecimal = BigDecimal.ZERO;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);	
		try {
			bigDecimal = (BigDecimal) decimalFormat.parse(bigDecimalString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bigDecimal;
	}
	
}
