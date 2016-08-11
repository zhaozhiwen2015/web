package cn.net.zhaozhiwen.common.springdatajpa.ext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.net.zhaozhiwen.common.springdatajpa.ext.query.QueryParam;
import cn.net.zhaozhiwen.common.springdatajpa.ext.utils.FieldProperty;
import cn.net.zhaozhiwen.common.springdatajpa.ext.utils.QueryCodeType;
import cn.net.zhaozhiwen.common.springdatajpa.ext.utils.ReflectionUtils;
import cn.net.zhaozhiwen.web.utils.CoreUtils;

@NoRepositoryBean
public class MyCustomRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements MyRepository<T, ID> {

	private final EntityManager entityManager;
	private final Class<T> entityClass;
	private static final Logger LOG = LoggerFactory.getLogger(MyCustomRepository.class);

	public MyCustomRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		entityClass = domainClass;
		entityManager = em;
	}

	public MyCustomRepository(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityClass = entityInformation.getJavaType();
		this.entityManager = entityManager;
	}

	//########################自定义扩展  开始###############################
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
	@SuppressWarnings("unchecked")
	public List<Object[]> queryList(String nativeSql,Map<String,Object> paramsMap){
		List<Object[]> ret = null;
		Query query = this.entityManager.createNativeQuery(nativeSql);
		if(!(null==paramsMap ||paramsMap.size()<=0)){
			for(String key:paramsMap.keySet()){
				if(nativeSql.indexOf(":".concat(key))>=0){
					query.setParameter(key, paramsMap.get(key));					
				}
			}
		}
		ret = query.getResultList();
		return ret;
	}
	/**
	 * <pre>
	 * 单个实体查询,加占位符
	 * nativeSql =>
	 * select a.id,b.name,a.name from t_a a,t_b b where a.id=b.id and a.name = :name and b.id=:bid
	 * paramsMap =>
	 * {name=kevin,bid=12}
	 * 返回Object[]
	 * </pre>
	 */
	
	public Object[] queryObject(String nativeSql, Map<String, Object> paramsMap) {
		List<Object[]> objLst =  queryList(nativeSql,paramsMap);
		if(CoreUtils.isNotEmpty(objLst)){
			return objLst.get(0);
		}
		return null;
	}
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
	@SuppressWarnings("unchecked")
	
	public List<Map<String,Object>> queryMapList(String nativeSql, Map<String, Object> paramsMap) {
		Query query = this.entityManager.createNativeQuery(nativeSql);
		if(!(null==paramsMap ||paramsMap.size()<=0)){
			for(String key:paramsMap.keySet()){
				if(nativeSql.indexOf(":".concat(key))>=0){
					query.setParameter(key, paramsMap.get(key));									
				}
			}
		}
		query.unwrap(SQLQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> xx = query.getResultList();
		return xx;
	}
	
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
	public <E> List<E> queryFixedSqlNativeQuery(String nativeSql,Map<String,Object> paramsMap,Class<E> cls){
		if(CoreUtils.isNull(cls))return null;
		List<Object[]> objLst = this.queryList(nativeSql, paramsMap);
		List<E> lst = ReflectionUtils.intialByClass(objLst,cls);
		return lst;
	}

	private Map<String,Object> parse(final QueryParam params){
		if(CoreUtils.isNull(params)){
			return null;			
		}
		final  List<FieldProperty> paramsLst = ReflectionUtils.mapper(params);
		LOG.debug("解析参数：{}",paramsLst.size());
		Map<String,Object> retMap = new HashMap<String,Object>();
		for(FieldProperty param : paramsLst ){
			if(param.getQueryType().getCode().equals(QueryCodeType.PAGE_NUM)){
				retMap.put("pageNum", param.getValue());
			}
			if(param.getQueryType().getCode().equals(QueryCodeType.PAGE_SIZE)){
				retMap.put("pageSize", param.getValue());
			}
		}
		Specification<T> specification = new Specification<T>(){
			@SuppressWarnings({ "unchecked", "rawtypes" })
			
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				for(FieldProperty param : paramsLst ){
					Path expression = null;
					if(!(param.getQueryType().getCode().equals(QueryCodeType.PAGE_NUM)||
							param.getQueryType().getCode().equals(QueryCodeType.PAGE_SIZE))){
						expression = root.get(param.getFieldName());						
					}
					switch(param.getQueryType().getCode()){
						case IS_NULL: 
							predicates.add(cb.isNull((expression)));
							break;
						case IS_NOT_NULL: 
							predicates.add(cb.isNotNull((expression)));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(expression, (Comparable) param.getValue()));
							break;
						case LESS_THAN_OR_EQUAL: 
							predicates.add(cb.lessThanOrEqualTo(expression, (Comparable) param.getValue()));
							break; 
						case EQUAL: 
							predicates.add(cb.equal(expression, (Comparable) param.getValue()));
							break; 
						case GREATER_THAN: 
							predicates.add(cb.greaterThan(expression, (Comparable) param.getValue()));
							break; 
						case GREATER_THAN_OR_EQUAL: 
							predicates.add(cb.greaterThanOrEqualTo(expression, (Comparable) param.getValue()));
							break; 
						case NOT_EQUAL: 
							predicates.add(cb.notEqual(expression, (Comparable) param.getValue()));
							break; 
						case IN: 
							predicates.add(cb.in(expression).value((Collection) param.getValue()));
							break; 
						case NOT_IN: 
							predicates.add(cb.in(expression).value((Collection) param.getValue()).not());
							break; 
						case LIKE: 
							predicates.add(cb.like(expression, "%"+param.getValue().toString().trim()+"%"));
							break;
						case LIKE_IGNORECASE: 
							predicates.add(cb.like(cb.upper(expression), "%"+param.getValue().toString().trim().toUpperCase()+"%"));
							break;
						case NOT_LIKE: 
							predicates.add(cb.notLike(expression, "%"+param.getValue().toString().trim()+"%"));
							break;
						case NOT_LIKE_IGNORECASE: 
							predicates.add(cb.notLike(cb.upper(expression), "%"+param.getValue().toString().trim().toUpperCase()+"%"));
							break;
						case EQUAL_IGNORECASE: 
							predicates.add(cb.equal(cb.upper(expression), (Comparable) param.getValue().toString().trim().toUpperCase()));
							break; 
						case NOT_EQUAL_IGNORECASE: 
							predicates.add(cb.notEqual(cb.upper(expression), (Comparable) param.getValue().toString().trim().toUpperCase()));
							break;
						case START_WITH: 
							predicates.add(cb.like(expression, param.getValue().toString().trim()+"%"));
							break;
						case PAGE_NUM: 
							break;
						case PAGE_SIZE:
							break;
					}
				}
				if(CoreUtils.isNotEmpty(predicates)){
					return cb.and(predicates.toArray(new Predicate[predicates.size()]));
				}
				return cb.conjunction();
			}
		};
		retMap.put("spec", specification);
		return retMap;
	}
	
	//扩展 单表查询接口
	@SuppressWarnings("unchecked")
	public T findOneExt(final QueryParam params){
		Map<String,Object> retMap = parse(params);
		if(retMap.containsKey("spec")){
			Specification<T> spec = (Specification<T>)retMap.get("spec");
			if(CoreUtils.isNull(spec))return null;
			List<T> results =  this.findAll(spec);
			if(CoreUtils.isEmpty(results))return null;
			return results.get(0);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<T> findAllListExt(QueryParam params){
		Map<String,Object> retMap = parse(params);
		if(CoreUtils.isEmpty(retMap)){
			return null;			
		}
		if(retMap.containsKey("spec")){
			Specification<T> spec = (Specification<T>)retMap.get("spec");
			if(CoreUtils.isNull(spec))return null;
			return this.findAll(spec);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public Page<T> findAllPageExt(QueryParam params){
		Map<String,Object> retMap = parse(params);
		if(CoreUtils.isEmpty(retMap)){
			return null;			
		}
		Integer pageNum = 0;
		Integer pageSize = 10;
		if(retMap.containsKey("pageNum")&&CoreUtils.isNotNull(retMap.containsKey("pageNum"))){
			pageNum = Integer.parseInt(retMap.get("pageNum").toString());
		}
		if(retMap.containsKey("pageSize")&&CoreUtils.isNotNull(retMap.containsKey("pageSize"))){
			pageSize = Integer.parseInt(retMap.get("pageSize").toString());
		}
		if(retMap.containsKey("spec")){
			Pageable pageable = new PageRequest(pageNum,pageSize);
			Specification<T> spec = (Specification<T>)retMap.get("spec");
			if(CoreUtils.isNull(spec))return null;
			return this.findAll(spec, pageable);
		}
		return null;
		
	}
	@SuppressWarnings("unchecked")
	public long countExt(QueryParam params){
		Map<String,Object> retMap = parse(params);
		if(CoreUtils.isEmpty(retMap)){
			return -1l;			
		}
		if(retMap.containsKey("spec")){
			Specification<T> spec = (Specification<T>)retMap.get("spec");
			if(CoreUtils.isNull(spec))return -1l;
			return this.count(spec);
		}
		return -1l;
	}
	//########################自定义扩展  结束###############################


	/*
	public Session getCurrentSession() {
		Session session = (org.hibernate.Session) entityManager.getDelegate();
		SessionFactory sf = (SessionFactoryImplementor) session.getSessionFactory();
		Session s = sf.getCurrentSession();
		return s;

	}*/
	/**
	 *  更新sql,不带占位符
	 */
	
	public int executeUpdateNativeSQL(String nativeSql) {
		return executeUpdateNativeSQL(nativeSql, null); 
	}
	/**
	 *  更新sql,带上占位符
	 */
	
	public int executeUpdateNativeSQL(String nativeSql, Map<String, Object> paramsMap) {
		Query query = this.entityManager.createNativeQuery(nativeSql);
		if(!(null==paramsMap ||paramsMap.size()<=0)){
			for(String key:paramsMap.keySet()){
				if(nativeSql.indexOf(":".concat(key))>=0){
					query.setParameter(key, paramsMap.get(key));	
				}
			}
		}
		return query.executeUpdate();
	}
	/**
	 *  统计sql,带占位符，返回Integer
	 */
	
	public Integer countInteger(String nativeSql, Map<String, Object> paramsMap) {
		Query query = this.entityManager.createNativeQuery(nativeSql);
		if(!(null==paramsMap ||paramsMap.size()<=0)){
			for(String key:paramsMap.keySet()){
				if(nativeSql.indexOf(":".concat(key))>=0){
					query.setParameter(key, paramsMap.get(key));	
				}			
			}
		}
		Object object = query.getSingleResult();
		if(CoreUtils.isNull(object)){
			return 0;
		}else{
			try{
				return Integer.parseInt(object.toString());
			}catch(Exception e){
				return 0;
			}
		}
	}
	/**
	 *  统计sql,带占位符，返回Long
	 */
	
	public Long countLong(String nativeSql, Map<String, Object> paramsMap) {
		Query query = this.entityManager.createNativeQuery(nativeSql);
		if(!(null==paramsMap ||paramsMap.size()<=0)){
			for(String key:paramsMap.keySet()){
				if(nativeSql.indexOf(":".concat(key))>=0){
					query.setParameter(key, paramsMap.get(key));	
				}
			}
		}
		Object object = query.getSingleResult();
		if(CoreUtils.isNull(object)){
			return 0L;
		}else{
			try{
				return Long.parseLong(object.toString());
			}catch(Exception e){
				return 0L;
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Page<Object[]> queryPageList(String nativeSql, Map<String, Object> paramsMap,String pageIndexKey,String pageSizeKey) {
		if(CoreUtils.isEmpty(nativeSql)||nativeSql.indexOf("from")<0)return null;
		String suffixSql = nativeSql.substring(nativeSql.indexOf("from")).trim(); 
		List<Object[]>  list = this.queryList(nativeSql, paramsMap);
		Integer count = this.countInteger("select count(1) ".concat(suffixSql), paramsMap);	
		Integer pageIndex = 0;
		Integer pageSize = 10;
		if(paramsMap.containsKey(pageIndexKey)){
			pageIndex = Integer.valueOf(paramsMap.get(pageIndexKey).toString().trim());
		}
		if(paramsMap.containsKey(pageSizeKey)){
			pageSize = Integer.valueOf(paramsMap.get(pageSizeKey).toString().trim());
		}
		Pageable pageable =  new PageRequest(pageIndex,pageSize);
		Page<Object[]> page  =  new PageImpl(list,pageable,count);
		return page;
	}
	
	
	public Page<Object[]> queryPageList(String nativeSql, Map<String, Object> paramsMap) {
		return this.queryPageList(nativeSql, paramsMap, "pagenum", "pagesize");
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public <DTO> Page<DTO> queryDtoPageList(String nativeSql, Map<String, Object> paramsMap, Class<DTO> cls,
			String pageIndexKey, String pageSizeKey) {
		
		if(CoreUtils.isEmpty(nativeSql)||nativeSql.indexOf("from")<0)return null;
		String suffixSql = nativeSql.substring(nativeSql.indexOf("from")).trim(); 
		Integer count = this.countInteger("select count(1) ".concat(suffixSql), paramsMap);	
		Integer pageIndex = 0;
		Integer pageSize = 10;
		if(paramsMap.containsKey(pageIndexKey)){
			pageIndex = Integer.valueOf(paramsMap.get(pageIndexKey).toString().trim());
		}
		if(paramsMap.containsKey(pageSizeKey)){
			pageSize = Integer.valueOf(paramsMap.get(pageSizeKey).toString().trim());
		}
		
		List<Object[]>  objLst = this.queryList(nativeSql.concat(" limit ").concat(pageIndex.toString()).concat(",").concat(pageSize.toString()), paramsMap);
		List<DTO> list = ReflectionUtils.intialByClass(objLst,cls);
		
		Pageable pageable =  new PageRequest(pageIndex,pageSize);
		Page<DTO> page  =  new PageImpl(list,pageable,count);
		return page;
	}
	

	
	public <DTO> Page<DTO> queryDtoPageList(String nativeSql, Map<String, Object> paramsMap, Class<DTO> cls) {
		return this.queryDtoPageList(nativeSql, paramsMap, cls, "pagenum", "pagesize");
	}

	/**
	 *  获取EntityManager
	 */
	
	public EntityManager getEntityManager(){
		return entityManager;
	}


	
}