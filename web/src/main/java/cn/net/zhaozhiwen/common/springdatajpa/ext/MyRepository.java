package cn.net.zhaozhiwen.common.springdatajpa.ext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.net.zhaozhiwen.common.springdatajpa.ext.query.QueryParam;

public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {

	//对jop进行扩展，支持类似 DBQueryParameter的功能
	public T findOneExt(final QueryParam params);
	public List<T> findAllListExt(final QueryParam params);
	public Page<T> findAllPageExt(final QueryParam params);
	public long countExt(final QueryParam params);
	//查询（不带分页）
	/**
	 * <pre>
	 * 固定sql，加占位符查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid
	 * paramsMap =>
	 * {name=kevin,bid=12}
	 * 返回List<Object[]>
	 * </pre>
	 */
	public List<Object[]> queryList(String nativeSql,Map<String,Object> paramsMap);
	/**
	 * <pre>
	 * 单个实体查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid
	 * paramsMap =>
	 * {name=kevin,bid=12}
	 * 返回Object[]
	 * </pre>
	 */
	public Object[] queryObject(String nativeSql,Map<String,Object> paramsMap);
	/**
	 * <pre>
	 * 固定sql，加占位符查询，返回信息包含字段列名
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid
	 * paramsMap =>
	 * {name=kevin,bid=12}
	 * 返回List<Map<String,Object>>
	 * </pre>
	 */
	public List<Map<String,Object>> queryMapList(String nativeSql,Map<String,Object> paramsMap);
	/**
	 * <pre>
	 * 固定sql，加占位符查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid
	 * paramsMap =>
	 * {name=kevin,bid=12}
	 * cls =>
	 * class VO{
	 *     private Integer id;
	 *     private String aname;
	 *     private String bname;
	 * }
	 * 返回 List<VO>
	 * </pre>
	 */
	public <E> List<E> queryFixedSqlNativeQuery(String nativeSql,Map<String,Object> paramsMap,Class<E> cls);
	
	//查询（带分页）
	/**
	 * <pre>
	 * 固定sql，加占位符   分页查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid limit :pagenum,:pagesize
	 * paramsMap =>
	 * {name=kevin,bid=12,pagenum=0,pagesize=10}
	 * pageIndexKey =>
	 * pagenum
	 * pageSizeKey =>
	 * pagesize
	 * 
	 * 返回 Page<Object[]> 
	 * 
	 * </pre>
	 */
	public Page<Object[]> queryPageList(String nativeSql,Map<String,Object> paramsMap,String pageIndexKey,String pageSizeKey);
	
	/**
	 * <pre>
	 * 不传pageIndexKey,pageSizeKey,使用默认'pagenum'，'pagesize'
	 * 固定sql，加占位符   分页查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid limit :pagenum,:pagesize
	 * paramsMap =>
	 * {name=kevin,bid=12,pagenum=0,pagesize=10}
	 * 
	 * 返回 Page<Object[]> 
	 * 
	 * </pre>
	 */
	public Page<Object[]> queryPageList(String nativeSql,Map<String,Object> paramsMap);
	/**
	 * <pre>
	 * 固定sql，加占位符   分页查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid limit :pagenum,:pagesize
	 * paramsMap =>
	 * {name=kevin,bid=12,pagenum=0,pagesize=10}
	 * cls =>
	 * class VO{
	 *     private Integer id;
	 *     private String aname;
	 *     private String bname;
	 * }
	 * pageIndexKey =>
	 * pagenum
	 * pageSizeKey =>
	 * pagesize
	 * 
	 * 返回 Page<DTO> 
	 * 
	 * </pre>
	 */
	public <DTO> Page<DTO>  queryDtoPageList(String nativeSql,Map<String,Object> paramsMap,Class<DTO> cls,String pageIndexKey,String pageSizeKey);
	
	/**
	 * <pre>
	 * 不传pageIndexKey,pageSizeKey,使用默认'pagenum'，'pagesize'
	 * 固定sql，加占位符   分页查询
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid limit :pagenum,:pagesize
	 * paramsMap =>
	 * {name=kevin,bid=12,pagenum=0,pagesize=10}
	 * cls =>
	 * class VO{
	 *     private Integer id;
	 *     private String aname;
	 *     private String bname;
	 * }
	 * 
	 * 返回 Page<DTO> 
	 * 
	 * </pre>
	 */
	public <DTO> Page<DTO>  queryDtoPageList(String nativeSql,Map<String,Object> paramsMap,Class<DTO> cls);
	//计数
	/**
	 *  统计sql,带占位符，返回Integer
	 */
	public Integer countInteger(String nativeSql,Map<String,Object> paramsMap);
	/**
	 *  统计sql,带占位符，返回Long
	 */
	public Long countLong(String nativeSql,Map<String,Object> paramsMap);
	
	//修改
	/**
	 *  更新sql,不带占位符
	 */
	public int executeUpdateNativeSQL(String nativeSql);
	/**
	 *  更新sql,带上占位符
	 */
	public int executeUpdateNativeSQL(String nativeSql,Map<String,Object> paramsMap);
	
	/**
	 *  获取EntityManager
	 */
	public EntityManager getEntityManager();
	//public Session getCurrentSession();
	
}