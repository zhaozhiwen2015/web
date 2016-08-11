package cn.net.zhaozhiwen.common.springdatajpa.ext.query;

@SuppressWarnings("serial")
public class QueryParseException extends RuntimeException {

	    public QueryParseException() {
	        super();
	    }

	    public QueryParseException(String message) {
	        super(message);
	    }


	    public QueryParseException(String message, Throwable cause) {
	        super(message, cause);
	    }

	
	    public QueryParseException(Throwable cause) {
	        super(cause);
	    }

	   /* protected QueryParseException(String message, Throwable cause,
	                               boolean enableSuppression,
	                               boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }*/
}
