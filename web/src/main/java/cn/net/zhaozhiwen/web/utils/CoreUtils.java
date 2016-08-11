/**
 * 
 */
package cn.net.zhaozhiwen.web.utils;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author zhaozhiwen
 *
 */
public final class CoreUtils {
	
	public static final String df1 = "yyyy-MM-dd HH:mm:ss";
	public static final String df2 = "yyyy-MM-dd";
	public static final String df3 = "HH:mm:ss";
	public static final String df4 = "MMddHHmmss";
	public static final String df5 = "yyyyMMdd";
	public static final String df6 = "HHmmss";
	public static final String df7 = "yyyyMMddHHmmss";
	public static final String df8 = "yyyyMMddHHmmssSSS";
	public static final String df9 = "yyyy/MM/dd HH:mm:ss";
	public static final String df10 = "HH:mm";

	private CoreUtils() {
	};
	
	public static String getUUID() {
		UUID uid = UUID.randomUUID();
		return uid.toString();
	}
	
	public static boolean isNull(Object obj) {
		return obj == null ? true : false;
	}
	
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	
	public static boolean isEmpty(Collection<?> c) {
		if (isNull(c)) {
			return true;
		}
		return c.size() < 1 ? true : false;
	}
	
	public static boolean isEmpty(Map<?, ?> m){
		if(isNull(m)) {
			return true;
		}
		return m.isEmpty();
	}
	
	public static boolean isEmpty(String s) {
		if (isNull(s)) {
			return true;
		}
		return s.trim().length() < 1 ? true : false;
	}

	public static <T> boolean isEmpty(T[] objs) {
		if (isNull(objs)) {
			return true;
		}
		return objs.length <= 0;
	}
	
	public static boolean isNotEmpty(Collection<?> c) {
		return !isEmpty(c);
	}
	
	public static boolean isNotEmpty(Map<?, ?> m){
		return !isEmpty(m);
	}
	
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	public static <T> boolean isNotEmpty(T[] objs) {
		return !isEmpty(objs);
	}
	
	/**
	 * 不为null且值大于0 返回true
	 */
	public static boolean isInteger(Integer obj) {
		return obj != null && obj.intValue()>0 ? true : false;
	}
	
	/**
	 * 不为null且值为true 返回true
	 */
	public static boolean isTrue(Boolean obj) {
		return obj != null && obj.booleanValue() ? true : false;
	}
	
	//************** 时间操作：*****************
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取格式为"yyyy/MM/dd HH:mm:ss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString9(Date date) {
		String rs = new DateTime(date).toString(df9);
		return rs;
	}
	/**
	 * 获取格式为"yyyy-MM-dd HH:mm:ss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString(Date date) {
		String rs = new DateTime(date).toString(df1);
		return rs;
	}
	/**
	 * 获取格式为"yyyyMMddHHmmssSSS"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString8(Date date) {
		String rs = new DateTime(date).toString(df8);
		return rs;
	}
	/**
	 * 获取格式为"yyyyMMddHHmmss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString7(Date date) {
		String rs = new DateTime(date).toString(df7);
		return rs;
	}
	/**
	 * 获取格式为HHmmss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString6(Date date) {
		String rs = new DateTime(date).toString(df6);
		return rs;
	}

	/**
	 * 获取格式为"yyyy-MM-dd "的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString2(Date date) {
		String rs = new DateTime(date).toString(df2);
		return rs;
	}
	
	/**
	 * 获取格式为"yyyyMMdd "的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString3(Date date) {
		String rs = new DateTime(date).toString(df5);
		return rs;
	}
	
	/**
	 * 获取格式为"yyyy-MM-dd HH:mm:ss"的当前时间string
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStampString() {
		String rs = DateTime.now().toString(df1);
		return rs;
	}

	
	/**
	 * 获取格式为"yyyyMMddHHmmss"的当前时间string
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStamp2String() {
		String rs = DateTime.now().toString(df7);
		return rs;
	}
	
	/**
	 * 获取格式为"yyyyMMddHHmmssSSS"的当前时间string
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStampSSS2String() {
		String rs = DateTime.now().toString(df8);
		return rs;
	}
	
	/**
	 * 获取格式为"HH:mm:ss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeString(Date date) {
		String rs = new DateTime(date).toString(df3);
		return rs;
	}
	
	/**
	 * 获取格式为"MMddHHmmss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertMMDateToStr(Date date) {
		String rs = new DateTime(date).toString(df4);
		return rs;
	}
	
	/**
	 * 获取格式为"yyyyMMdd"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertYYDateToStr(Date date) {
		String rs = new DateTime(date).toString(df5);
		return rs;
	}
	
	/**
	 * 获取格式为"HHmmss"的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertTimeToStr(Date date) {
		String rs = new DateTime(date).toString(df6);
		return rs;
	}
	
	/**
	 * 将Date时间转为指定格式的 String
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String convertDateToString(Date date, String dateFormat) {
		String rs = null;
		try {
			rs = new DateTime(date).toString(dateFormat);
		} catch (Exception e) {
			return null;
		}
		return rs;
	}
	
	/**
	 * 将时间字符串转成对应的Date时间
	 * @param dateStr
	 * @param dateFormat 注意填写的时间格式
	 * @return
	 */
	public static Date convertStringToDate(String dateStr, String dateFormat) {
		Date date = null;
		try {
			DateTimeFormatter dtf = DateTimeFormat.forPattern(dateFormat); 
	        DateTime parseDate1 = DateTime.parse(dateStr, dtf);
	        date = parseDate1.toDate();    // 转成 java.util.Date
		} catch (Exception e) {
			return null;
		}
		return date;
	}

	/**
	 * 返回当前时间TimeStamp
	 * 
	 * @return
	 */
	public static Timestamp getTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	
	/**
	 *  图片url增加缩略图后缀
	 *  例子：
	 *  originStr = TABCD.jpg
	 *  thumbSuffix = a_small
	 *  return TABCD_a_small.jpg
	 * @param originStr
	 * @param thumbSuffix
	 * @return
	 */
	public static String addSuffix(String originStr, String thumbSuffix){
		String newStr = "";
		String fileName = originStr; // 文件名
		String fileSuffix = ".jpg"; // 文件的后缀 譬如 .jpg , .png
		if(isEmpty(originStr) && isEmpty(thumbSuffix)){
			newStr = "";
		}else if(isEmpty(originStr)){
			newStr = thumbSuffix;
		}else if(isEmpty(thumbSuffix)){
			newStr = originStr;
		}else{
			int pointIndx = originStr.lastIndexOf(CoreConsts.POINT);
			if(pointIndx > 0) {
				fileSuffix = originStr.substring(pointIndx); // 原图后缀
				fileName = originStr.substring(0, pointIndx);
			}
			// 最终串 = 文件名 + 下划线 + 缩略图后缀 + 文件后缀
			newStr = fileName + CoreConsts.UNDERLINE + thumbSuffix + fileSuffix;
		}
		return newStr;
	}
	
	public static boolean isMath(String str) {
		if (isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("\\d*");
		return pattern.matcher(str).matches();

	}
	
	/**
	 * List集合通过关键字分组
	 * @author xiawenkui
	 *  2016-6-8
	 * @param fieleName
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<Object, List<T>> groupBy(String fieleName, List<T> list) throws Exception {
		if (list.isEmpty()) {
			return null;
		}
		Map<Object, List<T>> result = new LinkedHashMap<Object, List<T>>();
		// 反射得到泛型对象
		Class<? extends Object> cls = list.get(0).getClass();
		// 获取该对象的属性字段
		Field field = cls.getDeclaredField(fieleName);
		// 设置私有属性可以被外界访问
		field.setAccessible(true);
		Object key = null;
		for (T t : list) {
			key = field.get(t);
			if (result.keySet().contains(key)) {
				result.get(key).add(t);
			} else {
				List<T> value = new ArrayList<T>();
				value.add(t);
				result.put(key, value);
			}
		}
		return result;
	}
	
	/**
	 * 将数据库left join 查出的多表，反射到对应的实体里面
	 * @author xiawenkui
	 *  2016-6-16
	 * @param Class<?>[]
	 * @param Object[]
	 * @return
	 * @throws Exception
	 */
	public static Object[] addEntity(Class<?>[] classes,Object[] obj) throws Exception{
		//定义返回参数
		Object[] result=new Object[classes.length];
		int count = 0;
		for(int i=0 ;i<classes.length;i++){
			//得到Class对应的实体
			Object o = classes[i].newInstance();
			//获取实体的所有属性
			Class<? extends Object> cls = o.getClass();
			Field[] fielfs = cls.getDeclaredFields();
			for(Field field : fielfs){
				// 设置私有属性可以被外界访问
				field.setAccessible(true);
				try {
					//给实体属性设置值
					field.set(o, obj[count]);
					count ++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			result[i] = o;
		}
		return result;
	}
	/**
	 * 计算两个日期的天数差
	 * 例如：2016-6-16 - 2016-6-15 = 1
	 * @author xiawenkui
	 * @param minuend
	 *            被减数
	 * @param subtrahend
	 *            减数
	 * @return 天数差
	 * @throws ParseException
	 */
	public static long dateInterval(Date minuend, Date subtrahend) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		minuend = format.parse(format.format(minuend));
		subtrahend = format.parse(format.format(subtrahend));

		Calendar c = Calendar.getInstance();
		c.setTime(subtrahend);
		long interval = (minuend.getTime() - c.getTime().getTime()) / (24 * 60 * 60 * 1000);
		return interval;
	}
	
}
