package com.nttdata.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Taller1
 * 
 * DAO genérico (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */
public class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(T obj) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción.
		session.save(obj);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busqueda de todos los registros
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	@Override
	public T searchById(Long id) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busqueda por id
		return session.get(entityClass, id);
	}

	@Override
	public void delete(T obj) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Eliminación
		session.delete(obj);

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void update(T obj) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualización
		session.saveOrUpdate(obj);

		// Commit
		session.getTransaction().commit();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
