package cn.net.zhaozhiwen.common.springdatajpa.ext.utils;

public class FieldProperty {

	String fieldName;
	QueryType queryType;
	Object value;
	
	
	public FieldProperty() {
		super();
	}
	
	public FieldProperty(String fieldName, QueryType queryType, Object value) {
		super();
		this.fieldName = fieldName;
		this.queryType = queryType;
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public QueryType getQueryType() {
		return queryType;
	}
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
