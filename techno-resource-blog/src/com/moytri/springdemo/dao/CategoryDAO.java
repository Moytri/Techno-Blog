package com.moytri.springdemo.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moytri.springdemo.entity.Category;

@Repository
public class CategoryDAO implements ICategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UUID addCategory(Category category) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		UUID id = (UUID) sessionFactory.getCurrentSession().save(category);
		
		sessionFactory.getCurrentSession().flush();
		
		return id;

	}

	@Override
	public void deleteCategory() {
		// TODO Auto-generated method stub

	}

	@Override
	public Category getCategoryById(UUID id) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Category where id=:id");
		
		query.setParameter("id", id);
		
		Category category =  (Category) query.getSingleResult();
		
		return category;
	}

	@Override
	public List<Category> getAllCategories() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Category ORDER BY categoryName");
		
		List<Category> categories = query.getResultList();
		
		return categories;
	}

	@Override
	public UUID updateCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		sessionFactory.getCurrentSession().flush();
		return category.getId();
	}

}
