package fr.epsi.stazi.jpahibernate.dao;

import javax.persistence.EntityManager;

import fr.epsi.stazi.jpahibernate.dao.helper.DatabaseHelper;

public class GenericDao {
	
	private EntityManager entityManager;
	
	public GenericDao() {
		this.entityManager = DatabaseHelper.createEntityManager();
	}
	
	protected EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = DatabaseHelper.createEntityManager();
		}
		return entityManager;
	}
}
