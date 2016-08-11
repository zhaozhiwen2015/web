package cn.net.zhaozhiwen.common.springdatajpa.ext.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.net.zhaozhiwen.common.springdatajpa.ext.query.QueryParam;
import cn.net.zhaozhiwen.common.springdatajpa.ext.query.QueryParseException;
import cn.net.zhaozhiwen.web.utils.CoreUtils;

public class ReflectionUtils {

	public final static String SYMBOL = "_";
	public static List<FieldProperty> mapper(QueryParam query){
		
		List<FieldProperty> retList = new ArrayList<FieldProperty>();
		if(null==query)return retList;
		Field[] fields = query.getClass().getDeclaredFields();
		Method method = null;
		String fieldName = "";
		Integer indexOfFlag = -1;
		FieldProperty tmpObj = null;
		for(Field field : fields){
			tmpObj = null;
			try {
				fieldName = field.getName();
				indexOfFlag = fieldName!=null?fieldName.indexOf(SYMBOL):-1;
				if(fieldName!=null && indexOfFlag > 0){
					QueryType type = QueryType.get(fieldName);
					if(null != type){
						if(type.getCode().equals(QueryCodeType.IS_NULL)||type.getCode().equals(QueryCodeType.IS_NOT_NULL)){
							tmpObj = new FieldProperty(fieldName.substring(indexOfFlag+1), type,  null); 		
						}else {
							method = query.getClass().getMethod("get"+fieldName, null);
							Object value = method.invoke(query, null);
							if(value != null){
								indexOfFlag = fieldName.indexOf(SYMBOL);
								tmpObj = new FieldProperty(fieldName.substring( indexOfFlag+1), type,  value); 						
							}
						}
						if(tmpObj != null){
							retList.add(tmpObj);
						}
					}
					
				}
				
			} catch (NoSuchMethodException e) {
				//e.printStackTrace();
				QueryParseException ex  = new QueryParseException("解析QueryParam，找不到对应get方法"/*,e.getCause()*/);
				//throw ex;
			} catch (SecurityException e) {
				e.printStackTrace();
				QueryParseException ex  = new QueryParseException("解析QueryParam，安全异常",e.getCause());
				throw ex;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				QueryParseException ex  = new QueryParseException("解析QueryParam，非法访问异常",e.getCause());
				throw ex;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				QueryParseException ex  = new QueryParseException("解析QueryParam，非法访问异常",e.getCause());
				throw ex;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				QueryParseException ex  = new QueryParseException("解析QueryParam，反射调用异常",e.getCause());
				throw ex;
			}
			
		}
		return retList;
	}
	public static <T> List<T> intialByClass(List<Object[]> valuesLst,Class<T> cls){
		List<T> retLst = new ArrayList<T>();
		if(CoreUtils.isNull(cls)||CoreUtils.isEmpty(valuesLst))return retLst;
		
		Field[] fields = cls.getDeclaredFields();
		//System.out.println(fields.length);
		String fieldName = null;
		String setMethodName = null;
		Method setMethod = null;
		Date tmpDate = null;
		for(Object[] oo:valuesLst){
			T obj = null;
			try {
				obj = (T)cls.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			/*if(fields.length!=oo.length){
				retLst.clear();
				return retLst;
			}*/
			//System.out.println(obj==null);
			int idx = 0;
			if(CoreUtils.isNotNull(obj)){
				for(Field field:fields){
					field.setAccessible(true);
					fieldName = field.getName();
					if(CoreUtils.isNotEmpty(fieldName)){
						fieldName = fieldName.replaceFirst(""+fieldName.charAt(0), (""+fieldName.charAt(0)).toUpperCase());
						setMethodName = "set".concat(fieldName);
						//System.out.println(field.getType().getName());
						try {
							if(oo.length<=idx){
								break;
							}
							if(field.getType().getName().equals("java.lang.Integer")||field.getType().getName().equals("int")){
								setMethod = cls.getMethod(setMethodName, Integer.class);
								setMethod.invoke(obj, oo[idx++]);
							}else if(field.getType().getName().equals("java.lang.String")){
								setMethod = cls.getMethod(setMethodName, String.class);
								setMethod.invoke(obj, oo[idx++]);
							}else if(field.getType().getName().equals("java.util.Date")){
								setMethod = cls.getMethod(setMethodName, Date.class);
								if(oo[idx] instanceof java.sql.Timestamp){
									tmpDate =(Date)oo[idx] ;
									idx ++;
									setMethod.invoke(obj, tmpDate);
								}else{
									setMethod.invoke(obj, oo[idx++]);	
								}
							}else{
								
								//idx++;
							}
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
						
					}
					
					/*if(CoreUtils.isNotEmpty(fieldName)){
						fieldName = fieldName.replaceFirst(""+fieldName.charAt(0), (""+fieldName.charAt(0)).toUpperCase());
						setMethodName = "set".concat(fieldName);
						try {
							setMethod = cls.getMethod(setMethodName, new Class[]{});
							setMethod.invoke(obj, args)
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}*/
				}								
			}
			retLst.add(obj);
		}

		return retLst;
	}
	
	
	public static void main(String[] args) {
		//mapper(new TeacherQueryParam());
		
		
	}
}
