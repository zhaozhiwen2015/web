package cn.net.zhaozhiwen.common.springdatajpa.ext.utils;

public enum QueryType {
	IS_NULL("N", QueryCodeType.IS_NULL ,"空"), 
	IS_NOT_NULL("NN", QueryCodeType.IS_NOT_NULL , "非空"), 
	LESS_THAN("LT", QueryCodeType.LESS_THAN ,"小于"), 
	LESS_THAN_OR_EQUAL("LE", QueryCodeType.LESS_THAN_OR_EQUAL ,"小于等于"), 
	EQUAL("EQ",QueryCodeType.EQUAL,"等于"),
	GREATER_THAN("GT",QueryCodeType.GREATER_THAN, "大于"),
	GREATER_THAN_OR_EQUAL("GE", QueryCodeType.GREATER_THAN_OR_EQUAL ,"大于等于"), 
	NOT_EQUAL("NE",QueryCodeType.NOT_EQUAL, "不等于"), 
	IN("IN", QueryCodeType.IN ,"IN"), 
	NOT_IN("NIN",QueryCodeType.NOT_IN ,"NOT IN"),
	LIKE("K", QueryCodeType.LIKE , "LIKE"), 
	LIKE_IGNORECASE("KI", QueryCodeType.LIKE_IGNORECASE ,"LIKE（忽略大小写）"), 
	NOT_LIKE("NK", QueryCodeType.NOT_LIKE ,"NOT LIKE"), 
	NOT_LIKE_IGNORECASE("NOT_LIKE_IGNORECASE", QueryCodeType.NOT_LIKE_IGNORECASE ,"NOT LIKE（忽略大小写）"), 
	EQUAL_IGNORECASE("EQI",QueryCodeType.EQUAL_IGNORECASE , "等于（忽略大小写）"), 
	NOT_EQUAL_IGNORECASE("NEI",QueryCodeType.NOT_EQUAL_IGNORECASE, "不等于（忽略大小写）"), 
	START_WITH("SW", QueryCodeType.START_WITH ,"START WITH"),
	
	
	PAGE_NUM("PN", QueryCodeType.PAGE_NUM ,"当前第几页"),
	PAGE_SIZE("PS", QueryCodeType.PAGE_SIZE ,"每页显示多少");
	
	private String name;
	private String descp;
	private QueryCodeType code;
	QueryType(String name,QueryCodeType code, String descp) {
		this.name = name;
		this.code = code;
		this.descp = descp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}
	
	public QueryCodeType getCode() {
		return code;
	}

	public void setCode(QueryCodeType code) {
		this.code = code;
	}

	public static QueryType get(String fieldName){
		if(null == fieldName)return null;
		for(QueryType type:QueryType.values()){
			if(fieldName.startsWith(type.getName().concat(ReflectionUtils.SYMBOL))){
				return type;
			}
		};
		return null;
	}

}
