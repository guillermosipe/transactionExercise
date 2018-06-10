package guillermosipe.backend.Objects;

import guillermosipe.backend.Utils.Constants;

public class Request {
	
	private Integer userId;
	private String action;
	private String transaction_id;
	private String content;
	
	public Request(String[] args) {
		this.userId = Integer.parseInt(args[Constants.ARGS_USER_ID_IDX]);
		this.action = args[Constants.ARGS_ACTION_IDX];
		if(this.action.compareTo("add") == 0) {
			this.content = "";
			for(int x = Constants.ARGS_CONTENT_IDX; x < args.length; x++) {
	            this.content = this.content + " " + args[x]; 
	        }
		}
		else if(this.action.compareTo("list") != 0 && this.action.compareTo("sum") != 0) {
			this.transaction_id = args[Constants.ARGS_TRANSACTION_ID_IDX];
			this.action = "";
		}
		
	}
	
	public Integer getUserId() {
		return userId;
	}
	public String getAction() {
		return action;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public String getContent() {
		return content;
	}
	
	
}
