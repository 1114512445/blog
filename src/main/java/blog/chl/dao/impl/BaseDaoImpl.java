package blog.chl.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import blog.chl.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	@SuppressWarnings("rawtypes")
	private Class clazz;
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	@Autowired
	private MongoTemplate template;
	
	public void saveEntity(T entity) {
		
		template.save(entity);
	}

	public void removeEntity(Query query) {
		
		template.remove(query,clazz);
	}
	
	@SuppressWarnings("unchecked")
	public T findById(String id) {
		
		List<T> entity = template.find(Query.query(Criteria.where("id").is(id)),clazz);
		if(null == entity) 
			return null;
		
		return entity.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByQuery(Query query) {
		
		List<T> entities = template.find(query, clazz);
		
		return entities;
	}
	@SuppressWarnings("unchecked")
	public List<T> pager(int page, int size) {
		
		Query query = new Query();
		query.skip((page-1)*size).limit(size);
		
		List<T> entities = template.find(query, clazz);
		
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		
		
		return template.findAll(clazz);
	}

}
