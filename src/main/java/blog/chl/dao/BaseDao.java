package blog.chl.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

public interface BaseDao<T> {

	public void saveEntity(T entity);
	public void removeEntity(Query query);
	public T findById(String id);
	public List<T> findByQuery(Query query);
	public List<T> findAll();
	public List<T> pager(int page,int size);
}
