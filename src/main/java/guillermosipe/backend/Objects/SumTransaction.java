package guillermosipe.backend.Objects;

import java.math.BigDecimal;

public class SumTransaction {
	
	private Integer user_id;
	private BigDecimal sum;
	
	public SumTransaction(Integer user_id) {
		super();
		this.user_id = user_id;
		this.sum = BigDecimal.ZERO;
	}
	
	public void addAmount(BigDecimal amount) {
		this.sum = this.sum.add(amount);
	}
	
}
